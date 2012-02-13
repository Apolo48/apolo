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
 * DocumentoPersonal generated by hbm2java
 */
@Entity
@Table(name = "documento_personal", schema = "public")
public class DocumentoPersonal implements java.io.Serializable {

	private DocumentoPersonalId id;
	private DocumentoEntregado documentoEntregado;
	private Jugador jugador;
	private char estatus;

	public DocumentoPersonal() {
	}

	public DocumentoPersonal(DocumentoPersonalId id,
			DocumentoEntregado documentoEntregado, Jugador jugador, char estatus) {
		this.id = id;
		this.documentoEntregado = documentoEntregado;
		this.jugador = jugador;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoDocumentoEntregado", column = @Column(name = "codigo_documento_entregado", nullable = false)),
			@AttributeOverride(name = "cedulaRif", column = @Column(name = "cedula_rif", nullable = false)) })
	public DocumentoPersonalId getId() {
		return this.id;
	}

	public void setId(DocumentoPersonalId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_documento_entregado", nullable = false, insertable = false, updatable = false)
	public DocumentoEntregado getDocumentoEntregado() {
		return this.documentoEntregado;
	}

	public void setDocumentoEntregado(DocumentoEntregado documentoEntregado) {
		this.documentoEntregado = documentoEntregado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_rif", nullable = false, insertable = false, updatable = false)
	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
