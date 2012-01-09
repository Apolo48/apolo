package modelo;

// Generated 09/01/2012 10:19:56 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DocumentoConductaId generated by hbm2java
 */
@Embeddable
public class DocumentoConductaId implements java.io.Serializable {

	private int codigoDocumentoEntregado;
	private int codigoDatoConducta;

	public DocumentoConductaId() {
	}

	public DocumentoConductaId(int codigoDocumentoEntregado,
			int codigoDatoConducta) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
		this.codigoDatoConducta = codigoDatoConducta;
	}

	@Column(name = "codigo_documento_entregado", nullable = false)
	public int getCodigoDocumentoEntregado() {
		return this.codigoDocumentoEntregado;
	}

	public void setCodigoDocumentoEntregado(int codigoDocumentoEntregado) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
	}

	@Column(name = "codigo_dato_conducta", nullable = false)
	public int getCodigoDatoConducta() {
		return this.codigoDatoConducta;
	}

	public void setCodigoDatoConducta(int codigoDatoConducta) {
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

		return (this.getCodigoDocumentoEntregado() == castOther
				.getCodigoDocumentoEntregado())
				&& (this.getCodigoDatoConducta() == castOther
						.getCodigoDatoConducta());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoDocumentoEntregado();
		result = 37 * result + this.getCodigoDatoConducta();
		return result;
	}

}
