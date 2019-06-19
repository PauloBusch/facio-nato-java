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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="INQUILINO")
public class Inquilino implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="NOME", length = 200, nullable = false)
    private String nome;

    /*Enumeração apenas em tabela*/
    @Enumerated(EnumType.STRING)
    @Column(name="CIDADE", length = 100, nullable = false)
    private Cidade cidade;
    
    /*Enumeração apenas em tabela*/
    @Enumerated(EnumType.STRING)
    @Column(name="CURSO", length = 100, nullable = false)
    private Curso curso;    
    
    /*Enumeração apenas em tabela*/
    @Enumerated(EnumType.STRING)
    @Column(name="FORMA_PAGAMENTO")
    private FormaPagamento formaPagamento;
    
    /*Enumeração real*/
    @Enumerated(EnumType.ORDINAL)
    @Column(name="PERIODO", nullable = false)
    private Periodo periodo;    
    
    @ManyToOne
    @JoinColumn(name="ID_QUARTO", nullable = false)
    private Quarto quarto;    

    public Inquilino() {
    }
    
    public void validar() throws ValidacaoException{
        if(nome == null || nome.equals(""))
            throw new ValidacaoException("Campo Nome deve ser preenchido");
        
        if(nome.length() > 200)
            throw new ValidacaoException("Nome muito extenso");
        
        cidade.validar();
        
        if(cidade.getNome().length() > 100)
            throw new ValidacaoException("Campo cidade muito extenso");
        
        curso.validar();
        
        if(curso.getNome().length() > 100)
            throw new ValidacaoException("Campo cidade muito extenso");
        
        formaPagamento.validar();
        
        if(periodo == null)
            throw new ValidacaoException("Campo Periodo deve ser preenchido");
        
        if(quarto == null)
            throw new ValidacaoException("Deve ser selecionado um quarto");
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Inquilino other = (Inquilino) obj;
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
