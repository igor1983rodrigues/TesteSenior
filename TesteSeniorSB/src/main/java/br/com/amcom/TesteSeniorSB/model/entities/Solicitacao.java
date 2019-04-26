package br.com.amcom.TesteSeniorSB.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_solicitacao")
@NamedQuery(name="Solicitacao.findAll", query="SELECT s FROM Solicitacao s")
public class Solicitacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8784227568941810825L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_solicitacao")
	private long idSolicitacao;
	
	@Column(name = "solicitante_solicitacao", length = 64, nullable = false)
	private String solicitanteSolicitacao;

	@Column(name = "desc_item_solicitacao", length = 256, nullable = false)
	private String descricaoItemSolicitacao;
	
	@Column(name = "valor_solicitacao", nullable = false)
	private double valorSolicitacao;
	
	@Column(name = "email_solicitacao", length = 128, nullable = false)
	private String emailSolicitacao;
	
	@Column(name = "dt_criacao_solicitacao", nullable = false, columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date dtCriacaoSolicitacao = Date.from(Instant.now());
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_aprovado_solicitacao", nullable = true)
	private Date dtAprovadoSolicitacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_reprovado_solicitacao", nullable = true)
	private Date dtReprovadoSolicitacao;
	
	@Column(name = "motivo_reprovacao_solicitacao", length = 256, nullable = true)
	private String motivoReprovacaoSolicitacao;

	public long getIdSolicitacao() {
		return idSolicitacao;
	}

	public void setIdSolicitacao(long idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}

	public String getSolicitanteSolicitacao() {
		return solicitanteSolicitacao;
	}

	public void setSolicitanteSolicitacao(String solicitanteSolicitacao) {
		this.solicitanteSolicitacao = solicitanteSolicitacao;
	}

	public String getDescricaoItemSolicitacao() {
		return descricaoItemSolicitacao;
	}

	public void setDescricaoItemSolicitacao(String descricaoItemSolicitacao) {
		this.descricaoItemSolicitacao = descricaoItemSolicitacao;
	}

	public double getValorSolicitacao() {
		return valorSolicitacao;
	}

	public void setValorSolicitacao(double valorSolicitacao) {
		this.valorSolicitacao = valorSolicitacao;
	}

	public String getEmailSolicitacao() {
		return emailSolicitacao;
	}

	public void setEmailSolicitacao(String emailSolicitacao) {
		this.emailSolicitacao = emailSolicitacao;
	}

	public Date getDtCriacaoSolicitacao() {
		return dtCriacaoSolicitacao;
	}

	public void setDtCriacaoSolicitacao(Date dtCriacaoSolicitacao) {
		this.dtCriacaoSolicitacao = dtCriacaoSolicitacao;
	}

	public Date getDtAprovadoSolicitacao() {
		return dtAprovadoSolicitacao;
	}

	public void setDtAprovadoSolicitacao(Date dtAprovadoSolicitacao) {
		this.dtAprovadoSolicitacao = dtAprovadoSolicitacao;
	}

	public Date getDtReprovadoSolicitacao() {
		return dtReprovadoSolicitacao;
	}

	public void setDtReprovadoSolicitacao(Date dtReprovadoSolicitacao) {
		this.dtReprovadoSolicitacao = dtReprovadoSolicitacao;
	}

	public String getMotivoReprovacaoSolicitacao() {
		return motivoReprovacaoSolicitacao;
	}

	public void setMotivoReprovacaoSolicitacao(String motivoReprovacaoSolicitacao) {
		this.motivoReprovacaoSolicitacao = motivoReprovacaoSolicitacao;
	}
}
