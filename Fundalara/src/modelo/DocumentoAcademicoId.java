package modelo;

// Generated 13-dic-2011 23:21:03 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DocumentoAcademicoId generated by hbm2java
 */
@Embeddable
public class DocumentoAcademicoId implements java.io.Serializable {

	private String codigoDocumentoEntregado;
	private String codigoAcademico;

	public DocumentoAcademicoId() {
	}

	public DocumentoAcademicoId(String codigoDocumentoEntregado,
			String codigoAcademico) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
		this.codigoAcademico = codigoAcademico;
	}

	@Column(name = "codigo_documento_entregado", nullable = false)
	public String getCodigoDocumentoEntregado() {
		return this.codigoDocumentoEntregado;
	}

	public void setCodigoDocumentoEntregado(String codigoDocumentoEntregado) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
	}

	@Column(name = "codigo_academico", nullable = false)
	public String getCodigoAcademico() {
		return this.codigoAcademico;
	}

	public void setCodigoAcademico(String codigoAcademico) {
		this.codigoAcademico = codigoAcademico;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DocumentoAcademicoId))
			return false;
		DocumentoAcademicoId castOther = (DocumentoAcademicoId) other;

		return ((this.getCodigoDocumentoEntregado() == castOther
				.getCodigoDocumentoEntregado()) || (this
				.getCodigoDocumentoEntregado() != null
				&& castOther.getCodigoDocumentoEntregado() != null && this
				.getCodigoDocumentoEntregado().equals(
						castOther.getCodigoDocumentoEntregado())))
				&& ((this.getCodigoAcademico() == castOther
						.getCodigoAcademico()) || (this.getCodigoAcademico() != null
						&& castOther.getCodigoAcademico() != null && this
						.getCodigoAcademico().equals(
								castOther.getCodigoAcademico())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoDocumentoEntregado() == null ? 0 : this
						.getCodigoDocumentoEntregado().hashCode());
		result = 37
				* result
				+ (getCodigoAcademico() == null ? 0 : this.getCodigoAcademico()
						.hashCode());
		return result;
	}

}