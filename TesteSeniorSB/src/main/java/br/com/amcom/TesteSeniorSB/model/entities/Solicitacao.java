package br.com.amcom.TesteSeniorSB.model.entities;

import java.io.Serializable;
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
	double valorSolicitacao;
	
	@Column(name = "email_solicitacao", length = 128, nullable = false)
	private String emailSolicitacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_aprovado_solicitacao", nullable = false)
	private Date dtAprovadoSolicitacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_reprovado_solicitacao", nullable = false)
	private Date dtReprovadoSolicitacao;
	
	@Column(name = "motivo_reprovacao_solicitacao", length = 256, nullable = false)
	private String motivoReprovacaoSolicitacao;
}
