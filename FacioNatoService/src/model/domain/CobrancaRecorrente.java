/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.io.Serializable;
import java.util.Objects;
import util.ValidacaoException;

/**
 *
 * @author paulo
 */
public class CobrancaRecorrente implements Serializable{
    private Integer id;
    private float valor;
    private Frequencia frequencia;
    private int dataRef;

    public CobrancaRecorrente() {
    }
    
    public void validar() throws ValidacaoException{
        if(valor <= 0.0)
            throw new ValidacaoException("Campo Valor deve ter valor positivo");
        
        if(frequencia == null)            
            throw new ValidacaoException("Um valor de frequência deve ser informado");
        
        switch(frequencia){
            case SEMANAL:
                if(dataRef < 0 || dataRef > 6)
                    throw new ValidacaoException("Data inválida para a primeira cobrança");
                break;
            case MENSAL:
                if(dataRef < 0 || dataRef > 31)
                    throw new ValidacaoException("Data inválida para a primeira cobrança");
                break;
            case ANUAL:
                if(dataRef < 0 || dataRef > 11)
                    throw new ValidacaoException("Data inválida para a primeira cobrança");
                break;
        }        
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

    public int getData() {
        return dataRef;
    }

    public void setData(int dataRef) {
        this.dataRef = dataRef;
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
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.frequencia, other.frequencia)) {
            return false;
        }
        if (!Objects.equals(this.dataRef, other.dataRef)) {
            return false;
        }
        return true;
    }
}
