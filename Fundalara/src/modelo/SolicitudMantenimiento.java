package modelo;

// Generated 11-ene-2012 21:47:34 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SolicitudMantenimiento generated by hbm2java
 */
@Entity
@Table(name = "solicitud_mantenimiento", schema = "public")
public class SolicitudMantenimiento implements java.io.Serializable {

	private SolicitudMantenimientoId id;
	private Actividad actividad;
	private DatoBasico datoBasico;
	private char estatus;

	public SolicitudMantenimiento() {
	}

	public SolicitudMantenimiento(SolicitudMantenimientoId id,
			Actividad actividad, DatoBasico datoBasico, char estatus) {
		this.id = id;
		this.actividad = actividad;
		this.datoBasico = datoBasico;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoSolicitud", column = @Column(name = "codigo_solicitud", nullable = false)),
			@AttributeOverride(name = "codigoActividad", column = @Column(name = "codigo_actividad", nullable = false)) })
	public SolicitudMantenimientoId getId() {
		return this.id;
	}

	public void setId(SolicitudMantenimientoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_actividad", nullable = false, insertable = false, updatable = false)
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

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
