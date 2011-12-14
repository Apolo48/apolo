package modelo;

// Generated 13-dic-2011 23:21:03 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Recaudo generated by hbm2java
 */
@Entity
@Table(name = "recaudo")
public class Recaudo implements java.io.Serializable {

	private String codigoRecaudo;
	private String nombre;
	private char estatus;

	public Recaudo() {
	}

	public Recaudo(String codigoRecaudo, String nombre, char estatus) {
		this.codigoRecaudo = codigoRecaudo;
		this.nombre = nombre;
		this.estatus = estatus;
	}

	@Id
	@Column(name = "codigo_recaudo", unique = true, nullable = false)
	public String getCodigoRecaudo() {
		return this.codigoRecaudo;
	}

	public void setCodigoRecaudo(String codigoRecaudo) {
		this.codigoRecaudo = codigoRecaudo;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
