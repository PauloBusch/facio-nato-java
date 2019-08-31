/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import java.util.Map;

/**
 *
 * @author paulo
 */
public interface ICrudavel<Type>{
    DatabaseReference collection();
    String getIdentifier(Type obj);
    void setIdentifier(Type obj, String identifier);
    Class<Type> getTypeClass();
    Query search(DatabaseReference ref, Type obj);
    Map<String, Object> fields(Type obj);
}
