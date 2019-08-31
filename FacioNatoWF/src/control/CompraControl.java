/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import model.domain.Compra;
import model.service.ServiceLocator;
import org.jdesktop.observablecollections.ObservableCollections;
import service.ICompraService;
import util.ValidacaoException;
import util.observable.IDataSubscription;

/**
 *
 * @author paulo
 */
public final class CompraControl {
    private final PropertyChangeSupport propertyChangeSupport = 
        new PropertyChangeSupport(this);
    
    private Compra compraDigitado;
    private Compra compraSelecionado;
    private List<Compra> comprasTabela;
    
    private final ICompraService compraService;
    
    private final List<IDataSubscription> searchCompras;
    
    public CompraControl(){
        searchCompras = new ArrayList<>();
        compraService = ServiceLocator.getCompraService();
        
        comprasTabela = ObservableCollections.observableList(
                new ArrayList<Compra>());
        
        novo();
        pesquisar();
    }
    public void novo(){
        setCompraDigitado(new Compra());
    }
    public void salvar() throws ValidacaoException{
        compraDigitado.validar();
        compraService.Save(compraDigitado);
        
        novo();
    }
    public void excluir(){
        compraService.Delete(compraDigitado);
        
        novo();
    }
    public void pesquisar(){
        searchCompras.forEach((IDataSubscription s) -> s.unsubscribe());
        searchCompras.add(compraService.Search(compraDigitado).subscribe((List<Compra> compras) -> {
            comprasTabela.clear();
            comprasTabela.addAll(compras);
        }));
    }
    
    public void fechar(){
        searchCompras.forEach((IDataSubscription s) -> s.unsubscribe());
    }

    public Compra getCompraDigitado() {
        return compraDigitado;
    }

    public void setCompraDigitado(Compra compraDigitado) {
        Compra oldCompraDigitado = this.compraDigitado;
        if(!compraDigitado.equals(this.compraDigitado))
            this.compraDigitado = compraDigitado;
        
        propertyChangeSupport.firePropertyChange(
                "compraDigitado", oldCompraDigitado, compraDigitado);
    }

    public Compra getCompraSelecionado() {
        return compraSelecionado;
    }

    public void setCompraSelecionado(Compra compraSelecionado) {
        this.compraSelecionado = compraSelecionado;
        if(this.compraSelecionado != null)
            setCompraDigitado(this.compraSelecionado);
    }

    public List<Compra> getComprasTabela() {
        return comprasTabela;
    }

    public void setComprasTabela(List<Compra> comprasTabela) {
        this.comprasTabela = comprasTabela;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }  
}
