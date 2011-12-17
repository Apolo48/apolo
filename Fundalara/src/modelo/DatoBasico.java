package modelo;

// Generated 17/12/2011 10:20:04 AM by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DatoBasico generated by hbm2java
 */
@Entity
@Table(name = "dato_basico")
public class DatoBasico implements java.io.Serializable {

	private String codigoDatoBasico;
	private TipoDato tipoDato;
	private DatoBasico datoBasico;
	private String nombre;
	private String descripcion;
	private char estatus;
	private Date fechaRegistro;
	private String responsable;
	private Date horaRegistro;
	private Set<DatoAcademico> datoAcademicosForCodigoCurso = new HashSet<DatoAcademico>(
			0);
	private Set<FamiliarJugador> familiarJugadors = new HashSet<FamiliarJugador>(
			0);
	private Set<DatoAcademico> datoAcademicosForCodigoAnnoEscolar = new HashSet<DatoAcademico>(
			0);
	private Set<DatoConducta> datoConductas = new HashSet<DatoConducta>(0);
	private Set<ComisionEquipo> comisionEquipos = new HashSet<ComisionEquipo>(0);
	private Set<TallaPorIndumentaria> tallaPorIndumentariasForCodigoIndumentaria = new HashSet<TallaPorIndumentaria>(
			0);
	private Set<DatoBasico> datoBasicos = new HashSet<DatoBasico>(0);
	private Set<Jugador> jugadors = new HashSet<Jugador>(0);
	private Set<TallaPorIndumentaria> tallaPorIndumentariasForCodigoTalla = new HashSet<TallaPorIndumentaria>(
			0);
	private Set<Equipo> equipos = new HashSet<Equipo>(0);
	private Set<Persona> personas = new HashSet<Persona>(0);
	private Set<Medico> medicos = new HashSet<Medico>(0);
	private Set<Competencia> competenciasForCodigoTipo = new HashSet<Competencia>(
			0);
	private Set<IngresoFormaPago> ingresoFormaPagosForCodigoBanco = new HashSet<IngresoFormaPago>(
			0);
	private Set<Estadio> estadios = new HashSet<Estadio>(0);
	private Set<Familiar> familiars = new HashSet<Familiar>(0);
	private Set<Competencia> competenciasForCodigoEstado = new HashSet<Competencia>(
			0);
	private Set<AfeccionJugador> afeccionJugadors = new HashSet<AfeccionJugador>(
			0);
	private Set<RecaudoPorProceso> recaudoPorProcesosForCodigoImportancia = new HashSet<RecaudoPorProceso>(
			0);
	private Set<RecaudoPorProceso> recaudoPorProcesosForCodigoProceso = new HashSet<RecaudoPorProceso>(
			0);
	private Set<RecaudoPorProceso> recaudoPorProcesosForCodigoDocumento = new HashSet<RecaudoPorProceso>(
			0);
	private Set<DatoSocial> datoSocials = new HashSet<DatoSocial>(0);
	private Set<Juego> juegos = new HashSet<Juego>(0);
	private Set<LogroPorJugador> logroPorJugadors = new HashSet<LogroPorJugador>(
			0);
	private MotivoSancion motivoSancion;
	private Set<Institucion> institucions = new HashSet<Institucion>(0);
	private IngresoFormaPago ingresoFormaPagoByCodigoDatoBasico;
	private Set<Ascenso> ascensos = new HashSet<Ascenso>(0);

	public DatoBasico() {
	}

	public DatoBasico(String codigoDatoBasico, TipoDato tipoDato,
			String nombre, String descripcion, char estatus,
			Date fechaRegistro, String responsable, Date horaRegistro) {
		this.codigoDatoBasico = codigoDatoBasico;
		this.tipoDato = tipoDato;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.responsable = responsable;
		this.horaRegistro = horaRegistro;
	}

