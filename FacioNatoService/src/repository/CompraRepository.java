/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.google.firebase.database.FirebaseDatabase;
import model.dao.CompraCrudavel;
import model.dao.Conexao;
import model.dao.CrudDao;
import model.domain.Compra;
import util.ValidacaoException;
import util.observable.IDataSubscribe;

/**
 *
 * @author paulo
 */
public class CompraRepository {
    public void Save(Compra compra){
        FirebaseDatabase db = Conexao.getDatabase();
        CompraCrudavel crudavel = new CompraCrudavel(db);
        new CrudDao<>(crudavel).save(compra);
    }
    public void Delete(Compra compra){
        FirebaseDatabase db = Conexao.getDatabase();
        CompraCrudavel crudavel = new CompraCrudavel(db);
        new CrudDao<>(crudavel).delete(compra);
    }
    public IDataSubscribe<Compra> Search(Compra compra){
        FirebaseDatabase db = Conexao.getDatabase();
        CompraCrudavel crudavel = new CompraCrudavel(db);
        return new CrudDao<>(crudavel).search(compra);
    }
}
