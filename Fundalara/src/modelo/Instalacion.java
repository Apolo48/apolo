package modelo;

// Generated 05/12/2011 04:52:07 PM by Hibernate Tools 3.4.0.CR1

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
 * Instalacion generated by hbm2java
 */
@Entity
@Table(name = "instalacion")
public class Instalacion implements java.io.Serializable {

	private String codigoInstalacion;
	private TipoInstalacion tipoInstalacion;
	private String descripcion;
	private char estatus;
	private Set<PlanificacionMantenimiento> planificacionMantenimientos = new HashSet<PlanificacionMantenimiento>(
			0);

	public Instalacion() {
	}

	public Instalacion(String codigoInstalacion,
			TipoInstalacion tipoInstalacion, String descripcion, char estatus) {
		this.codigoInstalacion = codigoInstalacion;
		this.tipoInstalacion = tipoInstalacion;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public Instalacion(String codigoInstalacion,
			TipoInstalacion tipoInstalacion, String descripcion, char estatus,
			Set<PlanificacionMantenimiento> planificacionMantenimientos) {
		this.codigoInstalacion = codigoInstalacion;
		this.tipoInstalacion = tipoInstalacion;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.planificacionMantenimientos = planificacionMantenimientos;
	}

	@Id
	@Column(name = "codigo_instalacion", unique = true, nullable = false)
	public String getCodigoInstalacion() {
		return this.codigoInstalacion;
	}

	public void setCodigoInstalacion(String codigoInstalacion) {
		this.codigoInstalacion = codigoInstalacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_instalacion", nullable = false)
	public TipoInstalacion getTipoInstalacion() {
		return this.tipoInstalacion;
	}

	public void setTipoInstalacion(TipoInstalacion tipoInstalacion) {
		this.tipoInstalacion = tipoInstalacion;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instalacion")
	public Set<PlanificacionMantenimiento> getPlanificacionMantenimientos() {
		return this.planificacionMantenimientos;
	}

	public void setPlanificacionMantenimientos(
			Set<PlanificacionMantenimiento> planificacionMantenimientos) {
		this.planificacionMantenimientos = planificacionMantenimientos;
	}

}
