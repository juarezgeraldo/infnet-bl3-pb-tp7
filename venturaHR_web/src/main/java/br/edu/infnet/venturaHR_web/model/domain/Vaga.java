package br.edu.infnet.venturaHR_web.model.domain;

import br.edu.infnet.venturaHR_web.model.domain.enumerations.FormaContratacao;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.StatusVaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vaga {
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFinal;
    private Empresa usuarioEmpresa;
    private String titulo;
    private String descricao;
    private FormaContratacao formaContratacao;
    private String Bairro;
    private String cidade;
    private String estado;
    private float pmdCalculado;
    private StatusVaga statusVaga;
    private List<CriteriosVaga> criteriosVagaList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
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

    public float getPmdCalculado() {
        return pmdCalculado;
    }

    public void setPmdCalculado(float pmdCalculado) {
        this.pmdCalculado = pmdCalculado;
    }
}
