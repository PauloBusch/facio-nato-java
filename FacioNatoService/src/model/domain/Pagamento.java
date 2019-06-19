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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import util.ValidacaoException;

/**
 *
 * @author paulo
 */
@Entity
@Table(name="PAGAMENTO")
public class Pagamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="VALOR", nullable = false)
    private float valor;
    
    @ManyToOne
    @JoinColumn(name="ID_INQUILINO", nullable = false)
    private Inquilino inquilino;
    
    @OneToOne
    @JoinColumn(name="ID_COMPROVANTE", nullable = false)
    private Comprovante comprovante;
    
    @ManyToOne
    @JoinColumn(name="ID_COBRANCA", nullable = false)
    private CobrancaRecorrente cobranca;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name="SITUACAO", nullable = false)
    private SituacaoPagamento situacao;
    
    @Temporal(TemporalType.DATE)
    @Column(name="DATA", nullable = false)
    private Date data;

    public Pagamento() {
    }
    
    public void validar() throws ValidacaoException{
        if(valor <= 0.0)
            throw new ValidacaoException("Campo Valor deve ser positivo");
        
        if(inquilino == null)
            throw new ValidacaoException("Deve ser selecionado um inquilino");
        
        if(comprovante == null)
            throw new ValidacaoException("Um comprovante deve ser anexado");
        
        if(cobranca == null)
            throw new ValidacaoException("Deve ser configurada a cobrança recorrente");
        
        if(situacao == null)
            throw new ValidacaoException("Uma situação para o pagamento deve ser informada");
        
        if(data == null)
            throw new ValidacaoException("Uma data para o pagamento deve ser informada");
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

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Comprovante getComprovante() {
        return comprovante;
    }

    public void setComprovante(Comprovante comprovante) {
        this.comprovante = comprovante;
    }

    public CobrancaRecorrente getCobranca() {
        return cobranca;
    }

    public void setCobranca(CobrancaRecorrente cobranca) {
        this.cobranca = cobranca;
    }

    public SituacaoPagamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPagamento situacao) {
        this.situacao = situacao;
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
        final Pagamento other = (Pagamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
