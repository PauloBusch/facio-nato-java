/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import util.ValidacaoException;

/**
 *
 * @author paulo
 */
@Entity
@Table(name="COMPRA")
public class Compra implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public int id;
    
    @Column(name="PRODUTO", nullable = false)
    public String produto;
    
    @Column(name="QUANTIDADE", nullable = false)
    public int quantidade;

    public Compra() {
    }
    
    public void validar() throws ValidacaoException{
        if(produto == null || produto.equals(""))
            throw new ValidacaoException("Nome do produto deve ser informado");
        
        if(quantidade <= 0)
            throw new ValidacaoException("Quantidade insulficiente");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        return hash;
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
