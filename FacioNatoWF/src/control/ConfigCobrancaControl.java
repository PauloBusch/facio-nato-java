/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import model.domain.CobrancaRecorrente;
import model.service.ServiceLocator;
import service.ICobrancaRecorrenteService;
import util.ValidacaoException;

/**
 *
 * @author paulo
 */
public final class ConfigCobrancaControl {
    private final PropertyChangeSupport propertyChangeSupport = 
        new PropertyChangeSupport(this);
    
    private CobrancaRecorrente cobrancaRecorrenteDigitado;
    private final ICobrancaRecorrenteService cobrancaRecorrenteService;
    
    public ConfigCobrancaControl() throws RemoteException{
        cobrancaRecorrenteService = ServiceLocator.getCobrancaRecorrenteService();
        
        restaurar();
    }
    public void salvar() throws ValidacaoException, RemoteException { 
        cobrancaRecorrenteDigitado.validar();
        cobrancaRecorrenteService.Save(cobrancaRecorrenteDigitado);
    }
    public void restaurar() throws RemoteException{
        setCobrancaRecorrente(cobrancaRecorrenteService.Get());
    }

    public CobrancaRecorrente getCobrancaRecorrente() {
        return cobrancaRecorrenteDigitado;
    }

    public void setCobrancaRecorrente(CobrancaRecorrente cobrancaRecorrenteDigitado) {
        CobrancaRecorrente oldCobrancaRecorrente = this.cobrancaRecorrenteDigitado;
        if(!cobrancaRecorrenteDigitado.equals(this.cobrancaRecorrenteDigitado))
            this.cobrancaRecorrenteDigitado = cobrancaRecorrenteDigitado;
        
        propertyChangeSupport.firePropertyChange(
                "configDigitado", oldCobrancaRecorrente, cobrancaRecorrenteDigitado);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }   
}
