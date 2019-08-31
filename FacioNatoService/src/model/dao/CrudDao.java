/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import util.observable.IDataSubscribe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import util.observable.IDataPromisse;
import util.observable.IDataSubscription;
/*
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
/**
 *
 * @author paulo
 */
public class CrudDao<Type> implements ICrudDao<Type>{
    private final ICrudavel<Type> _crudavel;    
    public CrudDao(ICrudavel<Type> crudavel){
        this._crudavel = crudavel;
    }

    @Override
    public void delete(Type obj) {
        DatabaseReference db = _crudavel.collection();
        db.child(_crudavel.getIdentifier(obj)).removeValueAsync();
    }

    @Override
    public IDataSubscribe<Type> search(Type obj) {
        DatabaseReference db = _crudavel.collection();
        
        boolean isCollection = _crudavel.getIdentifier(obj) == null;
        Query query = isCollection ? _crudavel.search(db, obj) : db.child(_crudavel.getIdentifier(obj));

        return (IDataPromisse<Type> promisse) -> {
            ValueEventListener event = new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot ds) {
                    Class<Type> type = _crudavel.getTypeClass();
                    ArrayList<Type> list = new ArrayList<>();
                    
                    Type obj1 = obj;

                    if(!isCollection){
                        Type item = ds.getValue(type);
                        _crudavel.setIdentifier(item, ds.getKey());
                        list.add(item);
                        promisse.complete(list);
                        return;
                    }

                    for (DataSnapshot row: ds.getChildren()){
                        Type item = row.getValue(type);
                        _crudavel.setIdentifier(item, row.getKey());
                        list.add(item);
                    }

                    promisse.complete(list);
                }

                @Override
                public void onCancelled(DatabaseError de) { }
            };
            
            query.addValueEventListener(event);
            
            return (IDataSubscription) () -> {
                query.removeEventListener(event);
            };
        };
    }

    @Override
    public void save(Type obj) {
        DatabaseReference db = _crudavel.collection();
        if(_crudavel.getIdentifier(obj) == null){
            String identifier = db.push().getKey();
            db.child(identifier).setValueAsync(obj);
            _crudavel.setIdentifier(obj, identifier);
        } else {
            db.child(_crudavel.getIdentifier(obj)).updateChildrenAsync(_crudavel.fields(obj));
        }
    }
    
}
