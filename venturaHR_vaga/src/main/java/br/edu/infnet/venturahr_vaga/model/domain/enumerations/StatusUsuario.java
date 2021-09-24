package br.edu.infnet.venturahr_vaga.model.domain.enumerations;

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
