package modelo;

// Generated 13-ene-2012 22:07:27 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RecepcionMaterialId generated by hbm2java
 */
@Embeddable
public class RecepcionMaterialId implements java.io.Serializable {

	private int codigoMaterial;
	private int codigoNotaEntrega;
	private String origen;

	public RecepcionMaterialId() {
	}

	public RecepcionMaterialId(int codigoMaterial, int codigoNotaEntrega,
			String origen) {
		this.codigoMaterial = codigoMaterial;
		this.codigoNotaEntrega = codigoNotaEntrega;
		this.origen = origen;
	}

	@Column(name = "codigo_material", nullable = false)
	public int getCodigoMaterial() {
		return this.codigoMaterial;
	}

	public void setCodigoMaterial(int codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	@Column(name = "codigo_nota_entrega", nullable = false)
	public int getCodigoNotaEntrega() {
		return this.codigoNotaEntrega;
	}

	public void setCodigoNotaEntrega(int codigoNotaEntrega) {
		this.codigoNotaEntrega = codigoNotaEntrega;
	}

	@Column(name = "origen", nullable = false)
	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RecepcionMaterialId))
			return false;
		RecepcionMaterialId castOther = (RecepcionMaterialId) other;

		return (this.getCodigoMaterial() == castOther.getCodigoMaterial())
				&& (this.getCodigoNotaEntrega() == castOther
						.getCodigoNotaEntrega())
				&& ((this.getOrigen() == castOther.getOrigen()) || (this
						.getOrigen() != null && castOther.getOrigen() != null && this
						.getOrigen().equals(castOther.getOrigen())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoMaterial();
		result = 37 * result + this.getCodigoNotaEntrega();
		result = 37 * result
				+ (getOrigen() == null ? 0 : this.getOrigen().hashCode());
		return result;
	}

}
