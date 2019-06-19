/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.io.Serializable;
import util.ValidacaoException;



/**
 *
 * @author paulo
 */
public class Cidade implements Serializable {
    private String nome;

    public Cidade() {
    }
    
    public void validar() throws ValidacaoException {
        if(nome == null || nome.equals(""))
            throw new ValidacaoException("Campo Cidade deve ser preenchido");
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
