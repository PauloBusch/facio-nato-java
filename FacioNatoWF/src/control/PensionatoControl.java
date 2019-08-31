/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import model.domain.Pensionato;
import java.util.ArrayList;
import java.util.List;
import model.service.ServiceLocator;
import org.jdesktop.observablecollections.ObservableCollections;
import service.IPensionatoService;
import util.Real;
import util.ValidacaoException;
import util.observable.IDataSubscription;

/**
 *
 * @author paulo
 */
public final class PensionatoControl {
    private final PropertyChangeSupport propertyChangeSupport = 
        new PropertyChangeSupport(this);
    
    private Pensionato pensionatoSelecionado;
    private Pensionato pensionatoDigitado;
    private List<Pensionato> pensionatosTabela;
    private final IPensionatoService pensionatoService;
    
    private String valorPadrao;
    List<IDataSubscription> searchPensionatos;
        
    public PensionatoControl() throws RemoteException{
        searchPensionatos = new ArrayList<>();
        pensionatoService = ServiceLocator.getPensionatoService();
        pensionatosTabela = ObservableCollections.observableList(
                new ArrayList<Pensionato>());
        
        novo();
        pesquisar();
    }
    public void novo(){
        setPensionatoDigitado(new Pensionato());
    }
    public void pesquisar() throws RemoteException{
        searchPensionatos.forEach((IDataSubscription s) -> s.unsubscribe());
        searchPensionatos.add(pensionatoService.Search(pensionatoDigitado).subscribe((List<Pensionato> list) -> {
            pensionatosTabela.clear();
            pensionatosTabela.addAll(list);
        }));
    }
    
    public void salvar() throws ValidacaoException, RemoteException{
        pensionatoDigitado.setValorPadrao(Real.converter(valorPadrao, "Valor Padrão"));
        pensionatoDigitado.validar();
        pensionatoService.Save(pensionatoDigitado);
        
        novo();
    }
    public void excluir() throws RemoteException{
        pensionatoService.Delete(pensionatoDigitado);
        
        novo();
    }
    
    public void fechar(){
        searchPensionatos.forEach((IDataSubscription s) -> s.unsubscribe());
    }
    
    public String getValorPadrao() {
        return valorPadrao;
    }
    
    public void setValorPadrao(String valorPadrao) {
        this.valorPadrao = valorPadrao;
    }
    
    public Pensionato getPensionatoSelecionado() {
        return pensionatoSelecionado;
    }

    public void setPensionatoSelecionado(Pensionato pensionatoSelecionado) {
        this.pensionatoSelecionado = pensionatoSelecionado;
        if(this.pensionatoSelecionado != null){
            setPensionatoDigitado(pensionatoSelecionado);
        }
    }
    
    public Pensionato getPensionatoDigitado() {
        
        return pensionatoDigitado;
    }
    
    public void setPensionatoDigitado(Pensionato pensionatoDigitado) {
        Pensionato oldPensionatoDigitado = this.pensionatoDigitado;
        if(!pensionatoDigitado.equals(oldPensionatoDigitado))
            this.pensionatoDigitado = pensionatoDigitado;
        
        propertyChangeSupport.firePropertyChange(
                "pensionatoDigitado", oldPensionatoDigitado, pensionatoDigitado);
        
        float oldValorPadraoF = oldPensionatoDigitado == null ? 0f : oldPensionatoDigitado.getValorPadrao();
        String oldValorPadrao = Real.formatar(oldValorPadraoF);
        String newValorPadrao = Real.formatar(pensionatoDigitado.getValorPadrao());
        if(!newValorPadrao.equals(oldValorPadrao))
            this.valorPadrao = newValorPadrao;
        
        propertyChangeSupport.firePropertyChange("valorPadrao", oldValorPadrao, newValorPadrao);
    }

    public List<Pensionato> getPensionatosTabela() {
        return pensionatosTabela;
    }

    public void setPensionatosTabela(List<Pensionato> pensionatosTabela) {
        this.pensionatosTabela = pensionatosTabela;
    }
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }
}
