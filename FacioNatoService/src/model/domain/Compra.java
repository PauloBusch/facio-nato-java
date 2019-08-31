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
public class Compra {
    private String identifier;
    private String produto;
    private int quantidade;
    
    public void validar() throws ValidacaoException {
        if(produto == null || produto.equals(""))
            throw new ValidacaoException("Campo produto deve ser preenchido");
        
        if(quantidade <= 0)
            throw new ValidacaoException("Campo quantidade deve ser preechido");
    }
    
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        return true;
    }
}
