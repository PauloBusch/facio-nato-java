/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;
import model.dao.Conexao;
import model.dao.CrudDao;
import model.dao.PensionatoCrudavel;
import model.dao.QuartoCrudavel;
import model.domain.Pensionato;
import model.domain.Quarto;
import util.observable.IDataPromisse;
import util.observable.IDataSubscribe;
import util.observable.IDataSubscription;

/**
 *
 * @author paulo
 */
public class QuartoRepository {
    public void Save(Quarto quarto){
        QuartoCrudavel crudavel = new QuartoCrudavel(getDb(quarto));
        new CrudDao<>(crudavel).save(quarto);
        
        List<IDataSubscription> subscriptions = new ArrayList<>();
        Quarto quartoSarch = new Quarto();
        quartoSarch.setIdentifier(quarto.getIdentifier());
        subscriptions.add(Search(quartoSarch).subscribe((List<Quarto> quartos) -> {
            quartos.forEach((Quarto quartoByRemove) -> {                    
                if(quartoByRemove.getPensionato().equals(quarto.getPensionato()))
                    return;
                    
                Delete(quartoByRemove);
            });
            subscriptions.forEach((IDataSubscription sub) -> sub.unsubscribe());
        }));
    }
    public void Delete(Quarto quarto){
        QuartoCrudavel crudavel = new QuartoCrudavel(getDb(quarto));
        new CrudDao<>(crudavel).delete(quarto);
    }
    public IDataSubscribe<Quarto> Search(Quarto quarto){ 
        List<IDataSubscription> subscriptions = new ArrayList<>();
        
        if(quarto.getPensionato() != null){
            return (IDataPromisse<Quarto> promisse) -> {
                QuartoCrudavel crudavel = new QuartoCrudavel(getDb(quarto));
                subscriptions.add(new CrudDao<>(crudavel).search(quarto).subscribe((List<Quarto> quartos) -> {
                    quartos.forEach((Quarto q) -> q.setPensionato(quarto.getPensionato()));
                    promisse.complete(quartos);
                }));
                
                return (IDataSubscription) () -> {
                    subscriptions.forEach((IDataSubscription sub) -> sub.unsubscribe());
                };
            };
        }else{        
            return (IDataPromisse<Quarto> promisse) -> {
                subscriptions.add(buscarPensionatos().subscribe((List<Pensionato> pensionatos) -> {
                    List<Quarto> quartosResult = new ArrayList<>();

                    if(pensionatos.isEmpty())
                        promisse.complete(quartosResult);
                    
                    pensionatos.forEach((Pensionato pensionato) -> {
                        Quarto quartoSearch = new Quarto();
                        quartoSearch.setPensionato(pensionato);
                        quartoSearch.setIdentifier(quarto.getIdentifier());
                        subscriptions.add(Search(quartoSearch).subscribe((List<Quarto> quartos) -> {
                            quartos.forEach((Quarto q) -> q.setPensionato(pensionato));
                            quartosResult.addAll(quartos);
                            if(pensionatos.size() == pensionatos.indexOf(pensionato) + 1)
                                promisse.complete(quartosResult);
                        }));
                    });
                }));
                
                return (IDataSubscription) () -> {
                    subscriptions.forEach((IDataSubscription sub) -> sub.unsubscribe());
                };
            };
        }
    }
    public IDataSubscribe<Pensionato> buscarPensionatos(){
        return new PensionatoRepository().Search(new Pensionato());
    }
    public DatabaseReference getDb(Quarto quarto){
        FirebaseDatabase db = Conexao.getDatabase();
        PensionatoCrudavel crudavelPensionato = new PensionatoCrudavel(db);
        return crudavelPensionato.collection().child(quarto.getPensionato().getIdentifier());
    }
}
