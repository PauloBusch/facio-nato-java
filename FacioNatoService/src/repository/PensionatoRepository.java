/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.Conexao;
import model.domain.Pensionato;

/**
 *
 * @author paulo
 */
public class PensionatoRepository {    
    public Integer Save(Pensionato pensionato){
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        
        pensionato = em.merge(pensionato);
        
        em.persist(pensionato);
        
        em.getTransaction().commit();
        em.close();
        
        return pensionato.getId();
    }
    public void Delete(Pensionato pensionato){
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        
        pensionato = em.merge(pensionato);
        em.remove(pensionato);
        
        em.getTransaction().commit();
        em.close();
    }
    public List<Pensionato> Search(Pensionato pensionato){        
        EntityManager em = Conexao.getEntityManager();
        StringBuffer sql = new StringBuffer("from Pensionato p "
                + "where 1=1 ");        
        
        Map<String, Object> params = new HashMap<String, Object>();
        if(pensionato.getId() != null){        
            sql.append("and  p.id=:id ");
            params.put("id", pensionato.getId());
        }
        if(pensionato.getEndereco() != null &&
                !pensionato.getEndereco().equals("")){        
            sql.append("and p.endereco like :endereco ");
            params.put("endereco", "%"+pensionato.getEndereco()+"%");
        }
        if(pensionato.getTelefone() != null &&
                !pensionato.getTelefone().equals("")){
            sql.append("and p.telefone like :telefone ");
            params.put("telefone", "%"+pensionato.getTelefone()+"%");
        }
        
        Query query = em.createQuery(sql.toString());   
        params.keySet().stream().forEach((key) -> {
            query.setParameter(key, params.get(key));
        });
        
        return query.getResultList();
    }
}
