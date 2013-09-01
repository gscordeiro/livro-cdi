/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.controllers;

import javax.enterprise.inject.Model;

/**
 *
 * @author gilliard
 */
//@Model
public class ExtensionBean {
    
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void acao(){
        nome = nome.toUpperCase();
    }
    
}
