package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DocumentoAcreedorMaterialId generated by hbm2java
 */
@Embeddable
public class DocumentoAcreedorMaterialId implements java.io.Serializable {

	private int codigoMaterial;
	private int codigoDocumentoAcreedor;

	public DocumentoAcreedorMaterialId() {
	}

	public DocumentoAcreedorMaterialId(int codigoMaterial,
			int codigoDocumentoAcreedor) {
		this.codigoMaterial = codigoMaterial;
		this.codigoDocumentoAcreedor = codigoDocumentoAcreedor;
	}

	@Column(name = "codigo_material", nullable = false)
	public int getCodigoMaterial() {
		return this.codigoMaterial;
	}

	public void setCodigoMaterial(int codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
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
		if (!(other instanceof DocumentoAcreedorMaterialId))
			return false;
		DocumentoAcreedorMaterialId castOther = (DocumentoAcreedorMaterialId) other;

		return (this.getCodigoMaterial() == castOther.getCodigoMaterial())
				&& (this.getCodigoDocumentoAcreedor() == castOther
						.getCodigoDocumentoAcreedor());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoMaterial();
		result = 37 * result + this.getCodigoDocumentoAcreedor();
		return result;
	}

}
