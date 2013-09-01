package br.com.casadocodigo.livrocdi.folhapagamento;

import java.io.Serializable;

public class Funcionario implements Serializable{

    private String nome;
    private Cargo cargo;
    private Escolaridade escolaridade;
    private int anoAdmissao;

    public Funcionario() {
    }

    public Funcionario(String nome, Cargo cargo, Escolaridade escolaridade, int anoAdmissao) {
        this.nome = nome;
        this.cargo = cargo;
        this.escolaridade = escolaridade;
        this.anoAdmissao = anoAdmissao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public int getAnoAdmissao() {
        return anoAdmissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    
}
