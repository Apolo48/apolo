package modelo;

// Generated 06-ene-2012 23:13:53 by Hibernate Tools 3.4.0.CR1

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
 * PersonalContrato generated by hbm2java
 */
@Entity
@Table(name = "personal_contrato", schema = "public")
public class PersonalContrato implements java.io.Serializable {

	private int codigoPersonalContrato;
	private DatoBasico datoBasicoByCodigoModalidad;
	private DatoBasico datoBasicoByCodigoHorario;
	private Personal personal;
	private Date fechaInicio;
	private Date fechaFin;

	public PersonalContrato() {
	}

	public PersonalContrato(int codigoPersonalContrato,
			DatoBasico datoBasicoByCodigoModalidad,
			DatoBasico datoBasicoByCodigoHorario, Personal personal,
			Date fechaInicio) {
		this.codigoPersonalContrato = codigoPersonalContrato;
		this.datoBasicoByCodigoModalidad = datoBasicoByCodigoModalidad;
		this.datoBasicoByCodigoHorario = datoBasicoByCodigoHorario;
		this.personal = personal;
		this.fechaInicio = fechaInicio;
	}

	public PersonalContrato(int codigoPersonalContrato,
			DatoBasico datoBasicoByCodigoModalidad,
			DatoBasico datoBasicoByCodigoHorario, Personal personal,
			Date fechaInicio, Date fechaFin) {
		this.codigoPersonalContrato = codigoPersonalContrato;
		this.datoBasicoByCodigoModalidad = datoBasicoByCodigoModalidad;
		this.datoBasicoByCodigoHorario = datoBasicoByCodigoHorario;
		this.personal = personal;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	@Id
	@Column(name = "codigo_personal_contrato", unique = true, nullable = false)
	public int getCodigoPersonalContrato() {
		return this.codigoPersonalContrato;
	}

	public void setCodigoPersonalContrato(int codigoPersonalContrato) {
		this.codigoPersonalContrato = codigoPersonalContrato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_modalidad", nullable = false)
	public DatoBasico getDatoBasicoByCodigoModalidad() {
		return this.datoBasicoByCodigoModalidad;
	}

	public void setDatoBasicoByCodigoModalidad(
			DatoBasico datoBasicoByCodigoModalidad) {
		this.datoBasicoByCodigoModalidad = datoBasicoByCodigoModalidad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_horario", nullable = false)
	public DatoBasico getDatoBasicoByCodigoHorario() {
		return this.datoBasicoByCodigoHorario;
	}

	public void setDatoBasicoByCodigoHorario(
			DatoBasico datoBasicoByCodigoHorario) {
		this.datoBasicoByCodigoHorario = datoBasicoByCodigoHorario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_rif", nullable = false)
	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
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
	@Column(name = "fecha_fin", length = 13)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
