/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DecimalFormat;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author paulo
 */
public class TMoedas {
    public NumberFormatter formato(String mascara){
        DecimalFormat decimal = new DecimalFormat(mascara);
        NumberFormatter format = new NumberFormatter(decimal);
        format.setFormat(decimal);
        format.setAllowsInvalid(false);
        return format;
    }
    public float converter(String valor, String field) throws ValidacaoException {
        try{
            return Float.parseFloat(valor);
        }catch(NumberFormatException ex){
            throw new ValidacaoException(field + " inválido");
        }
    }
    public String formatar(float valor, String mascara){
        DecimalFormat format = new DecimalFormat(mascara);
        return format.format(valor);
    }
}
