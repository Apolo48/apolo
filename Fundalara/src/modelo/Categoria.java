package modelo;

// Generated 30-dic-2011 0:38:42 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categoria generated by hbm2java
 */
@Entity
@Table(name = "categoria", schema = "public")
public class Categoria implements java.io.Serializable {

	private int codigoCategoria;
	private String nombre;
	private int edadInferior;
	private int edadSuperior;
	private int cantidadEquipo;
	private int minimoJugador;
	private int maximoJugador;
	private char estatus;
	private Set<Liga> ligas = new HashSet<Liga>(0);
	private Set<IndicadorCategoriaCompetencia> indicadorCategoriaCompetencias = new HashSet<IndicadorCategoriaCompetencia>(
			0);
	private Set<ConstanteCategoria> constanteCategorias = new HashSet<ConstanteCategoria>(
			0);
	private Set<CategoriaCompetencia> categoriaCompetencias = new HashSet<CategoriaCompetencia>(
			0);
	private Set<PlanTemporada> planTemporadas = new HashSet<PlanTemporada>(0);
	private Set<ActividadEntrenamiento> actividadEntrenamientos = new HashSet<ActividadEntrenamiento>(
			0);
	private Set<Equipo> equipos = new HashSet<Equipo>(0);

	public Categoria() {
	}

	public Categoria(int codigoCategoria, String nombre, int edadInferior,
			int edadSuperior, int cantidadEquipo, int minimoJugador,
			int maximoJugador, char estatus) {
		this.codigoCategoria = codigoCategoria;
		this.nombre = nombre;
		this.edadInferior = edadInferior;
		this.edadSuperior = edadSuperior;
		this.cantidadEquipo = cantidadEquipo;
		this.minimoJugador = minimoJugador;
		this.maximoJugador = maximoJugador;
		this.estatus = estatus;
	}

	public Categoria(int codigoCategoria, String nombre, int edadInferior,
			int edadSuperior, int cantidadEquipo, int minimoJugador,
			int maximoJugador, char estatus, Set<Liga> ligas,
			Set<IndicadorCategoriaCompetencia> indicadorCategoriaCompetencias,
			Set<ConstanteCategoria> constanteCategorias,
			Set<CategoriaCompetencia> categoriaCompetencias,
			Set<PlanTemporada> planTemporadas,
			Set<ActividadEntrenamiento> actividadEntrenamientos,
			Set<Equipo> equipos) {
		this.codigoCategoria = codigoCategoria;
		this.nombre = nombre;
		this.edadInferior = edadInferior;
		this.edadSuperior = edadSuperior;
		this.cantidadEquipo = cantidadEquipo;
		this.minimoJugador = minimoJugador;
		this.maximoJugador = maximoJugador;
		this.estatus = estatus;
		this.ligas = ligas;
		this.indicadorCategoriaCompetencias = indicadorCategoriaCompetencias;
		this.constanteCategorias = constanteCategorias;
		this.categoriaCompetencias = categoriaCompetencias;
		this.planTemporadas = planTemporadas;
		this.actividadEntrenamientos = actividadEntrenamientos;
		this.equipos = equipos;
	}

	@Id
	@Column(name = "codigo_categoria", unique = true, nullable = false)
	public int getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "edad_inferior", nullable = false)
	public int getEdadInferior() {
		return this.edadInferior;
	}

	public void setEdadInferior(int edadInferior) {
		this.edadInferior = edadInferior;
	}

	@Column(name = "edad_superior", nullable = false)
	public int getEdadSuperior() {
		return this.edadSuperior;
	}

	public void setEdadSuperior(int edadSuperior) {
		this.edadSuperior = edadSuperior;
	}

	@Column(name = "cantidad_equipo", nullable = false)
	public int getCantidadEquipo() {
		return this.cantidadEquipo;
	}

	public void setCantidadEquipo(int cantidadEquipo) {
		this.cantidadEquipo = cantidadEquipo;
	}

	@Column(name = "minimo_jugador", nullable = false)
	public int getMinimoJugador() {
		return this.minimoJugador;
	}

	public void setMinimoJugador(int minimoJugador) {
		this.minimoJugador = minimoJugador;
	}

	@Column(name = "maximo_jugador", nullable = false)
	public int getMaximoJugador() {
		return this.maximoJugador;
	}

	public void setMaximoJugador(int maximoJugador) {
		this.maximoJugador = maximoJugador;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
	public Set<Liga> getLigas() {
		return this.ligas;
	}

	public void setLigas(Set<Liga> ligas) {
		this.ligas = ligas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<IndicadorCategoriaCompetencia> getIndicadorCategoriaCompetencias() {
		return this.indicadorCategoriaCompetencias;
	}

	public void setIndicadorCategoriaCompetencias(
			Set<IndicadorCategoriaCompetencia> indicadorCategoriaCompetencias) {
		this.indicadorCategoriaCompetencias = indicadorCategoriaCompetencias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<ConstanteCategoria> getConstanteCategorias() {
		return this.constanteCategorias;
	}

	public void setConstanteCategorias(
			Set<ConstanteCategoria> constanteCategorias) {
		this.constanteCategorias = constanteCategorias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<CategoriaCompetencia> getCategoriaCompetencias() {
		return this.categoriaCompetencias;
	}

	public void setCategoriaCompetencias(
			Set<CategoriaCompetencia> categoriaCompetencias) {
		this.categoriaCompetencias = categoriaCompetencias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<PlanTemporada> getPlanTemporadas() {
		return this.planTemporadas;
	}

	public void setPlanTemporadas(Set<PlanTemporada> planTemporadas) {
		this.planTemporadas = planTemporadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<ActividadEntrenamiento> getActividadEntrenamientos() {
		return this.actividadEntrenamientos;
	}

	public void setActividadEntrenamientos(
			Set<ActividadEntrenamiento> actividadEntrenamientos) {
		this.actividadEntrenamientos = actividadEntrenamientos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

}
