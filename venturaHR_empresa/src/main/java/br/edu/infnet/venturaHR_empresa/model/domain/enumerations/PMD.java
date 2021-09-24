package br.edu.infnet.venturaHR_empresa.model.domain.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PMD {

    DESEJAVEL(1, "DESEJÁVEL"),
    DIFERENCIAL(2, "DEFERENCIAL"),
    RELEVANTE(3, "RELEVANTE"),
    MUITO_RELEVANTE(4, "MUITO RELEVANTE"),
    OBRIGATORIO(5, "OBRIGATÓRIO");

    private String descricao;
    private int valor;

    PMD(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }


}
