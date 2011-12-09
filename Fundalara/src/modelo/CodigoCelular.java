package modelo;

// Generated 05/12/2011 04:52:07 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CodigoCelular generated by hbm2java
 */
@Entity
@Table(name = "codigo_celular")
public class CodigoCelular implements java.io.Serializable {

	private String codigoCelular;
	private String codigoDelCelular;
	private char estatus;

	public CodigoCelular() {
	}

	public CodigoCelular(String codigoCelular, String codigoDelCelular,
			char estatus) {
		this.codigoCelular = codigoCelular;
		this.codigoDelCelular = codigoDelCelular;
		this.estatus = estatus;
	}

	@Id
	@Column(name = "codigo_celular", unique = true, nullable = false)
	public String getCodigoCelular() {
		return this.codigoCelular;
	}

	public void setCodigoCelular(String codigoCelular) {
		this.codigoCelular = codigoCelular;
	}

	@Column(name = "codigo_del_celular", nullable = false)
	public String getCodigoDelCelular() {
		return this.codigoDelCelular;
	}

	public void setCodigoDelCelular(String codigoDelCelular) {
		this.codigoDelCelular = codigoDelCelular;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
