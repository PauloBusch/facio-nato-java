/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import util.ValidacaoException;

/**
 *
 * @author paulo
 */
public class FormaPagamento {
    private String nome;

    public FormaPagamento() {
    }
    
    public void validar() throws ValidacaoException{
        if(nome == null || nome.equals(""))
            throw new ValidacaoException("Deve ser informada uma forma de pagamento");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
}
