package modelo;

// Generated 17-dic-2011 16:31:20 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ActividadesEjecutadas generated by hbm2java
 */
@Entity
@Table(name = "actividades_ejecutadas")
public class ActividadesEjecutadas implements java.io.Serializable {

	private int codigoActividadEjecutada;
	private SesionEjecutada sesionEjecutada;
	private IndicadorActividadEscala indicadorActividadEscala;
	private Date tiempo;
	private char estatus;
	private Set<DesempeoJugador> desempeoJugadors = new HashSet<DesempeoJugador>(
			0);

	public ActividadesEjecutadas() {
	}

	public ActividadesEjecutadas(int codigoActividadEjecutada,
			SesionEjecutada sesionEjecutada,
			IndicadorActividadEscala indicadorActividadEscala, Date tiempo,
			char estatus) {
		this.codigoActividadEjecutada = codigoActividadEjecutada;
		this.sesionEjecutada = sesionEjecutada;
		this.indicadorActividadEscala = indicadorActividadEscala;
		this.tiempo = tiempo;
		this.estatus = estatus;
	}

	public ActividadesEjecutadas(int codigoActividadEjecutada,
			SesionEjecutada sesionEjecutada,
			IndicadorActividadEscala indicadorActividadEscala, Date tiempo,
			char estatus, Set<DesempeoJugador> desempeoJugadors) {
		this.codigoActividadEjecutada = codigoActividadEjecutada;
		this.sesionEjecutada = sesionEjecutada;
		this.indicadorActividadEscala = indicadorActividadEscala;
		this.tiempo = tiempo;
		this.estatus = estatus;
		this.desempeoJugadors = desempeoJugadors;
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
	@JoinColumn(name = "codigo_indicador_actividad_escala", nullable = false)
	public IndicadorActividadEscala getIndicadorActividadEscala() {
		return this.indicadorActividadEscala;
	}

	public void setIndicadorActividadEscala(
			IndicadorActividadEscala indicadorActividadEscala) {
		this.indicadorActividadEscala = indicadorActividadEscala;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "tiempo", nullable = false, length = 15)
	public Date getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actividadesEjecutadas")
	public Set<DesempeoJugador> getDesempeoJugadors() {
		return this.desempeoJugadors;
	}

	public void setDesempeoJugadors(Set<DesempeoJugador> desempeoJugadors) {
		this.desempeoJugadors = desempeoJugadors;
	}

}
