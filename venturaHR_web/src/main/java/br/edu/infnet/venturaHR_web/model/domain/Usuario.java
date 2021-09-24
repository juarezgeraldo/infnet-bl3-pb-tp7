package br.edu.infnet.venturaHR_web.model.domain;

import br.edu.infnet.venturaHR_web.model.domain.enumerations.StatusUsuario;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.TipoConta;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private TipoConta tipoConta;
    private StatusUsuario statusUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public StatusUsuario getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(StatusUsuario statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public Usuario StatusUsuario(StatusUsuario statusUsuario) {
        this.statusUsuario = statusUsuario;
        return this;
    }

}
