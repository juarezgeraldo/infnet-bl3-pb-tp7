package br.edu.infnet.venturaHR_web.model.domain;

import br.edu.infnet.venturaHR_web.model.domain.enumerations.PMD;

public class CriteriosVaga {
    private Long id;
//    private Vaga vaga;
    private String descricao;
    private PMD pmd;
    private int peso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Vaga getVaga() {
//        return vaga;
//    }
//
//    public void setVaga(Vaga vaga) {
//        this.vaga = vaga;
//    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PMD getPmd() {
        return pmd;
    }

    public void setPmd(PMD pmd) {
        this.pmd = pmd;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
