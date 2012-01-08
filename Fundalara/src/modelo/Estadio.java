package modelo;

// Generated 06-ene-2012 23:13:53 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Estadio generated by hbm2java
 */
@Entity
@Table(name = "estadio", schema = "public")
public class Estadio implements java.io.Serializable {

	private int codigoEstadio;
	private DatoBasico datoBasico;
	private String nombre;
	private String direccion;
	private char estatus;
	private Set<Juego> juegos = new HashSet<Juego>(0);

	public Estadio() {
	}

	public Estadio(int codigoEstadio, DatoBasico datoBasico, String nombre,
			String direccion, char estatus) {
		this.codigoEstadio = codigoEstadio;
		this.datoBasico = datoBasico;
		this.nombre = nombre;
		this.direccion = direccion;
		this.estatus = estatus;
	}

	public Estadio(int codigoEstadio, DatoBasico datoBasico, String nombre,
			String direccion, char estatus, Set<Juego> juegos) {
		this.codigoEstadio = codigoEstadio;
		this.datoBasico = datoBasico;
		this.nombre = nombre;
		this.direccion = direccion;
		this.estatus = estatus;
		this.juegos = juegos;
	}

	@Id
	@Column(name = "codigo_estadio", unique = true, nullable = false)
	public int getCodigoEstadio() {
		return this.codigoEstadio;
	}

	public void setCodigoEstadio(int codigoEstadio) {
		this.codigoEstadio = codigoEstadio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_parroquia", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "direccion", nullable = false)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadio")
	public Set<Juego> getJuegos() {
		return this.juegos;
	}

	public void setJuegos(Set<Juego> juegos) {
		this.juegos = juegos;
	}

}
