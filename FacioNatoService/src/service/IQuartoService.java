/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.domain.Pensionato;
import model.domain.Quarto;
import util.observable.IDataSubscribe;

/**
 *
 * @author paulo
 */
public interface IQuartoService {
    public void Save(Quarto quarto);
    public void Delete(Quarto quarto);
    public IDataSubscribe<Quarto> Search(Quarto quarto); 
    public IDataSubscribe<Pensionato> buscarPensionatos();
}
