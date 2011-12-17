package modelo;

// Generated 17/12/2011 10:20:04 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CodigoArea generated by hbm2java
 */
@Entity
@Table(name = "codigo_area")
public class CodigoArea implements java.io.Serializable {

	private String codigoArea;
	private String codigoDeArea;
	private char estatus;

	public CodigoArea() {
	}

	public CodigoArea(String codigoArea, String codigoDeArea, char estatus) {
		this.codigoArea = codigoArea;
		this.codigoDeArea = codigoDeArea;
		this.estatus = estatus;
	}

	@Id
	@Column(name = "codigo_area", unique = true, nullable = false)
	public String getCodigoArea() {
		return this.codigoArea;
	}

	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

	@Column(name = "codigo_de_area", nullable = false)
	public String getCodigoDeArea() {
		return this.codigoDeArea;
	}

	public void setCodigoDeArea(String codigoDeArea) {
		this.codigoDeArea = codigoDeArea;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
