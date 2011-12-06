package modelo;

// Generated 05-dic-2011 22:14:58 by Hibernate Tools 3.4.0.CR1

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
@Table(name = "categoria")
public class Categoria implements java.io.Serializable {

	private String codigoCategoria;
	private String nombre;
	private int edadInferior;
	private int edadSuperior;
	private int cantidadEquipo;
	private int minimoJugador;
	private int maximoJugador;
	private char estatus;
	private Set<Liga> ligas = new HashSet<Liga>(0);
	private Set<CategoriaCompetencia> categoriaCompetencias = new HashSet<CategoriaCompetencia>(
			0);
	private Set<ActividadEntrenamiento> actividadEntrenamientos = new HashSet<ActividadEntrenamiento>(
			0);
	private Set<Equipo> equipos = new HashSet<Equipo>(0);

	public Categoria() {
	}

	public Categoria(String codigoCategoria, String nombre, int edadInferior,
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

	public Categoria(String codigoCategoria, String nombre, int edadInferior,
			int edadSuperior, int cantidadEquipo, int minimoJugador,
			int maximoJugador, char estatus, Set<Liga> ligas,
			Set<CategoriaCompetencia> categoriaCompetencias,
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
		this.categoriaCompetencias = categoriaCompetencias;
		this.actividadEntrenamientos = actividadEntrenamientos;
		this.equipos = equipos;
	}

	@Id
	@Column(name = "codigo_categoria", unique = true, nullable = false)
	public String getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(String codigoCategoria) {
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
	public Set<CategoriaCompetencia> getCategoriaCompetencias() {
		return this.categoriaCompetencias;
	}

	public void setCategoriaCompetencias(
			Set<CategoriaCompetencia> categoriaCompetencias) {
		this.categoriaCompetencias = categoriaCompetencias;
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
