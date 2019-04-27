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

	@Column(name="sigla_perfil", unique = true, length = 3)
	private String siglaPerfil;

	@Column(name="nome_perfil", unique = true, length = 32)
	private String nomePerfil;

	//bi-directional many-to-one association to Usuario
	@JsonIgnore
	@OneToMany(mappedBy="perfil")
	private Set<Usuario> usuarios;

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getSiglaPerfil() {
		return siglaPerfil;
	}

	public void setSiglaPerfil(String siglaPerfil) {
		this.siglaPerfil = siglaPerfil;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}