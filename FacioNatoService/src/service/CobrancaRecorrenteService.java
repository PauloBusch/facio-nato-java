/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.domain.CobrancaRecorrente;
import repository.CobrancaRecorrenteRepository;

/**
 *
 * @author paulo
 */
public class CobrancaRecorrenteService implements ICobrancaRecorrenteService {
    private final CobrancaRecorrenteRepository _cobrancaRecorrenteRepository;
    
    public CobrancaRecorrenteService(){
        _cobrancaRecorrenteRepository = new CobrancaRecorrenteRepository();
    }

    @Override
    public Integer Save(CobrancaRecorrente cobrancaRecorrente){
        return _cobrancaRecorrenteRepository.Save(cobrancaRecorrente);
    }

    @Override
    public CobrancaRecorrente Get(){
        return _cobrancaRecorrenteRepository.Get();
    }
}
