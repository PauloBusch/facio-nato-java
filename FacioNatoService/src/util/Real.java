/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author paulo
 */
public class Real {
    private static TMoedas _moedas;
    private static final String marcara = "###,##0.00";
    public static DefaultFormatterFactory formato(){
        if(_moedas == null)
            _moedas = new TMoedas();
    
        return new DefaultFormatterFactory(_moedas.formato(marcara));
    }
    public static String formatar(float valor){
        if(_moedas == null)
            _moedas = new TMoedas();
    
        return _moedas.formatar(valor, marcara);
    } 
    public static float converter(String valor, String field) throws ValidacaoException {
        if(_moedas == null)
            _moedas = new TMoedas();
        
        String _valor = valor.replace(".", "").replace(",", ".");
        return _moedas.converter(_valor, field);
    }
}