	public DatoBasico(
			String codigoDatoBasico,
			TipoDato tipoDato,
			DatoBasico datoBasico,
			String nombre,
			String descripcion,
			char estatus,
			Date fechaRegistro,
			String responsable,
			Date horaRegistro,
			Set<DatoAcademico> datoAcademicosForCodigoCurso,
			Set<FamiliarJugador> familiarJugadors,
			Set<DatoAcademico> datoAcademicosForCodigoAnnoEscolar,
			Set<DatoConducta> datoConductas,
			Set<ComisionEquipo> comisionEquipos,
			Set<TallaPorIndumentaria> tallaPorIndumentariasForCodigoIndumentaria,
			Set<DatoBasico> datoBasicos, Set<Jugador> jugadors,
			Set<TallaPorIndumentaria> tallaPorIndumentariasForCodigoTalla,
			Set<Equipo> equipos, Set<Persona> personas, Set<Medico> medicos,
			Set<Competencia> competenciasForCodigoTipo,
			Set<IngresoFormaPago> ingresoFormaPagosForCodigoBanco,
			Set<Estadio> estadios, Set<Familiar> familiars,
			Set<Competencia> competenciasForCodigoEstado,
			Set<AfeccionJugador> afeccionJugadors,
			Set<RecaudoPorProceso> recaudoPorProcesosForCodigoImportancia,
			Set<RecaudoPorProceso> recaudoPorProcesosForCodigoProceso,
			Set<RecaudoPorProceso> recaudoPorProcesosForCodigoDocumento,
			Set<DatoSocial> datoSocials, Set<Juego> juegos,
			Set<LogroPorJugador> logroPorJugadors, MotivoSancion motivoSancion,
			Set<Institucion> institucions,
			IngresoFormaPago ingresoFormaPagoByCodigoDatoBasico,
			Set<Ascenso> ascensos) {
		this.codigoDatoBasico = codigoDatoBasico;
		this.tipoDato = tipoDato;
		this.datoBasico = datoBasico;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.responsable = responsable;
		this.horaRegistro = horaRegistro;
		this.datoAcademicosForCodigoCurso = datoAcademicosForCodigoCurso;
		this.familiarJugadors = familiarJugadors;
		this.datoAcademicosForCodigoAnnoEscolar = datoAcademicosForCodigoAnnoEscolar;
		this.datoConductas = datoConductas;
		this.comisionEquipos = comisionEquipos;
		this.tallaPorIndumentariasForCodigoIndumentaria = tallaPorIndumentariasForCodigoIndumentaria;
		this.datoBasicos = datoBasicos;
		this.jugadors = jugadors;
		this.tallaPorIndumentariasForCodigoTalla = tallaPorIndumentariasForCodigoTalla;
		this.equipos = equipos;
		this.personas = personas;
		this.medicos = medicos;
		this.competenciasForCodigoTipo = competenciasForCodigoTipo;
		this.ingresoFormaPagosForCodigoBanco = ingresoFormaPagosForCodigoBanco;
		this.estadios = estadios;
		this.familiars = familiars;
		this.competenciasForCodigoEstado = competenciasForCodigoEstado;
		this.afeccionJugadors = afeccionJugadors;
		this.recaudoPorProcesosForCodigoImportancia = recaudoPorProcesosForCodigoImportancia;
		this.recaudoPorProcesosForCodigoProceso = recaudoPorProcesosForCodigoProceso;
		this.recaudoPorProcesosForCodigoDocumento = recaudoPorProcesosForCodigoDocumento;
		this.datoSocials = datoSocials;
		this.juegos = juegos;
		this.logroPorJugadors = logroPorJugadors;
		this.motivoSancion = motivoSancion;
		this.institucions = institucions;
		this.ingresoFormaPagoByCodigoDatoBasico = ingresoFormaPagoByCodigoDatoBasico;
		this.ascensos = ascensos;
	}

	@Id
	@Column(name = "codigo_dato_basico", unique = true, nullable = false)
	public String getCodigoDatoBasico() {
		return this.codigoDatoBasico;
	}

