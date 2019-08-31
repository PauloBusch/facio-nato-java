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
import model.domain.Compra;

/**
 *
 * @author paulo
 */
public class CompraCrudavel implements ICrudavel<Compra>{
    
    private final FirebaseDatabase _database;
    public CompraCrudavel(FirebaseDatabase database){
        this._database = database;
    }

    @Override
    public DatabaseReference collection() {
        return this._database.getReference("compras");
    }

    @Override
    public String getIdentifier(Compra compra) {
        return compra.getIdentifier();
    }

    @Override
    public void setIdentifier(Compra compra, String identifier) {
        compra.setIdentifier(identifier);
    }

    @Override
    public Class<Compra> getTypeClass() {
        return Compra.class;
    }

    @Override
    public Query search(DatabaseReference ref, Compra compra) {                
        if(compra.getProduto() != null)
            return ref.orderByChild("produto").startAt(compra.getProduto());
        
        if(compra.getQuantidade() > 0)
            return ref.orderByChild("quantidade").equalTo(compra.getQuantidade());
                
        return ref.orderByKey();
    }

    @Override
    public Map<String, Object> fields(Compra compra) {
        Map<String, Object> map = new HashMap<>();
        
        if(compra.getProduto()!= null)
            map.put("produto", compra.getProduto());
        
        if(compra.getQuantidade() > 0)
            map.put("quantidade", compra.getQuantidade());
        
        return map;
    }
    
}
