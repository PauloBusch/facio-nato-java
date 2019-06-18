/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import util.ValidacaoException;

/**
 *
 * @author paulo
 */
@Entity
@Table(name="COBRANCA_RECORRENTE")
public class CobrancaRecorrente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="VALOR", nullable = false)
    private float valor;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name="FREQUENCIA", nullable = false)
    private Frequencia frequencia;
    
    @Temporal(TemporalType.DATE)
    @Column(name="DATA", nullable = false)
    private Date data;

    public CobrancaRecorrente() {
    }
    
    public void validar() throws ValidacaoException{
        if(valor <= 0.0)
            throw new ValidacaoException("Campo Valor deve ter valor positivo");
        
        if(frequencia == null)            
            throw new ValidacaoException("Um valor de frequência deve ser informado");
        
        if(data == null)
            throw new ValidacaoException("Campo Data deve ser preenchido");
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

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final CobrancaRecorrente other = (CobrancaRecorrente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
