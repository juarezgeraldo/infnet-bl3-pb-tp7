package br.edu.infnet.venturaHR_empresa.model.domain.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusUsuario {

    DESATIVADO("DESATIVADO"),
    ATIVO("ATIVO");

    private String descricao;

    StatusUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    }
