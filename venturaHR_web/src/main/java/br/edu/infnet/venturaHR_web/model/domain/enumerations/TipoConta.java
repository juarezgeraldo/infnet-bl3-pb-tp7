package br.edu.infnet.venturaHR_web.model.domain.enumerations;

public enum TipoConta {

    ADMIN (0, "ADMIN"),
    EMPRESA (1,"EMPRESA"),
    CANDIDATO (2,"CANDIDATO");

    private int valor;
    private String descricao;

    TipoConta(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }
}
