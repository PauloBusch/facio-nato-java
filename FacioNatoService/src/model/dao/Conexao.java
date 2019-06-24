/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author paulo
 */
public class Conexao {
    private static EntityManagerFactory emf;
    private static Conexao conexao;
    
    public Conexao(){
        emf = Persistence.createEntityManagerFactory("FacioNatoServicePU");
    }
    public synchronized static EntityManager getEntityManager(){
        if(conexao == null)
            conexao = new Conexao();
        
        return emf.createEntityManager();
    }
}
