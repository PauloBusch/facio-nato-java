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
import service.PensionatoService;
import util.ValidacaoException;

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
    private final PensionatoService pensionatoService;
        
    public PensionatoControl() throws RemoteException{
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
        pensionatosTabela.clear();
        pensionatosTabela.addAll(pensionatoService.Search(pensionatoDigitado));
    }
    public void salvar() throws ValidacaoException, RemoteException{
        pensionatoDigitado.validar();
        pensionatoDigitado.setId(pensionatoService.Save(pensionatoDigitado));
        
        novo();
        pesquisar();
    }
    public void excluir() throws RemoteException{
        pensionatoService.Delete(pensionatoDigitado);
        
        novo();
        pesquisar();
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
