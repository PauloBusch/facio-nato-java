/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.google.firebase.database.FirebaseDatabase;
import model.dao.Conexao;
import model.dao.CrudDao;
import model.dao.PensionatoCrudavel;
import model.domain.Pensionato;
import util.observable.IDataSubscribe;
/**
 *
 * @author paulo
 */
public class PensionatoRepository {    
    
    public void Save(Pensionato pensionato){
        FirebaseDatabase db = Conexao.getDatabase();
        PensionatoCrudavel crudavel = new PensionatoCrudavel(db);
        new CrudDao<>(crudavel).save(pensionato);
    }
    public void Delete(Pensionato pensionato){
        FirebaseDatabase db = Conexao.getDatabase();
        PensionatoCrudavel crudavel = new PensionatoCrudavel(db);
        new CrudDao<>(crudavel).delete(pensionato);
    }
    public IDataSubscribe<Pensionato> Search(Pensionato pensionato){
        FirebaseDatabase db = Conexao.getDatabase();
        PensionatoCrudavel crudavel = new PensionatoCrudavel(db);
        return new CrudDao<>(crudavel).search(pensionato);
    }
}