	public void setCodigoDatoBasico(String codigoDatoBasico) {
		this.codigoDatoBasico = codigoDatoBasico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_dato", nullable = false)
	public TipoDato getTipoDato() {
		return this.tipoDato;
	}

	public void setTipoDato(TipoDato tipoDato) {
		this.tipoDato = tipoDato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_codigo_dato_basico")
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

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro", nullable = false, length = 13)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "responsable", nullable = false)
	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_registro", nullable = false, length = 15)
	public Date getHoraRegistro() {
		return this.horaRegistro;
	}

	public void setHoraRegistro(Date horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoCurso")
	public Set<DatoAcademico> getDatoAcademicosForCodigoCurso() {
		return this.datoAcademicosForCodigoCurso;
	}

	public void setDatoAcademicosForCodigoCurso(
			Set<DatoAcademico> datoAcademicosForCodigoCurso) {
		this.datoAcademicosForCodigoCurso = datoAcademicosForCodigoCurso;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<FamiliarJugador> getFamiliarJugadors() {
		return this.familiarJugadors;
	}

	public void setFamiliarJugadors(Set<FamiliarJugador> familiarJugadors) {
		this.familiarJugadors = familiarJugadors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoAnnoEscolar")
	public Set<DatoAcademico> getDatoAcademicosForCodigoAnnoEscolar() {
		return this.datoAcademicosForCodigoAnnoEscolar;
	}

	public void setDatoAcademicosForCodigoAnnoEscolar(
			Set<DatoAcademico> datoAcademicosForCodigoAnnoEscolar) {
		this.datoAcademicosForCodigoAnnoEscolar = datoAcademicosForCodigoAnnoEscolar;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<DatoConducta> getDatoConductas() {
		return this.datoConductas;
	}

	public void setDatoConductas(Set<DatoConducta> datoConductas) {
		this.datoConductas = datoConductas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<ComisionEquipo> getComisionEquipos() {
		return this.comisionEquipos;
	}

	public void setComisionEquipos(Set<ComisionEquipo> comisionEquipos) {
		this.comisionEquipos = comisionEquipos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoIndumentaria")
	public Set<TallaPorIndumentaria> getTallaPorIndumentariasForCodigoIndumentaria() {
		return this.tallaPorIndumentariasForCodigoIndumentaria;
	}

	public void setTallaPorIndumentariasForCodigoIndumentaria(
			Set<TallaPorIndumentaria> tallaPorIndumentariasForCodigoIndumentaria) {
		this.tallaPorIndumentariasForCodigoIndumentaria = tallaPorIndumentariasForCodigoIndumentaria;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<DatoBasico> getDatoBasicos() {
		return this.datoBasicos;
	}

	public void setDatoBasicos(Set<DatoBasico> datoBasicos) {
		this.datoBasicos = datoBasicos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(Set<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoTalla")
	public Set<TallaPorIndumentaria> getTallaPorIndumentariasForCodigoTalla() {
		return this.tallaPorIndumentariasForCodigoTalla;
	}

	public void setTallaPorIndumentariasForCodigoTalla(
			Set<TallaPorIndumentaria> tallaPorIndumentariasForCodigoTalla) {
		this.tallaPorIndumentariasForCodigoTalla = tallaPorIndumentariasForCodigoTalla;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<Medico> getMedicos() {
		return this.medicos;
	}

	public void setMedicos(Set<Medico> medicos) {
		this.medicos = medicos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoTipo")
	public Set<Competencia> getCompetenciasForCodigoTipo() {
		return this.competenciasForCodigoTipo;
	}

	public void setCompetenciasForCodigoTipo(
			Set<Competencia> competenciasForCodigoTipo) {
		this.competenciasForCodigoTipo = competenciasForCodigoTipo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoBanco")
	public Set<IngresoFormaPago> getIngresoFormaPagosForCodigoBanco() {
		return this.ingresoFormaPagosForCodigoBanco;
	}

	public void setIngresoFormaPagosForCodigoBanco(
			Set<IngresoFormaPago> ingresoFormaPagosForCodigoBanco) {
		this.ingresoFormaPagosForCodigoBanco = ingresoFormaPagosForCodigoBanco;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<Estadio> getEstadios() {
		return this.estadios;
	}

	public void setEstadios(Set<Estadio> estadios) {
		this.estadios = estadios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<Familiar> getFamiliars() {
		return this.familiars;
	}

	public void setFamiliars(Set<Familiar> familiars) {
		this.familiars = familiars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoEstado")
	public Set<Competencia> getCompetenciasForCodigoEstado() {
		return this.competenciasForCodigoEstado;
	}

	public void setCompetenciasForCodigoEstado(
			Set<Competencia> competenciasForCodigoEstado) {
		this.competenciasForCodigoEstado = competenciasForCodigoEstado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<AfeccionJugador> getAfeccionJugadors() {
		return this.afeccionJugadors;
	}

	public void setAfeccionJugadors(Set<AfeccionJugador> afeccionJugadors) {
		this.afeccionJugadors = afeccionJugadors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoImportancia")
	public Set<RecaudoPorProceso> getRecaudoPorProcesosForCodigoImportancia() {
		return this.recaudoPorProcesosForCodigoImportancia;
	}

	public void setRecaudoPorProcesosForCodigoImportancia(
			Set<RecaudoPorProceso> recaudoPorProcesosForCodigoImportancia) {
		this.recaudoPorProcesosForCodigoImportancia = recaudoPorProcesosForCodigoImportancia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoProceso")
	public Set<RecaudoPorProceso> getRecaudoPorProcesosForCodigoProceso() {
		return this.recaudoPorProcesosForCodigoProceso;
	}

	public void setRecaudoPorProcesosForCodigoProceso(
			Set<RecaudoPorProceso> recaudoPorProcesosForCodigoProceso) {
		this.recaudoPorProcesosForCodigoProceso = recaudoPorProcesosForCodigoProceso;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoDocumento")
	public Set<RecaudoPorProceso> getRecaudoPorProcesosForCodigoDocumento() {
		return this.recaudoPorProcesosForCodigoDocumento;
	}

	public void setRecaudoPorProcesosForCodigoDocumento(
			Set<RecaudoPorProceso> recaudoPorProcesosForCodigoDocumento) {
		this.recaudoPorProcesosForCodigoDocumento = recaudoPorProcesosForCodigoDocumento;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<DatoSocial> getDatoSocials() {
		return this.datoSocials;
	}

	public void setDatoSocials(Set<DatoSocial> datoSocials) {
		this.datoSocials = datoSocials;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<Juego> getJuegos() {
		return this.juegos;
	}

	public void setJuegos(Set<Juego> juegos) {
		this.juegos = juegos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<LogroPorJugador> getLogroPorJugadors() {
		return this.logroPorJugadors;
	}

	public void setLogroPorJugadors(Set<LogroPorJugador> logroPorJugadors) {
		this.logroPorJugadors = logroPorJugadors;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public MotivoSancion getMotivoSancion() {
		return this.motivoSancion;
	}

	public void setMotivoSancion(MotivoSancion motivoSancion) {
		this.motivoSancion = motivoSancion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<Institucion> getInstitucions() {
		return this.institucions;
	}

	public void setInstitucions(Set<Institucion> institucions) {
		this.institucions = institucions;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "datoBasicoByCodigoDatoBasico")
	public IngresoFormaPago getIngresoFormaPagoByCodigoDatoBasico() {
		return this.ingresoFormaPagoByCodigoDatoBasico;
	}

	public void setIngresoFormaPagoByCodigoDatoBasico(
			IngresoFormaPago ingresoFormaPagoByCodigoDatoBasico) {
		this.ingresoFormaPagoByCodigoDatoBasico = ingresoFormaPagoByCodigoDatoBasico;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datoBasico")
	public Set<Ascenso> getAscensos() {
		return this.ascensos;
	}

	public void setAscensos(Set<Ascenso> ascensos) {
		this.ascensos = ascensos;
	}

}
