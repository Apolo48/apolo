package modelo;

// Generated 09/01/2012 10:19:56 AM by Hibernate Tools 3.4.0.CR1

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
 * Equipo generated by hbm2java
 */
@Entity
@Table(name = "equipo", schema = "public")
public class Equipo implements java.io.Serializable {

	private int codigoEquipo;
	private Categoria categoria;
	private Divisa divisa;
	private DatoBasico datoBasico;
	private String nombre;
	private char estatus;
	private Set<PersonalEquipo> personalEquipos = new HashSet<PersonalEquipo>(0);
	private Set<Roster> rosters = new HashSet<Roster>(0);
	private Set<EquipoCompetencia> equipoCompetencias = new HashSet<EquipoCompetencia>(
			0);
	private Set<TestEvaluativo> testEvaluativos = new HashSet<TestEvaluativo>(0);
	private Set<SesionEjecutada> sesionEjecutadas = new HashSet<SesionEjecutada>(
			0);
	private Set<Sesion> sesions = new HashSet<Sesion>(0);
	private Set<ComisionEquipo> comisionEquipos = new HashSet<ComisionEquipo>(0);

	public Equipo() {
	}

	public Equipo(int codigoEquipo, Categoria categoria, Divisa divisa,
			DatoBasico datoBasico, String nombre, char estatus) {
		this.codigoEquipo = codigoEquipo;
		this.categoria = categoria;
		this.divisa = divisa;
		this.datoBasico = datoBasico;
		this.nombre = nombre;
		this.estatus = estatus;
	}

	public Equipo(int codigoEquipo, Categoria categoria, Divisa divisa,
			DatoBasico datoBasico, String nombre, char estatus,
			Set<PersonalEquipo> personalEquipos, Set<Roster> rosters,
			Set<EquipoCompetencia> equipoCompetencias,
			Set<TestEvaluativo> testEvaluativos,
			Set<SesionEjecutada> sesionEjecutadas, Set<Sesion> sesions,
			Set<ComisionEquipo> comisionEquipos) {
		this.codigoEquipo = codigoEquipo;
		this.categoria = categoria;
		this.divisa = divisa;
		this.datoBasico = datoBasico;
		this.nombre = nombre;
		this.estatus = estatus;
		this.personalEquipos = personalEquipos;
		this.rosters = rosters;
		this.equipoCompetencias = equipoCompetencias;
		this.testEvaluativos = testEvaluativos;
		this.sesionEjecutadas = sesionEjecutadas;
		this.sesions = sesions;
		this.comisionEquipos = comisionEquipos;
	}

	@Id
	@Column(name = "codigo_equipo", unique = true, nullable = false)
	public int getCodigoEquipo() {
		return this.codigoEquipo;
	}

	public void setCodigoEquipo(int codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_categoria", nullable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_divisa", nullable = false)
	public Divisa getDivisa() {
		return this.divisa;
	}

	public void setDivisa(Divisa divisa) {
		this.divisa = divisa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_clasificacion", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<PersonalEquipo> getPersonalEquipos() {
		return this.personalEquipos;
	}

	public void setPersonalEquipos(Set<PersonalEquipo> personalEquipos) {
		this.personalEquipos = personalEquipos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<Roster> getRosters() {
		return this.rosters;
	}

	public void setRosters(Set<Roster> rosters) {
		this.rosters = rosters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<EquipoCompetencia> getEquipoCompetencias() {
		return this.equipoCompetencias;
	}

	public void setEquipoCompetencias(Set<EquipoCompetencia> equipoCompetencias) {
		this.equipoCompetencias = equipoCompetencias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<TestEvaluativo> getTestEvaluativos() {
		return this.testEvaluativos;
	}

	public void setTestEvaluativos(Set<TestEvaluativo> testEvaluativos) {
		this.testEvaluativos = testEvaluativos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<SesionEjecutada> getSesionEjecutadas() {
		return this.sesionEjecutadas;
	}

	public void setSesionEjecutadas(Set<SesionEjecutada> sesionEjecutadas) {
		this.sesionEjecutadas = sesionEjecutadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<Sesion> getSesions() {
		return this.sesions;
	}

	public void setSesions(Set<Sesion> sesions) {
		this.sesions = sesions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public Set<ComisionEquipo> getComisionEquipos() {
		return this.comisionEquipos;
	}

	public void setComisionEquipos(Set<ComisionEquipo> comisionEquipos) {
		this.comisionEquipos = comisionEquipos;
	}

}
