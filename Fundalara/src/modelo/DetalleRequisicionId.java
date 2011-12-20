package modelo;

// Generated 17-dic-2011 16:31:20 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DetalleRequisicionId generated by hbm2java
 */
@Embeddable
public class DetalleRequisicionId implements java.io.Serializable {

	private int codigoMaterial;
	private int codigoRequisicion;

	public DetalleRequisicionId() {
	}

	public DetalleRequisicionId(int codigoMaterial, int codigoRequisicion) {
		this.codigoMaterial = codigoMaterial;
		this.codigoRequisicion = codigoRequisicion;
	}

	@Column(name = "codigo_material", nullable = false)
	public int getCodigoMaterial() {
		return this.codigoMaterial;
	}

	public void setCodigoMaterial(int codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	@Column(name = "codigo_requisicion", nullable = false)
	public int getCodigoRequisicion() {
		return this.codigoRequisicion;
	}

	public void setCodigoRequisicion(int codigoRequisicion) {
		this.codigoRequisicion = codigoRequisicion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DetalleRequisicionId))
			return false;
		DetalleRequisicionId castOther = (DetalleRequisicionId) other;

		return (this.getCodigoMaterial() == castOther.getCodigoMaterial())
				&& (this.getCodigoRequisicion() == castOther
						.getCodigoRequisicion());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoMaterial();
		result = 37 * result + this.getCodigoRequisicion();
		return result;
	}

}