/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.domain.Pensionato;
import model.domain.Quarto;
import repository.QuartoRepository;
import util.observable.IDataSubscribe;

/**
 *
 * @author paulo
 */
public class QuartoService implements IQuartoService{
    
    private final QuartoRepository _quartoRepository;
    
    public QuartoService(){
        _quartoRepository = new QuartoRepository();
    }
    
    @Override
    public void Save(Quarto quarto){
        _quartoRepository.Save(quarto);
    }

    @Override
    public void Delete(Quarto quarto){
        _quartoRepository.Delete(quarto);
    }

    @Override
    public IDataSubscribe<Quarto> Search(Quarto quarto){
        return _quartoRepository.Search(quarto);
    }

    @Override
    public IDataSubscribe<Pensionato> buscarPensionatos(){
        return _quartoRepository.buscarPensionatos();
    }
}
