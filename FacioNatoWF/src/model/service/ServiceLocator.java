/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.rmi.Naming;
import java.rmi.RemoteException;
import service.PensionatoService;

/**
 *
 * @author paulo
 */
public class ServiceLocator {
    public static PensionatoService getPensionatoService()  throws RemoteException{
        try{
            return (PensionatoService)Naming.lookup(PensionatoService.URL_SERVICO);
        }catch(Exception e){
            throw new RemoteException(e.getMessage());
        }
    }
}
