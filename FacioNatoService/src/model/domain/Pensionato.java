/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name="PENSIONATO")
public class Pensionato implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="ENDERECO", length = 255, nullable = false)
    private String endereco;
    
    @Column(name="TELEFONE", length = 20)
    private String telefone;
    
    @Column(name="QTD_QUARTOS", nullable = false)
    private int quartos;

    public Pensionato() {
    }
    
    public void validar() throws ValidacaoException{
        if(endereco == null || endereco.equals(""))
            throw new ValidacaoException("Campo Endereço deve ser preenchido");
        
        if(endereco.length() > 255)
            throw new ValidacaoException("Endereço muito extenso");
           
        if(telefone == null || telefone.length() > 20)
            throw new ValidacaoException("Telefone muito extenso");
        
        if(quartos < 1)
            throw new ValidacaoException("Quantidade de quartos insulficiente");
            
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Pensionato other = (Pensionato) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return endereco;
    }
}
