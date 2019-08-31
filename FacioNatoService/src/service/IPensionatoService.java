/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.domain.Pensionato;
import util.observable.IDataSubscribe;

/**
 *
 * @author paulo
 */
public interface IPensionatoService {
    public void Save(Pensionato pensionato);
    public void Delete(Pensionato pensionato);
    public IDataSubscribe<Pensionato> Search(Pensionato pensionato); 
}
