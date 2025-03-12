package com.projetoPC.dev.models;

public enum Modelo {
    ATX,
    MIcroATX,
    MiniATX,
    eATX;

    private String modelo;

    descricao(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }
}
