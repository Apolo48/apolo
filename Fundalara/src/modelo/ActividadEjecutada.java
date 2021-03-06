package modelo;

// Generated 13/02/2012 02:19:00 PM by Hibernate Tools 3.4.0.CR1

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
 * ActividadEjecutada generated by hbm2java
 */
@Entity
@Table(name = "actividad_ejecutada", schema = "public")
public class ActividadEjecutada implements java.io.Serializable {

	private int codigoActividadEjecutada;
	private SesionEjecutada sesionEjecutada;
	private ActividadEntrenamiento actividadEntrenamiento;
	private int tiempo;
	private char estatus;
	private Set<DesempennoJugador> desempennoJugadors = new HashSet<DesempennoJugador>(
			0);

	public ActividadEjecutada() {
	}

	public ActividadEjecutada(int codigoActividadEjecutada,
			SesionEjecutada sesionEjecutada,
			ActividadEntrenamiento actividadEntrenamiento, int tiempo,
			char estatus) {
		this.codigoActividadEjecutada = codigoActividadEjecutada;
		this.sesionEjecutada = sesionEjecutada;
		this.actividadEntrenamiento = actividadEntrenamiento;
		this.tiempo = tiempo;
		this.estatus = estatus;
	}

	public ActividadEjecutada(int codigoActividadEjecutada,
			SesionEjecutada sesionEjecutada,
			ActividadEntrenamiento actividadEntrenamiento, int tiempo,
			char estatus, Set<DesempennoJugador> desempennoJugadors) {
		this.codigoActividadEjecutada = codigoActividadEjecutada;
		this.sesionEjecutada = sesionEjecutada;
		this.actividadEntrenamiento = actividadEntrenamiento;
		this.tiempo = tiempo;
		this.estatus = estatus;
		this.desempennoJugadors = desempennoJugadors;
	}

	@Id
	@Column(name = "codigo_actividad_ejecutada", unique = true, nullable = false)
	public int getCodigoActividadEjecutada() {
		return this.codigoActividadEjecutada;
	}

	public void setCodigoActividadEjecutada(int codigoActividadEjecutada) {
		this.codigoActividadEjecutada = codigoActividadEjecutada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_sesion_ejecutada", nullable = false)
	public SesionEjecutada getSesionEjecutada() {
		return this.sesionEjecutada;
	}

	public void setSesionEjecutada(SesionEjecutada sesionEjecutada) {
		this.sesionEjecutada = sesionEjecutada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_actividad_entrenamiento", nullable = false)
	public ActividadEntrenamiento getActividadEntrenamiento() {
		return this.actividadEntrenamiento;
	}

	public void setActividadEntrenamiento(
			ActividadEntrenamiento actividadEntrenamiento) {
		this.actividadEntrenamiento = actividadEntrenamiento;
	}

	@Column(name = "tiempo", nullable = false)
	public int getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividadEjecutada")
	public Set<DesempennoJugador> getDesempennoJugadors() {
		return this.desempennoJugadors;
	}

	public void setDesempennoJugadors(Set<DesempennoJugador> desempennoJugadors) {
		this.desempennoJugadors = desempennoJugadors;
	}

}
