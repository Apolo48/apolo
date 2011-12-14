package modelo;

// Generated 13-dic-2011 21:15:29 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DatoSocial generated by hbm2java
 */
@Entity
@Table(name = "dato_social")
public class DatoSocial implements java.io.Serializable {

	private String codigoDatoSocial;
	private Institucion institucion;
	private Jugador jugador;
	private TipoActividadSocial tipoActividadSocial;
	private int horasDedicadas;
	private String fechaInicio;
	private char estatus;

	public DatoSocial() {
	}

	public DatoSocial(String codigoDatoSocial, Institucion institucion,
			Jugador jugador, TipoActividadSocial tipoActividadSocial,
			int horasDedicadas, String fechaInicio, char estatus) {
		this.codigoDatoSocial = codigoDatoSocial;
		this.institucion = institucion;
		this.jugador = jugador;
		this.tipoActividadSocial = tipoActividadSocial;
		this.horasDedicadas = horasDedicadas;
		this.fechaInicio = fechaInicio;
		this.estatus = estatus;
	}

	@Id
	@Column(name = "codigo_dato_social", unique = true, nullable = false)
	public String getCodigoDatoSocial() {
		return this.codigoDatoSocial;
	}

	public void setCodigoDatoSocial(String codigoDatoSocial) {
		this.codigoDatoSocial = codigoDatoSocial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_institucion", nullable = false)
	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_jugador", nullable = false)
	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_actividad_social", nullable = false)
	public TipoActividadSocial getTipoActividadSocial() {
		return this.tipoActividadSocial;
	}

	public void setTipoActividadSocial(TipoActividadSocial tipoActividadSocial) {
		this.tipoActividadSocial = tipoActividadSocial;
	}

	@Column(name = "horas_dedicadas", nullable = false)
	public int getHorasDedicadas() {
		return this.horasDedicadas;
	}

	public void setHorasDedicadas(int horasDedicadas) {
		this.horasDedicadas = horasDedicadas;
	}

	@Column(name = "fecha_inicio", nullable = false)
	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
