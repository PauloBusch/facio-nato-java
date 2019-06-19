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
public class Curso implements Serializable {
    private String nome;

    public Curso() {
    }
    
    public void validar() throws ValidacaoException{
        if(nome == null || nome.equals(""))
            throw new ValidacaoException("O campo Curso deve ser preenchido");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
