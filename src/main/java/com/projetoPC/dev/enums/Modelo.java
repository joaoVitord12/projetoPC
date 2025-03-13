package com.projetoPC.dev.enums;

import lombok.Getter;

@Getter
public enum Modelo {
    ATX("ATX"),
    MICRO_ATX("Micro-ATX"),
    MINI_ATX("Mini-ATX"),
    E_ATX("E-ATX");

    private final String descricao;

    Modelo(String descricao) {
        this.descricao = descricao;
    }
}
