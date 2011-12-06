package modelo;

// Generated 05-dic-2011 18:58:46 by Hibernate Tools 3.4.0.CR1

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
 * IndicadorActividadEscala generated by hbm2java
 */
@Entity
@Table(name = "indicador_actividad_escala")
public class IndicadorActividadEscala implements java.io.Serializable {

	private IndicadorActividadEscalaId id;
	private EscalaMedicion escalaMedicion;
	private ActividadEntrenamiento actividadEntrenamiento;
	private Indicador indicador;

	public IndicadorActividadEscala() {
	}

	public IndicadorActividadEscala(IndicadorActividadEscalaId id,
			EscalaMedicion escalaMedicion,
			ActividadEntrenamiento actividadEntrenamiento, Indicador indicador) {
		this.id = id;
		this.escalaMedicion = escalaMedicion;
		this.actividadEntrenamiento = actividadEntrenamiento;
		this.indicador = indicador;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codIndicador", column = @Column(name = "cod_indicador", nullable = false)),
			@AttributeOverride(name = "codActividadEntrenamiento", column = @Column(name = "cod_actividad_entrenamiento", nullable = false)) })
	public IndicadorActividadEscalaId getId() {
		return this.id;
	}

	public void setId(IndicadorActividadEscalaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_escala_medicion", nullable = false)
	public EscalaMedicion getEscalaMedicion() {
		return this.escalaMedicion;
	}

	public void setEscalaMedicion(EscalaMedicion escalaMedicion) {
		this.escalaMedicion = escalaMedicion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_actividad_entrenamiento", nullable = false, insertable = false, updatable = false)
	public ActividadEntrenamiento getActividadEntrenamiento() {
		return this.actividadEntrenamiento;
	}

	public void setActividadEntrenamiento(
			ActividadEntrenamiento actividadEntrenamiento) {
		this.actividadEntrenamiento = actividadEntrenamiento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_indicador", nullable = false, insertable = false, updatable = false)
	public Indicador getIndicador() {
		return this.indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

}