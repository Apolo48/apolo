package modelo;

// Generated 06-ene-2012 23:13:53 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DocumentoIndumentariaId generated by hbm2java
 */
@Embeddable
public class DocumentoIndumentariaId implements java.io.Serializable {

	private int codigoDocumentoAcreedor;
	private int codigoTallaIndumentaria;

	public DocumentoIndumentariaId() {
	}

	public DocumentoIndumentariaId(int codigoDocumentoAcreedor,
			int codigoTallaIndumentaria) {
		this.codigoDocumentoAcreedor = codigoDocumentoAcreedor;
		this.codigoTallaIndumentaria = codigoTallaIndumentaria;
	}

	@Column(name = "codigo_documento_acreedor", nullable = false)
	public int getCodigoDocumentoAcreedor() {
		return this.codigoDocumentoAcreedor;
	}

	public void setCodigoDocumentoAcreedor(int codigoDocumentoAcreedor) {
		this.codigoDocumentoAcreedor = codigoDocumentoAcreedor;
	}

	@Column(name = "codigo_talla_indumentaria", nullable = false)
	public int getCodigoTallaIndumentaria() {
		return this.codigoTallaIndumentaria;
	}

	public void setCodigoTallaIndumentaria(int codigoTallaIndumentaria) {
		this.codigoTallaIndumentaria = codigoTallaIndumentaria;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DocumentoIndumentariaId))
			return false;
		DocumentoIndumentariaId castOther = (DocumentoIndumentariaId) other;

		return (this.getCodigoDocumentoAcreedor() == castOther
				.getCodigoDocumentoAcreedor())
				&& (this.getCodigoTallaIndumentaria() == castOther
						.getCodigoTallaIndumentaria());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoDocumentoAcreedor();
		result = 37 * result + this.getCodigoTallaIndumentaria();
		return result;
	}

}
