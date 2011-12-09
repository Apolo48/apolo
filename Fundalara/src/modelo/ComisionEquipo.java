package modelo;

// Generated 05/12/2011 04:52:07 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ComisionEquipo generated by hbm2java
 */
@Entity
@Table(name = "comision_equipo")
public class ComisionEquipo implements java.io.Serializable {

	private ComisionEquipoId id;
	private Comision comision;
	private Equipo equipo;
	private int maximoComision;
	private int cantidadComision;
	private char estatus;
	private Set<FamiliarComisionEquipo> familiarComisionEquipos = new HashSet<FamiliarComisionEquipo>(
			0);

	public ComisionEquipo() {
	}

	public ComisionEquipo(ComisionEquipoId id, Comision comision,
			Equipo equipo, int maximoComision, int cantidadComision,
			char estatus) {
		this.id = id;
		this.comision = comision;
		this.equipo = equipo;
		this.maximoComision = maximoComision;
		this.cantidadComision = cantidadComision;
		this.estatus = estatus;
	}

	public ComisionEquipo(ComisionEquipoId id, Comision comision,
			Equipo equipo, int maximoComision, int cantidadComision,
			char estatus, Set<FamiliarComisionEquipo> familiarComisionEquipos) {
		this.id = id;
		this.comision = comision;
		this.equipo = equipo;
		this.maximoComision = maximoComision;
		this.cantidadComision = cantidadComision;
		this.estatus = estatus;
		this.familiarComisionEquipos = familiarComisionEquipos;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoComision", column = @Column(name = "codigo_comision", nullable = false)),
			@AttributeOverride(name = "codigoEquipo", column = @Column(name = "codigo_equipo", nullable = false)) })
	public ComisionEquipoId getId() {
		return this.id;
	}

	public void setId(ComisionEquipoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_comision", nullable = false, insertable = false, updatable = false)
	public Comision getComision() {
		return this.comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_equipo", nullable = false, insertable = false, updatable = false)
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

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
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
