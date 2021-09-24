package br.edu.infnet.venturaHR_empresa.model.domain.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FormaContratacao {

    CLT ("CLT"),
    PJ ("PJ"),
    COOPERADO ("COOPERADO");

    private String descricao;

    FormaContratacao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
