package modelo;

// Generated 05-dic-2011 18:58:46 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pais generated by hbm2java
 */
@Entity
@Table(name = "pais")
public class Pais implements java.io.Serializable {

	private String codigoPais;
	private String nombre;
	private Set<Jugador> jugadors = new HashSet<Jugador>(0);

	public Pais() {
	}

	public Pais(String codigoPais, String nombre) {
		this.codigoPais = codigoPais;
		this.nombre = nombre;
	}

	public Pais(String codigoPais, String nombre, Set<Jugador> jugadors) {
		this.codigoPais = codigoPais;
		this.nombre = nombre;
		this.jugadors = jugadors;
	}

	@Id
	@Column(name = "codigo_pais", unique = true, nullable = false)
	public String getCodigoPais() {
		return this.codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pais")
	public Set<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(Set<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

}
