/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import service.ICobrancaRecorrenteService;
import service.IPensionatoService;
import service.IQuartoService;
import service.ICompraService;
import service.CobrancaRecorrenteService;
import service.CompraService;
import service.PensionatoService;
import service.QuartoService;

/**
 *
 * @author paulo
 */
public class ServiceLocator {
    public static IPensionatoService getPensionatoService(){
        return new PensionatoService();
    }
    public static IQuartoService getQuartoService(){
        return new QuartoService();
    }
    public static ICobrancaRecorrenteService getCobrancaRecorrenteService(){
        return new CobrancaRecorrenteService();
    }
    public static ICompraService getCompraService(){
        return new CompraService();
    }
}
