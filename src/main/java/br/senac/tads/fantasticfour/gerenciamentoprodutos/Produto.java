/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.fantasticfour.gerenciamentoprodutos;

import java.util.Date;

/**
 *
 * @author work
 */
public class Produto {
    
    private String nome;
    private String descricao;
    private double preCompra;
    private double preVenda;
    private int quantidade;
    private Date data;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void SetDescricao(String desString) {
        this.descricao = descricao;
    }
    
    public double getPreCompra() {
        return preCompra;
    }

    public void setPreCompra(double preCompra) {
        this.preCompra = preCompra;
    }

    public double getPreVenda() {
        return preVenda;
    }

    public void setPreVenda(double preVenda) {
        this.preVenda = preVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
        
      
}
