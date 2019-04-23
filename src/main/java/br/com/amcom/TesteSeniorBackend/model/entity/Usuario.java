package br.com.amcom.TesteSeniorBackend.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_usuario database table.
 * 
 */
@Entity
@Table(name="tbl_usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_criado_usuario")
	private Date dataCriadoUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_excluido_usuario")
	private Date dataExcluidoUsuario;

	@Column(name="email_usuario")
	private String emailUsuario;

	@Column(name="nome_usuario")
	private String nomeUsuario;

	@Column(name="senha_usuario")
	private String senhaUsuario;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil tblPerfil;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDataCriadoUsuario() {
		return this.dataCriadoUsuario;
	}

	public void setDataCriadoUsuario(Date dataCriadoUsuario) {
		this.dataCriadoUsuario = dataCriadoUsuario;
	}

	public Date getDataExcluidoUsuario() {
		return this.dataExcluidoUsuario;
	}

	public void setDataExcluidoUsuario(Date dataExcluidoUsuario) {
		this.dataExcluidoUsuario = dataExcluidoUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return this.senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public Perfil getTblPerfil() {
		return this.tblPerfil;
	}

	public void setTblPerfil(Perfil tblPerfil) {
		this.tblPerfil = tblPerfil;
	}

}