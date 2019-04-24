package br.com.amcom.TesteSeniorSB.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


/**
 * The persistent class for the tbl_perfil database table.
 * 
 */
@Entity
@Table(name="tbl_perfil")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil")
	private int idPerfil;

	@Column(name="nome_perfil")
	private String nomePerfil;

	//bi-directional many-to-one association to Usuario
	@JsonIgnore
	@OneToMany(mappedBy="tblPerfil")
	private Set<Usuario> tblUsuarios;

	public Perfil() {
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNomePerfil() {
		return this.nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public Set<Usuario> getTblUsuarios() {
		return this.tblUsuarios;
	}

	public void setTblUsuarios(Set<Usuario> tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

	public Usuario addTblUsuario(Usuario tblUsuario) {
		getTblUsuarios().add(tblUsuario);
		tblUsuario.setTblPerfil(this);

		return tblUsuario;
	}

	public Usuario removeTblUsuario(Usuario tblUsuario) {
		getTblUsuarios().remove(tblUsuario);
		tblUsuario.setTblPerfil(null);

		return tblUsuario;
	}

}