package br.edu.infnet.venturahr_vaga.model.domain;

import br.edu.infnet.venturahr_vaga.model.domain.enumerations.FormaContratacao;
import br.edu.infnet.venturahr_vaga.model.domain.enumerations.StatusVaga;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    @ManyToOne
    private Empresa usuarioEmpresa;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    private FormaContratacao formaContratacao;
    private String Bairro;
    private String cidade;
    private String estado;
    private float pmdCalculado;
    private StatusVaga statusVaga;
    @OneToMany(mappedBy = "vaga")
    @JsonManagedReference
    @JsonIgnoreProperties("criteriosVagaList")
    private List<CriteriosVaga> criteriosVagaList;

    public Vaga() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Empresa getUsuarioEmpresa() {
        return usuarioEmpresa;
    }

    public void setUsuarioEmpresa(Empresa usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public FormaContratacao getFormaContratacao() {
        return formaContratacao;
    }

    public void setFormaContratacao(FormaContratacao formaContratacao) {
        this.formaContratacao = formaContratacao;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPmdCalculado() {
        return pmdCalculado;
    }

    public void setPmdCalculado(float pmdCalculado) {
        this.pmdCalculado = pmdCalculado;
    }

    public StatusVaga getStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(StatusVaga statusVaga) {
        this.statusVaga = statusVaga;
    }

    public List<CriteriosVaga> getCriteriosVagaList() {
        return criteriosVagaList;
    }

    public void setCriteriosVagaList(List<CriteriosVaga> criteriosVagaList) {
        this.criteriosVagaList = criteriosVagaList;
    }
}
