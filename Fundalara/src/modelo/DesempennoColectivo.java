package modelo;

// Generated 13/02/2012 02:19:00 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DesempennoColectivo generated by hbm2java
 */
@Entity
@Table(name = "desempenno_colectivo", schema = "public")
public class DesempennoColectivo implements java.io.Serializable {

	private int codigoDesempennoColectivo;
	private IndicadorCategoriaCompetencia indicadorCategoriaCompetencia;
	private EquipoJuego equipoJuego;
	private float valor;
	private Integer inning;

	public DesempennoColectivo() {
	}

	public DesempennoColectivo(int codigoDesempennoColectivo,
			IndicadorCategoriaCompetencia indicadorCategoriaCompetencia,
			EquipoJuego equipoJuego, float valor) {
		this.codigoDesempennoColectivo = codigoDesempennoColectivo;
		this.indicadorCategoriaCompetencia = indicadorCategoriaCompetencia;
		this.equipoJuego = equipoJuego;
		this.valor = valor;
	}

	public DesempennoColectivo(int codigoDesempennoColectivo,
			IndicadorCategoriaCompetencia indicadorCategoriaCompetencia,
			EquipoJuego equipoJuego, float valor, Integer inning) {
		this.codigoDesempennoColectivo = codigoDesempennoColectivo;
		this.indicadorCategoriaCompetencia = indicadorCategoriaCompetencia;
		this.equipoJuego = equipoJuego;
		this.valor = valor;
		this.inning = inning;
	}

	@Id
	@Column(name = "codigo_desempenno_colectivo", unique = true, nullable = false)
	public int getCodigoDesempennoColectivo() {
		return this.codigoDesempennoColectivo;
	}

	public void setCodigoDesempennoColectivo(int codigoDesempennoColectivo) {
		this.codigoDesempennoColectivo = codigoDesempennoColectivo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_indicador_categoria_competencia", nullable = false)
	public IndicadorCategoriaCompetencia getIndicadorCategoriaCompetencia() {
		return this.indicadorCategoriaCompetencia;
	}

	public void setIndicadorCategoriaCompetencia(
			IndicadorCategoriaCompetencia indicadorCategoriaCompetencia) {
		this.indicadorCategoriaCompetencia = indicadorCategoriaCompetencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_equipo_juego", nullable = false)
	public EquipoJuego getEquipoJuego() {
		return this.equipoJuego;
	}

	public void setEquipoJuego(EquipoJuego equipoJuego) {
		this.equipoJuego = equipoJuego;
	}

	@Column(name = "valor", nullable = false, precision = 8, scale = 8)
	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Column(name = "inning")
	public Integer getInning() {
		return this.inning;
	}

	public void setInning(Integer inning) {
		this.inning = inning;
	}

}
