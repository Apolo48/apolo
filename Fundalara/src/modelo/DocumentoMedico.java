package modelo;

// Generated 17/12/2011 10:20:04 AM by Hibernate Tools 3.4.0.CR1

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
 * DocumentoMedico generated by hbm2java
 */
@Entity
@Table(name = "documento_medico")
public class DocumentoMedico implements java.io.Serializable {

	private DocumentoMedicoId id;
	private DatoMedico datoMedico;
	private DocumentoEntregado documentoEntregado;
	private char estatus;

	public DocumentoMedico() {
	}

	public DocumentoMedico(DocumentoMedicoId id, DatoMedico datoMedico,
			DocumentoEntregado documentoEntregado, char estatus) {
		this.id = id;
		this.datoMedico = datoMedico;
		this.documentoEntregado = documentoEntregado;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoDatoMedico", column = @Column(name = "codigo_dato_medico", nullable = false)),
			@AttributeOverride(name = "codigoDocumentoEntregado", column = @Column(name = "codigo_documento_entregado", nullable = false)) })
	public DocumentoMedicoId getId() {
		return this.id;
	}

	public void setId(DocumentoMedicoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_dato_medico", nullable = false, insertable = false, updatable = false)
	public DatoMedico getDatoMedico() {
		return this.datoMedico;
	}

	public void setDatoMedico(DatoMedico datoMedico) {
		this.datoMedico = datoMedico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_documento_entregado", nullable = false, insertable = false, updatable = false)
	public DocumentoEntregado getDocumentoEntregado() {
		return this.documentoEntregado;
	}

	public void setDocumentoEntregado(DocumentoEntregado documentoEntregado) {
		this.documentoEntregado = documentoEntregado;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
