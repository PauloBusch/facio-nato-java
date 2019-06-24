/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import service.PensionatoService;
import service.PensionatoServiceImpl;

/**
 *
 * @author paulo
 */
public class Principal {
    public static void main(String arg[]){    
        try{
            System.out.println("Tentando subir o serviço");

            LocateRegistry.createRegistry(1099);
            Naming.rebind(PensionatoService.NOME_SERVICO, new PensionatoServiceImpl());
            System.out.println("Serviço rodando");
        }catch(Exception e){
            System.out.println("Erro ao subir o serviço: " + e.getMessage());
        }
    }
}
