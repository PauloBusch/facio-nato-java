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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import util.ValidacaoException;

/**
 *
 * @author paulo
 */
@Entity
@Table(name="DESPESA")
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="VALOR", nullable = false)
    private float valor;
    
    @ManyToOne
    @JoinColumn(name="ID_COMPROVANTE", nullable = false)
    private Comprovante comprovante;

    public Despesa() {
    }
    
    public void validar() throws ValidacaoException{
        if(valor <= 0.0)
            throw new ValidacaoException("Campo Valor deve ter valor positivo");
        
        if(comprovante == null)
            throw new ValidacaoException("Um comprovante deve ser anexado");
        
        comprovante.validar();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Comprovante getComprovante() {
        return comprovante;
    }

    public void setComprovante(Comprovante comprovante) {
        this.comprovante = comprovante;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Despesa other = (Despesa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
