package modelo;

// Generated 16-dic-2011 17:19:16 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DocumentoConductaId generated by hbm2java
 */
@Embeddable
public class DocumentoConductaId implements java.io.Serializable {

	private String codigoDocumentoEntregado;
	private String codigoDatoConducta;

	public DocumentoConductaId() {
	}

	public DocumentoConductaId(String codigoDocumentoEntregado,
			String codigoDatoConducta) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
		this.codigoDatoConducta = codigoDatoConducta;
	}

	@Column(name = "codigo_documento_entregado", nullable = false)
	public String getCodigoDocumentoEntregado() {
		return this.codigoDocumentoEntregado;
	}

	public void setCodigoDocumentoEntregado(String codigoDocumentoEntregado) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
	}

	@Column(name = "codigo_dato_conducta", nullable = false)
	public String getCodigoDatoConducta() {
		return this.codigoDatoConducta;
	}

	public void setCodigoDatoConducta(String codigoDatoConducta) {
		this.codigoDatoConducta = codigoDatoConducta;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DocumentoConductaId))
			return false;
		DocumentoConductaId castOther = (DocumentoConductaId) other;

		return ((this.getCodigoDocumentoEntregado() == castOther
				.getCodigoDocumentoEntregado()) || (this
				.getCodigoDocumentoEntregado() != null
				&& castOther.getCodigoDocumentoEntregado() != null && this
				.getCodigoDocumentoEntregado().equals(
						castOther.getCodigoDocumentoEntregado())))
				&& ((this.getCodigoDatoConducta() == castOther
						.getCodigoDatoConducta()) || (this
						.getCodigoDatoConducta() != null
						&& castOther.getCodigoDatoConducta() != null && this
						.getCodigoDatoConducta().equals(
								castOther.getCodigoDatoConducta())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoDocumentoEntregado() == null ? 0 : this
						.getCodigoDocumentoEntregado().hashCode());
		result = 37
				* result
				+ (getCodigoDatoConducta() == null ? 0 : this
						.getCodigoDatoConducta().hashCode());
		return result;
	}

}
