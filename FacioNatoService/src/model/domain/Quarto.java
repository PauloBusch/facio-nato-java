/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import com.google.firebase.database.Exclude;
import java.util.Objects;
import util.ValidacaoException;

/**
 *
 * @author paulo
 */
public class Quarto {
    private String identifier;
    private Pensionato pensionato;
    private String nome;
    private String descricao;
    private float valor;

    public Quarto() {
    }
    
    public void validar() throws ValidacaoException{
        if(pensionato == null)
            throw new ValidacaoException("Deve ser selecionado um pensionato");
        
        if(nome == null || nome.equals(""))
            throw new ValidacaoException("Campo Nome deve ser preenchido");
            
        if(valor <= 0d)
            throw new ValidacaoException("Campo Valor deve ser preenchido");
        
        if(descricao == null || descricao.equals(""))
            throw new ValidacaoException("Campo Descrição deve ser preenchido");        
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    @Exclude
    public Pensionato getPensionato() {
        return pensionato;
    }

    @Exclude
    public void setPensionato(Pensionato pensionato) {
        this.pensionato = pensionato;
    }
    
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
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
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
