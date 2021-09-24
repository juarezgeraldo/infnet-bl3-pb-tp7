package br.edu.infnet.venturaHR_web.model.domain.enumerations;

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
