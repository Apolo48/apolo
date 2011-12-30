package modelo;

// Generated 30-dic-2011 0:38:42 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RecepcionMaterialId generated by hbm2java
 */
@Embeddable
public class RecepcionMaterialId implements java.io.Serializable {

	private int codigoNotaEntrega;
	private int codigoMaterial;

	public RecepcionMaterialId() {
	}

	public RecepcionMaterialId(int codigoNotaEntrega, int codigoMaterial) {
		this.codigoNotaEntrega = codigoNotaEntrega;
		this.codigoMaterial = codigoMaterial;
	}

	@Column(name = "codigo_nota_entrega", nullable = false)
	public int getCodigoNotaEntrega() {
		return this.codigoNotaEntrega;
	}

	public void setCodigoNotaEntrega(int codigoNotaEntrega) {
		this.codigoNotaEntrega = codigoNotaEntrega;
	}

	@Column(name = "codigo_material", nullable = false)
	public int getCodigoMaterial() {
		return this.codigoMaterial;
	}

	public void setCodigoMaterial(int codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RecepcionMaterialId))
			return false;
		RecepcionMaterialId castOther = (RecepcionMaterialId) other;

		return (this.getCodigoNotaEntrega() == castOther.getCodigoNotaEntrega())
				&& (this.getCodigoMaterial() == castOther.getCodigoMaterial());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoNotaEntrega();
		result = 37 * result + this.getCodigoMaterial();
		return result;
	}

}
