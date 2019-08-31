/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.domain.Compra;
import util.observable.IDataSubscribe;

/**
 *
 * @author paulo
 */
public interface ICompraService {
    public void Save(Compra compra);
    public void Delete(Compra compra);
    public IDataSubscribe<Compra> Search(Compra compra); 
}
