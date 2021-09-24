package br.edu.infnet.venturaHR_usuarios.model.domain.enumerations;

public enum StatusUsuario {

    DESATIVADO(0,"DESATIVADO"),
    ATIVO(1,"ATIVO");

    private Integer valor;
    private String descricao;

    StatusUsuario(Integer valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
