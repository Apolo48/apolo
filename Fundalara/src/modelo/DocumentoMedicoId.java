package modelo;

// Generated 17-dic-2011 16:31:20 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DocumentoMedicoId generated by hbm2java
 */
@Embeddable
public class DocumentoMedicoId implements java.io.Serializable {

	private int codigoDatoMedico;
	private int codigoDocumentoEntregado;

	public DocumentoMedicoId() {
	}

	public DocumentoMedicoId(int codigoDatoMedico, int codigoDocumentoEntregado) {
		this.codigoDatoMedico = codigoDatoMedico;
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
	}

	@Column(name = "codigo_dato_medico", nullable = false)
	public int getCodigoDatoMedico() {
		return this.codigoDatoMedico;
	}

	public void setCodigoDatoMedico(int codigoDatoMedico) {
		this.codigoDatoMedico = codigoDatoMedico;
	}

	@Column(name = "codigo_documento_entregado", nullable = false)
	public int getCodigoDocumentoEntregado() {
		return this.codigoDocumentoEntregado;
	}

	public void setCodigoDocumentoEntregado(int codigoDocumentoEntregado) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DocumentoMedicoId))
			return false;
		DocumentoMedicoId castOther = (DocumentoMedicoId) other;

		return (this.getCodigoDatoMedico() == castOther.getCodigoDatoMedico())
				&& (this.getCodigoDocumentoEntregado() == castOther
						.getCodigoDocumentoEntregado());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoDatoMedico();
		result = 37 * result + this.getCodigoDocumentoEntregado();
		return result;
	}

}
