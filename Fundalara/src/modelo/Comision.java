package modelo;

// Generated 05-dic-2011 23:09:14 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Comision generated by hbm2java
 */
@Entity
@Table(name = "comision")
public class Comision implements java.io.Serializable {

	private String codigoComision;
	private String descripcion;
	private String objetivo;
	private String estatus;
	private Set<ComisionEquipo> comisionEquipos = new HashSet<ComisionEquipo>(0);

	public Comision() {
	}

	public Comision(String codigoComision, String descripcion, String objetivo,
			String estatus) {
		this.codigoComision = codigoComision;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.estatus = estatus;
	}

	public Comision(String codigoComision, String descripcion, String objetivo,
			String estatus, Set<ComisionEquipo> comisionEquipos) {
		this.codigoComision = codigoComision;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.estatus = estatus;
		this.comisionEquipos = comisionEquipos;
	}

	@Id
	@Column(name = "codigo_comision", unique = true, nullable = false)
	public String getCodigoComision() {
		return this.codigoComision;
	}

	public void setCodigoComision(String codigoComision) {
		this.codigoComision = codigoComision;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "objetivo", nullable = false)
	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	@Column(name = "estatus", nullable = false)
	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comision")
	public Set<ComisionEquipo> getComisionEquipos() {
		return this.comisionEquipos;
	}

	public void setComisionEquipos(Set<ComisionEquipo> comisionEquipos) {
		this.comisionEquipos = comisionEquipos;
	}

}
