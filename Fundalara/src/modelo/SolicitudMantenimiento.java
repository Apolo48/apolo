package modelo;

// Generated 13/02/2012 02:19:00 PM by Hibernate Tools 3.4.0.CR1

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
 * SolicitudMantenimiento generated by hbm2java
 */
@Entity
@Table(name = "solicitud_mantenimiento", schema = "public")
public class SolicitudMantenimiento implements java.io.Serializable {

	private int codigoSolicitud;
	private Actividad actividad;
	private DatoBasico datoBasico;
	private String descripcionActividad;
	private char estatus;
	private Date fechaSolicitud;

	public SolicitudMantenimiento() {
	}

	public SolicitudMantenimiento(int codigoSolicitud, Actividad actividad,
			DatoBasico datoBasico, String descripcionActividad, char estatus,
			Date fechaSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
		this.actividad = actividad;
		this.datoBasico = datoBasico;
		this.descripcionActividad = descripcionActividad;
		this.estatus = estatus;
		this.fechaSolicitud = fechaSolicitud;
	}

	@Id
	@Column(name = "codigo_solicitud", unique = true, nullable = false)
	public int getCodigoSolicitud() {
		return this.codigoSolicitud;
	}

	public void setCodigoSolicitud(int codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_actividad", nullable = false)
	public Actividad getActividad() {
		return this.actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_prioridad", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "descripcion_actividad", nullable = false)
	public String getDescripcionActividad() {
		return this.descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_solicitud", nullable = false, length = 13)
	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

}
