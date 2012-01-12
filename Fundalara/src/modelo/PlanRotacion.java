package modelo;

// Generated 11-ene-2012 21:47:34 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PlanRotacion generated by hbm2java
 */
@Entity
@Table(name = "plan_rotacion", schema = "public")
public class PlanRotacion implements java.io.Serializable {

	private int codigoPlanRotacion;
	private Instalacion instalacion;
	private Sesion sesion;
	private Date fechaInicio;
	private Date fechaFin;
	private char estatus;

	public PlanRotacion() {
	}

	public PlanRotacion(int codigoPlanRotacion, Instalacion instalacion,
			Sesion sesion, Date fechaInicio, Date fechaFin, char estatus) {
		this.codigoPlanRotacion = codigoPlanRotacion;
		this.instalacion = instalacion;
		this.sesion = sesion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estatus = estatus;
	}

	@Id
	@Column(name = "codigo_plan_rotacion", unique = true, nullable = false)
	public int getCodigoPlanRotacion() {
		return this.codigoPlanRotacion;
	}

	public void setCodigoPlanRotacion(int codigoPlanRotacion) {
		this.codigoPlanRotacion = codigoPlanRotacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_instalacion", nullable = false)
	public Instalacion getInstalacion() {
		return this.instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_sesion", nullable = false)
	public Sesion getSesion() {
		return this.sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio", nullable = false, length = 13)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin", nullable = false, length = 13)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
