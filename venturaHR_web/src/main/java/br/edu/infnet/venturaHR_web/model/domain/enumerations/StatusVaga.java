package br.edu.infnet.venturaHR_web.model.domain.enumerations;

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
