package modelo;

// Generated 09/01/2012 10:19:56 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IngresoDocumentoAcreedorId generated by hbm2java
 */
@Embeddable
public class IngresoDocumentoAcreedorId implements java.io.Serializable {

	private String numeroDocumento;
	private int codigoDocumentoAcreedor;

	public IngresoDocumentoAcreedorId() {
	}

	public IngresoDocumentoAcreedorId(String numeroDocumento,
			int codigoDocumentoAcreedor) {
		this.numeroDocumento = numeroDocumento;
		this.codigoDocumentoAcreedor = codigoDocumentoAcreedor;
	}

	@Column(name = "numero_documento", nullable = false)
	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	@Column(name = "codigo_documento_acreedor", nullable = false)
	public int getCodigoDocumentoAcreedor() {
		return this.codigoDocumentoAcreedor;
	}

	public void setCodigoDocumentoAcreedor(int codigoDocumentoAcreedor) {
		this.codigoDocumentoAcreedor = codigoDocumentoAcreedor;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IngresoDocumentoAcreedorId))
			return false;
		IngresoDocumentoAcreedorId castOther = (IngresoDocumentoAcreedorId) other;

		return ((this.getNumeroDocumento() == castOther.getNumeroDocumento()) || (this
				.getNumeroDocumento() != null
				&& castOther.getNumeroDocumento() != null && this
				.getNumeroDocumento().equals(castOther.getNumeroDocumento())))
				&& (this.getCodigoDocumentoAcreedor() == castOther
						.getCodigoDocumentoAcreedor());
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNumeroDocumento() == null ? 0 : this.getNumeroDocumento()
						.hashCode());
		result = 37 * result + this.getCodigoDocumentoAcreedor();
		return result;
	}

}
