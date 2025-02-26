package com.projetoPC.dev.dtos;

public class ComponentesDTO {

    private Long id;
    private String nome;
    private String tipo;
    private int potenciaConsumida;
    private double preco;
    private String fabricante;
    private String descricao;
    private double tamanho;
    private String socketCpu;
    private String pciCompatibilidade;

    public ComponentesDTO(){}

    public String getPciCompatibilidade() {
        return pciCompatibilidade;
    }

    public void setPciCompatibilidade(String pciCompatibilidade) {
        this.pciCompatibilidade = pciCompatibilidade;
    }

    public String getSocketCpu() {
        return socketCpu;
    }

    public void setSocketCpu(String socketCpu) {
        this.socketCpu = socketCpu;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getPotenciaConsumida() {
        return potenciaConsumida;
    }

    public void setPotenciaConsumida(int potenciaConsumida) {
        this.potenciaConsumida = potenciaConsumida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
