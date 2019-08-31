/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.domain.Pensionato;
import repository.PensionatoRepository;
import util.observable.IDataSubscribe;

/**
 *
 * @author paulo
 */
public class PensionatoService implements IPensionatoService {
    private final PensionatoRepository _pensionatoRepository;
    
    public PensionatoService(){
        _pensionatoRepository = new PensionatoRepository();
    }
    
    @Override
    public void Save(Pensionato pensionato){
        _pensionatoRepository.Save(pensionato);
    }
    
    @Override
    public void Delete(Pensionato pensionato){
        _pensionatoRepository.Delete(pensionato);
    }
    
    @Override
    public IDataSubscribe<Pensionato> Search(Pensionato pensionato){
        return _pensionatoRepository.Search(pensionato);
    }
    
}
