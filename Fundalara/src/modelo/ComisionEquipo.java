package modelo;

// Generated 11-ene-2012 21:47:34 by Hibernate Tools 3.4.0.CR1

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
 * ComisionEquipo generated by hbm2java
 */
@Entity
@Table(name = "comision_equipo", schema = "public")
public class ComisionEquipo implements java.io.Serializable {

	private int codigoComisionEquipo;
	private DatoBasico datoBasico;
	private Equipo equipo;
	private int maximoComision;
	private int cantidadComision;
	private char estatus1;
	private Set<FamiliarComisionEquipo> familiarComisionEquipos = new HashSet<FamiliarComisionEquipo>(
			0);

	public ComisionEquipo() {
	}

	public ComisionEquipo(int codigoComisionEquipo, DatoBasico datoBasico,
			Equipo equipo, int maximoComision, int cantidadComision,
			char estatus1) {
		this.codigoComisionEquipo = codigoComisionEquipo;
		this.datoBasico = datoBasico;
		this.equipo = equipo;
		this.maximoComision = maximoComision;
		this.cantidadComision = cantidadComision;
		this.estatus1 = estatus1;
	}

	public ComisionEquipo(int codigoComisionEquipo, DatoBasico datoBasico,
			Equipo equipo, int maximoComision, int cantidadComision,
			char estatus1, Set<FamiliarComisionEquipo> familiarComisionEquipos) {
		this.codigoComisionEquipo = codigoComisionEquipo;
		this.datoBasico = datoBasico;
		this.equipo = equipo;
		this.maximoComision = maximoComision;
		this.cantidadComision = cantidadComision;
		this.estatus1 = estatus1;
		this.familiarComisionEquipos = familiarComisionEquipos;
	}

	@Id
	@Column(name = "codigo_comision_equipo", unique = true, nullable = false)
	public int getCodigoComisionEquipo() {
		return this.codigoComisionEquipo;
	}

	public void setCodigoComisionEquipo(int codigoComisionEquipo) {
		this.codigoComisionEquipo = codigoComisionEquipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_comision", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_equipo", nullable = false)
	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Column(name = "maximo_comision", nullable = false)
	public int getMaximoComision() {
		return this.maximoComision;
	}

	public void setMaximoComision(int maximoComision) {
		this.maximoComision = maximoComision;
	}

	@Column(name = "cantidad_comision", nullable = false)
	public int getCantidadComision() {
		return this.cantidadComision;
	}

	public void setCantidadComision(int cantidadComision) {
		this.cantidadComision = cantidadComision;
	}

	@Column(name = "estatus_1", nullable = false, length = 1)
	public char getEstatus1() {
		return this.estatus1;
	}

	public void setEstatus1(char estatus1) {
		this.estatus1 = estatus1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comisionEquipo")
	public Set<FamiliarComisionEquipo> getFamiliarComisionEquipos() {
		return this.familiarComisionEquipos;
	}

	public void setFamiliarComisionEquipos(
			Set<FamiliarComisionEquipo> familiarComisionEquipos) {
		this.familiarComisionEquipos = familiarComisionEquipos;
	}

}
