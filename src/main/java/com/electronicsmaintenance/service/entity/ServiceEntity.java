package com.electronicsmaintenance.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Entity
@Table(name = "Services")
public class ServiceEntity {

    @Id
    @GeneratedValue
    @Column(name = "idServico", updatable = false, nullable = false)
    private UUID idServico;
    private String nomeCliente;
    private String telefoneContato;
    private String emailContato;
    private String tipoEletronico;
    private String modeloEletronico;
    private String tipoServico;
    private EnumStatusServico statusServico;
    private BigDecimal valorServico;
    private EnumFormaPagamento formaPagamento;
    private LocalDateTime dataInsercao;
    private LocalDateTime dataAtualizacao;

    public ServiceEntity() {
        this.idServico = UUID.randomUUID();
        this.dataInsercao = LocalDateTime.now(ZoneOffset.UTC);
        this.dataAtualizacao = LocalDateTime.now(ZoneOffset.UTC);
    }

    public UUID getIdServico() {
        return idServico;
    }

    public void setIdServico(UUID idServico) {
        this.idServico = idServico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getTipoEletronico() {
        return tipoEletronico;
    }

    public void setTipoEletronico(String tipoEletronico) {
        this.tipoEletronico = tipoEletronico;
    }

    public String getModeloEletronico() {
        return modeloEletronico;
    }

    public void setModeloEletronico(String modeloEletronico) {
        this.modeloEletronico = modeloEletronico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public EnumStatusServico getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(EnumStatusServico statusServico) {
        this.statusServico = statusServico;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }

    public EnumFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public LocalDateTime getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(LocalDateTime dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public void atualizarDataAtualizacao() {
        this.dataAtualizacao = LocalDateTime.now(ZoneOffset.UTC);
    }
}
