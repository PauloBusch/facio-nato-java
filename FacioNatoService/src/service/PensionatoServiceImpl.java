/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.domain.Pensionato;
import repository.PensionatoRepository;

/**
 *
 * @author paulo
 */
public class PensionatoServiceImpl extends UnicastRemoteObject
    implements PensionatoService {
    private PensionatoRepository pensionatoRepository;
    
    public PensionatoServiceImpl() throws RemoteException{
        try{
            pensionatoRepository = new PensionatoRepository();
        }catch(Exception e){
            throw new RemoteException(e.getMessage());
        }    
    }

    public Integer Save(Pensionato pensionato) throws RemoteException{
        try{
            return pensionatoRepository.Save(pensionato);
        }catch(Exception e){
            throw new RemoteException(e.getMessage());
        }    
    }
    public void Delete(Pensionato pensionato) throws RemoteException{
        try{
            pensionatoRepository.Delete(pensionato);
        }catch(Exception e){
            throw new RemoteException(e.getMessage());
        }
    }
    public List<Pensionato> Search(Pensionato pensionato) throws RemoteException{
        try{
            return pensionatoRepository.Search(pensionato);
        }catch(Exception e){
            throw new RemoteException(e.getMessage());
        }
    }
    
}
