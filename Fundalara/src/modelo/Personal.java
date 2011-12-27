package modelo;

// Generated 26-dic-2011 21:37:05 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Personal generated by hbm2java
 */
@Entity
@Table(name = "personal", schema = "public")
public class Personal implements java.io.Serializable {

	private String cedulaRif;
	private PersonaNatural personaNatural;
	private int cantidadHijos;
	private char estatus;
	private String estadoCivil;
	private String tipoSangre;
	private Set<Requisicion> requisicions = new HashSet<Requisicion>(0);
	private Set<PersonalTipoNomina> personalTipoNominas = new HashSet<PersonalTipoNomina>(
			0);
	private Set<PersonalContrato> personalContratos = new HashSet<PersonalContrato>(
			0);
	private Set<PersonalEquipo> personalEquipos = new HashSet<PersonalEquipo>(0);
	private Set<PersonalActividadPlanificada> personalActividadPlanificadas = new HashSet<PersonalActividadPlanificada>(
			0);
	private Usuario usuario;
	private Set<Movimiento> movimientos = new HashSet<Movimiento>(0);
	private Set<PersonalJuego> personalJuegos = new HashSet<PersonalJuego>(0);
	private Set<PersonalConceptoNomina> personalConceptoNominas = new HashSet<PersonalConceptoNomina>(
			0);
	private Set<DatoAcademicoPersonal> datoAcademicoPersonals = new HashSet<DatoAcademicoPersonal>(
			0);
	private Set<AfeccionPersonal> afeccionPersonals = new HashSet<AfeccionPersonal>(
			0);
	private Set<PersonalActividad> personalActividads = new HashSet<PersonalActividad>(
			0);
	private Set<PersonalCargo> personalCargos = new HashSet<PersonalCargo>(0);

	public Personal() {
	}

	public Personal(PersonaNatural personaNatural, int cantidadHijos,
			char estatus, String estadoCivil) {
		this.personaNatural = personaNatural;
		this.cantidadHijos = cantidadHijos;
		this.estatus = estatus;
		this.estadoCivil = estadoCivil;
	}

	public Personal(PersonaNatural personaNatural, int cantidadHijos,
			char estatus, String estadoCivil, String tipoSangre,
			Set<Requisicion> requisicions,
			Set<PersonalTipoNomina> personalTipoNominas,
			Set<PersonalContrato> personalContratos,
			Set<PersonalEquipo> personalEquipos,
			Set<PersonalActividadPlanificada> personalActividadPlanificadas,
			Usuario usuario, Set<Movimiento> movimientos,
			Set<PersonalJuego> personalJuegos,
			Set<PersonalConceptoNomina> personalConceptoNominas,
			Set<DatoAcademicoPersonal> datoAcademicoPersonals,
			Set<AfeccionPersonal> afeccionPersonals,
			Set<PersonalActividad> personalActividads,
			Set<PersonalCargo> personalCargos) {
		this.personaNatural = personaNatural;
		this.cantidadHijos = cantidadHijos;
		this.estatus = estatus;
		this.estadoCivil = estadoCivil;
		this.tipoSangre = tipoSangre;
		this.requisicions = requisicions;
		this.personalTipoNominas = personalTipoNominas;
		this.personalContratos = personalContratos;
		this.personalEquipos = personalEquipos;
		this.personalActividadPlanificadas = personalActividadPlanificadas;
		this.usuario = usuario;
		this.movimientos = movimientos;
		this.personalJuegos = personalJuegos;
		this.personalConceptoNominas = personalConceptoNominas;
		this.datoAcademicoPersonals = datoAcademicoPersonals;
		this.afeccionPersonals = afeccionPersonals;
		this.personalActividads = personalActividads;
		this.personalCargos = personalCargos;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "personaNatural"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "cedula_rif", unique = true, nullable = false)
	public String getCedulaRif() {
		return this.cedulaRif;
	}

	public void setCedulaRif(String cedulaRif) {
		this.cedulaRif = cedulaRif;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public PersonaNatural getPersonaNatural() {
		return this.personaNatural;
	}

	public void setPersonaNatural(PersonaNatural personaNatural) {
		this.personaNatural = personaNatural;
	}

	@Column(name = "cantidad_hijos", nullable = false)
	public int getCantidadHijos() {
		return this.cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@Column(name = "estado_civil", nullable = false)
	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Column(name = "tipo_sangre")
	public String getTipoSangre() {
		return this.tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<Requisicion> getRequisicions() {
		return this.requisicions;
	}

	public void setRequisicions(Set<Requisicion> requisicions) {
		this.requisicions = requisicions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<PersonalTipoNomina> getPersonalTipoNominas() {
		return this.personalTipoNominas;
	}

	public void setPersonalTipoNominas(
			Set<PersonalTipoNomina> personalTipoNominas) {
		this.personalTipoNominas = personalTipoNominas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<PersonalContrato> getPersonalContratos() {
		return this.personalContratos;
	}

	public void setPersonalContratos(Set<PersonalContrato> personalContratos) {
		this.personalContratos = personalContratos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<PersonalEquipo> getPersonalEquipos() {
		return this.personalEquipos;
	}

	public void setPersonalEquipos(Set<PersonalEquipo> personalEquipos) {
		this.personalEquipos = personalEquipos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<PersonalActividadPlanificada> getPersonalActividadPlanificadas() {
		return this.personalActividadPlanificadas;
	}

	public void setPersonalActividadPlanificadas(
			Set<PersonalActividadPlanificada> personalActividadPlanificadas) {
		this.personalActividadPlanificadas = personalActividadPlanificadas;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "personal")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<PersonalJuego> getPersonalJuegos() {
		return this.personalJuegos;
	}

	public void setPersonalJuegos(Set<PersonalJuego> personalJuegos) {
		this.personalJuegos = personalJuegos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<PersonalConceptoNomina> getPersonalConceptoNominas() {
		return this.personalConceptoNominas;
	}

	public void setPersonalConceptoNominas(
			Set<PersonalConceptoNomina> personalConceptoNominas) {
		this.personalConceptoNominas = personalConceptoNominas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<DatoAcademicoPersonal> getDatoAcademicoPersonals() {
		return this.datoAcademicoPersonals;
	}

	public void setDatoAcademicoPersonals(
			Set<DatoAcademicoPersonal> datoAcademicoPersonals) {
		this.datoAcademicoPersonals = datoAcademicoPersonals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<AfeccionPersonal> getAfeccionPersonals() {
		return this.afeccionPersonals;
	}

	public void setAfeccionPersonals(Set<AfeccionPersonal> afeccionPersonals) {
		this.afeccionPersonals = afeccionPersonals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<PersonalActividad> getPersonalActividads() {
		return this.personalActividads;
	}

	public void setPersonalActividads(Set<PersonalActividad> personalActividads) {
		this.personalActividads = personalActividads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<PersonalCargo> getPersonalCargos() {
		return this.personalCargos;
	}

	public void setPersonalCargos(Set<PersonalCargo> personalCargos) {
		this.personalCargos = personalCargos;
	}

}
