/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

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
@Table(name="QUARTO")
public class Quarto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name="NOME", length = 100, nullable = false)
    private String nome;
    
    @Column(name="DESCRICAO", length = 300, nullable = false)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name="ID_PENSIONATO", nullable = false)
    private Pensionato pensionato;

    public Quarto() {
    }
    
    public void validar() throws ValidacaoException{
        if(nome == null || nome.equals(""))
            throw new ValidacaoException("Campo Nome deve ser preenchido");
        
        if(descricao == null || descricao.equals(""))
            throw new ValidacaoException("Campo Descrição deve ser preenchido");
        
        if(pensionato == null)
            throw new ValidacaoException("Deve ser selecionado um pensionato");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pensionato getPensionato() {
        return pensionato;
    }

    public void setPensionato(Pensionato pensionato) {
        this.pensionato = pensionato;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Quarto other = (Quarto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }    
}
