/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Objects;
import util.ValidacaoException;
/**
 *
 * @author paulo
 */
public class Pensionato {
    private String identifier;
    private String endereco;
    private String telefone;
    private float valorPadrao;    
    private int qtdQuartos;

    public Pensionato() {
    }
            
    public void validar() throws ValidacaoException{
        if(endereco == null || endereco.equals(""))
            throw new ValidacaoException("Campo Endereço deve ser preenchido");
        
        if(endereco.length() > 255)
            throw new ValidacaoException("Endereço muito extenso");
           
        if(telefone == null || telefone.length() > 20)
            throw new ValidacaoException("Campo Telefone deve ser preenchido");
        
        if(valorPadrao <= 0)
            throw new ValidacaoException("Campo Valor Padrão deve ser preenchido");
        
        if(qtdQuartos < 1)
            throw new ValidacaoException("Quantidade de quartos insulficiente");
            
    }
        
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getQtdQuartos() {
        return qtdQuartos;
    }
    
    public void setQtdQuartos(int qtdQuartos) {
        this.qtdQuartos = qtdQuartos;
    }
    
    public float getValorPadrao() {
        return valorPadrao;
    }

    public void setValorPadrao(float valorPadrao) {
        this.valorPadrao = valorPadrao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pensionato other = (Pensionato) obj;
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return endereco;
    }
}
