package modelo;

// Generated 05-dic-2011 22:14:58 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Parentesco generated by hbm2java
 */
@Entity
@Table(name = "parentesco")
public class Parentesco implements java.io.Serializable {

	private String codigoParentesco;
	private String nombre;
	private char estatus;
	private Set<FamiliarJugador> familiarJugadors = new HashSet<FamiliarJugador>(
			0);

	public Parentesco() {
	}

	public Parentesco(String codigoParentesco, String nombre, char estatus) {
		this.codigoParentesco = codigoParentesco;
		this.nombre = nombre;
		this.estatus = estatus;
	}

	public Parentesco(String codigoParentesco, String nombre, char estatus,
			Set<FamiliarJugador> familiarJugadors) {
		this.codigoParentesco = codigoParentesco;
		this.nombre = nombre;
		this.estatus = estatus;
		this.familiarJugadors = familiarJugadors;
	}

	@Id
	@Column(name = "codigo_parentesco", unique = true, nullable = false)
	public String getCodigoParentesco() {
		return this.codigoParentesco;
	}

	public void setCodigoParentesco(String codigoParentesco) {
		this.codigoParentesco = codigoParentesco;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentesco")
	public Set<FamiliarJugador> getFamiliarJugadors() {
		return this.familiarJugadors;
	}

	public void setFamiliarJugadors(Set<FamiliarJugador> familiarJugadors) {
		this.familiarJugadors = familiarJugadors;
	}

}
