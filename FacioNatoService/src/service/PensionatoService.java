/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domain.Pensionato;

/**
 *
 * @author paulo
 */
public interface PensionatoService extends Remote {
    static final String NOME_SERVICO = "ServicoPensionato";
    static final String URL_SERVICO = "rmi://127.0.0.1/" + NOME_SERVICO;
    
    public Integer Save(Pensionato pensionato) throws RemoteException;
    public void Delete(Pensionato pensionato) throws RemoteException;
    public List<Pensionato> Search(Pensionato pensionato) throws RemoteException; 
}
