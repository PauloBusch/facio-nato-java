/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import java.util.HashMap;
import java.util.Map;
import model.domain.Pensionato;
/*
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author paulo
 */
public class PensionatoCrudavel implements ICrudavel<Pensionato> {
    
    private final FirebaseDatabase _database;
    public PensionatoCrudavel(FirebaseDatabase database){
        this._database = database;
    }
    
    @Override
    public DatabaseReference collection() {
        return _database.getReference("pensionatos");
    }
    
    @Override
    public String getIdentifier(Pensionato obj) {
        return obj.getIdentifier();
    }
    
    @Override
    public void setIdentifier(Pensionato obj, String identifier) {
        obj.setIdentifier(identifier);
    }
    
    @Override
    public Map<String, Object> fields(Pensionato pensionato) {
        Map<String, Object> map = new HashMap<>();
        
        if(pensionato.getEndereco() != null)
            map.put("endereco", pensionato.getEndereco());
        if(pensionato.getTelefone() != null)
            map.put("telefone", pensionato.getTelefone());
        if(pensionato.getQtdQuartos() > 0)
            map.put("qtdQuartos", pensionato.getQtdQuartos());
        
        if(pensionato.getValorPadrao()> 0)
            map.put("valorPadrao", pensionato.getValorPadrao());
        
        return map;
    }
    
    @Override
    public Class<Pensionato> getTypeClass() {
        return Pensionato.class;
    }

    @Override
    public Query search(DatabaseReference ref, Pensionato pensionato) {
        if(pensionato.getIdentifier() != null)
            return ref.equalTo(pensionato.getIdentifier());
                
        if(pensionato.getEndereco() != null)
            return ref.orderByChild("endereco").startAt(pensionato.getEndereco());
        
        if(pensionato.getTelefone() != null)
            return ref.orderByChild("telefone").startAt(pensionato.getTelefone());
        
        if(pensionato.getQtdQuartos() > 0)
            return ref.orderByChild("qtdQuartos").equalTo(pensionato.getQtdQuartos());
                
        return ref.orderByKey();
    }
}
