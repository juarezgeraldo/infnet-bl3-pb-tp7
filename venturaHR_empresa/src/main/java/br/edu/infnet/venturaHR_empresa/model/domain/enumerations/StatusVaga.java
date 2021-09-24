package br.edu.infnet.venturaHR_empresa.model.domain.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusVaga {
    ABERTA ("ABERTA"),
    FINALIZADA ("FINALIZADA");

    private String descricao;

    StatusVaga(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
