/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import java.util.HashMap;
import java.util.Map;
import model.domain.Quarto;

/**
 *
 * @author paulo
 */
public class QuartoCrudavel implements ICrudavel<Quarto>{
    private final DatabaseReference _database;
    public QuartoCrudavel(DatabaseReference database){
        this._database = database;
    }

    @Override
    public DatabaseReference collection() {
        return _database.child("quartos");
    }

    @Override
    public String getIdentifier(Quarto quarto) {
        return quarto.getIdentifier();
    }

    @Override
    public void setIdentifier(Quarto quarto, String identifier) {
        quarto.setIdentifier(identifier);
    }
    
    @Override
    public Class<Quarto> getTypeClass() {
        return Quarto.class;
    }

    @Override
    public Query search(DatabaseReference ref, Quarto quarto) {
        if(quarto.getNome() != null)
            return ref.child("nome").equalTo(quarto.getNome());
        return ref.orderByKey();
    }

    @Override
    public Map<String, Object> fields(Quarto quarto) {
        Map<String, Object> map = new HashMap<>();
        
        if(quarto.getNome()!= null)
            map.put("nome", quarto.getNome());
        if(quarto.getValor() > 0)
            map.put("valor", quarto.getValor());
        if(quarto.getDescricao()!= null)
            map.put("descricao", quarto.getDescricao());
        
        return map;
    }
}
