package modelo;

// Generated 26-dic-2011 15:15:53 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DocumentoAcademicoId generated by hbm2java
 */
@Embeddable
public class DocumentoAcademicoId implements java.io.Serializable {

	private int codigoDocumentoEntregado;
	private int codigoAcademico;

	public DocumentoAcademicoId() {
	}

	public DocumentoAcademicoId(int codigoDocumentoEntregado,
			int codigoAcademico) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
		this.codigoAcademico = codigoAcademico;
	}

	@Column(name = "codigo_documento_entregado", nullable = false)
	public int getCodigoDocumentoEntregado() {
		return this.codigoDocumentoEntregado;
	}

	public void setCodigoDocumentoEntregado(int codigoDocumentoEntregado) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
	}

	@Column(name = "codigo_academico", nullable = false)
	public int getCodigoAcademico() {
		return this.codigoAcademico;
	}

	public void setCodigoAcademico(int codigoAcademico) {
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

		return (this.getCodigoDocumentoEntregado() == castOther
				.getCodigoDocumentoEntregado())
				&& (this.getCodigoAcademico() == castOther.getCodigoAcademico());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoDocumentoEntregado();
		result = 37 * result + this.getCodigoAcademico();
		return result;
	}

}
