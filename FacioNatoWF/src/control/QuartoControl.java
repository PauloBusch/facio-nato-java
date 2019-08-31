/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import model.domain.Pensionato;
import model.domain.Quarto;
import model.service.ServiceLocator;
import org.jdesktop.observablecollections.ObservableCollections;
import service.IQuartoService;
import util.Real;
import util.ValidacaoException;
import util.observable.IDataSubscription;


/**
 *
 * @author paulo
 */
public final class QuartoControl {
    private final PropertyChangeSupport propertyChangeSupport = 
        new PropertyChangeSupport(this);
    
    private Quarto quartoDigitado;
    private Quarto quartoSelecionado;
    private List<Quarto> quartosTabela;
    private List<Pensionato> pensionatosTabela; 
    private final IQuartoService quartoService;
    
    private String valor;
    List<IDataSubscription> searchQuartos;
    IDataSubscription searchPensionato;

    public QuartoControl() throws RemoteException{
        searchQuartos = new ArrayList<>();
        quartoService = ServiceLocator.getQuartoService();
        quartosTabela = ObservableCollections.observableList(
                new ArrayList<Quarto>());
        pensionatosTabela = ObservableCollections.observableList(
                new ArrayList<Pensionato>());
        searchPensionato = quartoService.buscarPensionatos().subscribe((List<Pensionato> pensionatos) -> {
            pensionatosTabela.clear();
            pensionatosTabela.addAll(pensionatos);
        });
        
        novo();
        pesquisar();
    }
    public void novo(){
        setQuartoDigitado(new Quarto());
    }
    public void salvar() throws ValidacaoException, RemoteException{
        quartoDigitado.setValor(Real.converter(valor, "Valor"));
        quartoDigitado.validar();
        quartoService.Save(quartoDigitado);
    
        novo();
    }
    public void excluir() throws RemoteException{
        quartoService.Delete(quartoDigitado);
        
        novo();
    }
    public void pesquisar() throws RemoteException {
        searchQuartos.forEach((IDataSubscription s) -> s.unsubscribe());
        searchQuartos.add(quartoService.Search(quartoDigitado).subscribe((List<Quarto> quartos) -> {
            quartosTabela.clear();
            quartosTabela.addAll(quartos);
        }));
    }
    
    public void fechar(){
        searchPensionato.unsubscribe();
        searchQuartos.forEach((IDataSubscription s) -> s.unsubscribe());
    }
    
    public void atualizarValor(){
        if(this.quartoDigitado == null || this.quartoDigitado.getPensionato() == null)
            return;
            
        Pensionato pensionato = this.quartoDigitado.getPensionato();
        String oldValor = this.valor;
        String newValor = Real.formatar(pensionato.getValorPadrao());
        if(!newValor.equals(oldValor))
            this.valor = newValor;
        propertyChangeSupport.firePropertyChange("valor", oldValor, newValor);
    }
    
    public void setValor(String valor){
        this.valor = valor;
    }
    
    public String getValor(){
        return valor;
    }
    
    public Quarto getQuartoDigitado() {
        return quartoDigitado;
    }
    
    public void setQuartoDigitado(Quarto quartoDigitado) {
        Quarto oldQuartoDigitado = this.quartoDigitado;
        if(!quartoDigitado.equals(this.quartoDigitado))
            this.quartoDigitado = quartoDigitado;
        
        propertyChangeSupport.firePropertyChange(
                "quartoDigitado", oldQuartoDigitado, quartoDigitado);
            
        float oldValorF = oldQuartoDigitado == null ? 0f : oldQuartoDigitado.getValor();
        String oldValor = Real.formatar(oldValorF);
        String newValor = Real.formatar(quartoDigitado.getValor());
        if(!newValor.equals(oldValor))
            this.valor = newValor;
        
        propertyChangeSupport.firePropertyChange("valor", oldValor, newValor);
    }

    public Quarto getQuartoSelecionado() {
        return quartoSelecionado;
    }

    public void setQuartoSelecionado(Quarto quartoSelecionado) {
        this.quartoSelecionado = quartoSelecionado;
        if(this.quartoSelecionado != null)
            setQuartoDigitado(this.quartoSelecionado);
    }

    public List<Quarto> getQuartosTabela() {
        return quartosTabela;
    }

    public void setQuartosTabela(List<Quarto> quartosTabela) {
        this.quartosTabela = quartosTabela;
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
