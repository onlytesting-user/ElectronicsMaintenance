package com.electronicsmaintenance.service.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.math.BigDecimal;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * ServiceRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-01T16:11:12.319695700-03:00[America/Fortaleza]")
public class ServiceRequest {

  private String nomeCliente;

  private String telefoneContato;

  private String emailContato;

  private String tipoEletronico;

  private String modeloEletronico;

  private String tipoServico;

  /**
   * Gets or Sets statusServico
   */
  public enum StatusServicoEnum {
    PENDENTE("PENDENTE"),

    EM_ANDAMENTO("EM_ANDAMENTO"),

    FINALIZADO("FINALIZADO"),

    CANCELADO("CANCELADO");

    private String value;

    StatusServicoEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusServicoEnum fromValue(String value) {
      for (StatusServicoEnum b : StatusServicoEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusServicoEnum statusServico;

  private BigDecimal valorServico;

  /**
   * Gets or Sets formaPagamento
   */
  public enum FormaPagamentoEnum {
    CARTAO_CREDITO("CARTAO_CREDITO"),

    CARTAO_DEBITO("CARTAO_DEBITO"),

    DINHEIRO("DINHEIRO"),

    TRANSFERENCIA("TRANSFERENCIA");

    private String value;

    FormaPagamentoEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FormaPagamentoEnum fromValue(String value) {
      for (FormaPagamentoEnum b : FormaPagamentoEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private FormaPagamentoEnum formaPagamento;

  public ServiceRequest nomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
    return this;
  }

  /**
   * Get nomeCliente
   * @return nomeCliente
  */

  @Schema(name = "nomeCliente", example = "João Victor", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nomeCliente")
  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }

  public ServiceRequest telefoneContato(String telefoneContato) {
    this.telefoneContato = telefoneContato;
    return this;
  }

  /**
   * Get telefoneContato
   * @return telefoneContato
  */

  @Schema(name = "telefoneContato", example = "+55 81 92897-4311", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telefoneContato")
  public String getTelefoneContato() {
    return telefoneContato;
  }

  public void setTelefoneContato(String telefoneContato) {
    this.telefoneContato = telefoneContato;
  }

  public ServiceRequest emailContato(String emailContato) {
    this.emailContato = emailContato;
    return this;
  }

  /**
   * Get emailContato
   * @return emailContato
  */
  @jakarta.validation.constraints.Email
  @Schema(name = "emailContato", example = "joao.victor15@gmail.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("emailContato")
  public String getEmailContato() {
    return emailContato;
  }

  public void setEmailContato(String emailContato) {
    this.emailContato = emailContato;
  }

  public ServiceRequest tipoEletronico(String tipoEletronico) {
    this.tipoEletronico = tipoEletronico;
    return this;
  }

  /**
   * Get tipoEletronico
   * @return tipoEletronico
  */

  @Schema(name = "tipoEletronico", example = "Notebook", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tipoEletronico")
  public String getTipoEletronico() {
    return tipoEletronico;
  }

  public void setTipoEletronico(String tipoEletronico) {
    this.tipoEletronico = tipoEletronico;
  }

  public ServiceRequest modeloEletronico(String modeloEletronico) {
    this.modeloEletronico = modeloEletronico;
    return this;
  }

  /**
   * Get modeloEletronico
   * @return modeloEletronico
  */

  @Schema(name = "modeloEletronico", example = "Vaio FE15", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("modeloEletronico")
  public String getModeloEletronico() {
    return modeloEletronico;
  }

  public void setModeloEletronico(String modeloEletronico) {
    this.modeloEletronico = modeloEletronico;
  }

  public ServiceRequest tipoServico(String tipoServico) {
    this.tipoServico = tipoServico;
    return this;
  }

  /**
   * Get tipoServico
   * @return tipoServico
  */

  @Schema(name = "tipoServico", example = "Formatação", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tipoServico")
  public String getTipoServico() {
    return tipoServico;
  }

  public void setTipoServico(String tipoServico) {
    this.tipoServico = tipoServico;
  }

  public ServiceRequest statusServico(StatusServicoEnum statusServico) {
    this.statusServico = statusServico;
    return this;
  }

  /**
   * Get statusServico
   * @return statusServico
  */

  @Schema(name = "statusServico", example = "PENDENTE", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statusServico")
  public StatusServicoEnum getStatusServico() {
    return statusServico;
  }

  public void setStatusServico(StatusServicoEnum statusServico) {
    this.statusServico = statusServico;
  }

  public ServiceRequest valorServico(BigDecimal valorServico) {
    this.valorServico = valorServico;
    return this;
  }

  /**
   * Get valorServico
   * @return valorServico
  */
  @Valid
  @Schema(name = "valorServico", example = "149.99", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("valorServico")
  public BigDecimal getValorServico() {
    return valorServico;
  }

  public void setValorServico(BigDecimal valorServico) {
    this.valorServico = valorServico;
  }

  public ServiceRequest formaPagamento(FormaPagamentoEnum formaPagamento) {
    this.formaPagamento = formaPagamento;
    return this;
  }

  /**
   * Get formaPagamento
   * @return formaPagamento
  */

  @Schema(name = "formaPagamento", example = "DINHEIRO", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("formaPagamento")
  public FormaPagamentoEnum getFormaPagamento() {
    return formaPagamento;
  }

  public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
    this.formaPagamento = formaPagamento;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceRequest serviceRequest = (ServiceRequest) o;
    return Objects.equals(this.nomeCliente, serviceRequest.nomeCliente) &&
        Objects.equals(this.telefoneContato, serviceRequest.telefoneContato) &&
        Objects.equals(this.emailContato, serviceRequest.emailContato) &&
        Objects.equals(this.tipoEletronico, serviceRequest.tipoEletronico) &&
        Objects.equals(this.modeloEletronico, serviceRequest.modeloEletronico) &&
        Objects.equals(this.tipoServico, serviceRequest.tipoServico) &&
        Objects.equals(this.statusServico, serviceRequest.statusServico) &&
        Objects.equals(this.valorServico, serviceRequest.valorServico) &&
        Objects.equals(this.formaPagamento, serviceRequest.formaPagamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nomeCliente, telefoneContato, emailContato, tipoEletronico, modeloEletronico, tipoServico, statusServico, valorServico, formaPagamento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceRequest {\n");
    sb.append("    nomeCliente: ").append(toIndentedString(nomeCliente)).append("\n");
    sb.append("    telefoneContato: ").append(toIndentedString(telefoneContato)).append("\n");
    sb.append("    emailContato: ").append(toIndentedString(emailContato)).append("\n");
    sb.append("    tipoEletronico: ").append(toIndentedString(tipoEletronico)).append("\n");
    sb.append("    modeloEletronico: ").append(toIndentedString(modeloEletronico)).append("\n");
    sb.append("    tipoServico: ").append(toIndentedString(tipoServico)).append("\n");
    sb.append("    statusServico: ").append(toIndentedString(statusServico)).append("\n");
    sb.append("    valorServico: ").append(toIndentedString(valorServico)).append("\n");
    sb.append("    formaPagamento: ").append(toIndentedString(formaPagamento)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
