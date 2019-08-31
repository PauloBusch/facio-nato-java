/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.domain.Compra;
import repository.CompraRepository;
import util.ValidacaoException;
import util.observable.IDataSubscribe;

/**
 *
 * @author paulo
 */
public class CompraService implements ICompraService {
    private final CompraRepository _compraRepository;
    
    public CompraService(){
        _compraRepository = new CompraRepository();
    }
    
    @Override
    public void Save(Compra compra){
        this._compraRepository.Save(compra);
    }

    @Override
    public void Delete(Compra compra) {
        this._compraRepository.Delete(compra);
    }

    @Override
    public IDataSubscribe<Compra> Search(Compra compra) {
        return this._compraRepository.Search(compra);
    }
}
