package modelo;

// Generated 13/02/2012 02:19:00 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * GrupoUsuario generated by hbm2java
 */
@Entity
@Table(name = "grupo_usuario", schema = "public")
public class GrupoUsuario implements java.io.Serializable {

	private GrupoUsuarioId id;
	private Grupo grupo;
	private Usuario usuario;
	private char estatus;

	public GrupoUsuario() {
	}

	public GrupoUsuario(GrupoUsuarioId id, Grupo grupo, Usuario usuario,
			char estatus) {
		this.id = id;
		this.grupo = grupo;
		this.usuario = usuario;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cedulaRif", column = @Column(name = "cedula_rif", nullable = false)),
			@AttributeOverride(name = "codigoGrupo", column = @Column(name = "codigo_grupo", nullable = false)) })
	public GrupoUsuarioId getId() {
		return this.id;
	}

	public void setId(GrupoUsuarioId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_grupo", nullable = false, insertable = false, updatable = false)
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_rif", nullable = false, insertable = false, updatable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
