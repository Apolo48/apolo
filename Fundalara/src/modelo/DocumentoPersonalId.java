package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DocumentoPersonalId generated by hbm2java
 */
@Embeddable
public class DocumentoPersonalId implements java.io.Serializable {

	private int codigoDocumentoEntregado;
	private String cedulaRif;

	public DocumentoPersonalId() {
	}

	public DocumentoPersonalId(int codigoDocumentoEntregado, String cedulaRif) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
		this.cedulaRif = cedulaRif;
	}

	@Column(name = "codigo_documento_entregado", nullable = false)
	public int getCodigoDocumentoEntregado() {
		return this.codigoDocumentoEntregado;
	}

	public void setCodigoDocumentoEntregado(int codigoDocumentoEntregado) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
	}

	@Column(name = "cedula_rif", nullable = false)
	public String getCedulaRif() {
		return this.cedulaRif;
	}

	public void setCedulaRif(String cedulaRif) {
		this.cedulaRif = cedulaRif;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DocumentoPersonalId))
			return false;
		DocumentoPersonalId castOther = (DocumentoPersonalId) other;

		return (this.getCodigoDocumentoEntregado() == castOther
				.getCodigoDocumentoEntregado())
				&& ((this.getCedulaRif() == castOther.getCedulaRif()) || (this
						.getCedulaRif() != null
						&& castOther.getCedulaRif() != null && this
						.getCedulaRif().equals(castOther.getCedulaRif())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoDocumentoEntregado();
		result = 37 * result
				+ (getCedulaRif() == null ? 0 : this.getCedulaRif().hashCode());
		return result;
	}

}
