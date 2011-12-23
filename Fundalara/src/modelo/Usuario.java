package modelo;

// Generated 22-dic-2011 17:58:31 by Hibernate Tools 3.4.0.CR1

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
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {

	private String cedulaRif;
	private Personal personal;
	private String nick;
	private String password;
	private char estatus;
	private Set<AsistenciaPersonalEntrenamiento> asistenciaPersonalEntrenamientos = new HashSet<AsistenciaPersonalEntrenamiento>(
			0);
	private Set<ActividadPlanificada> actividadPlanificadas = new HashSet<ActividadPlanificada>(
			0);
	private Set<SeguridadFuncional> seguridadFuncionals = new HashSet<SeguridadFuncional>(
			0);
	private Set<DesempeoJugador> desempeoJugadors = new HashSet<DesempeoJugador>(
			0);

	public Usuario() {
	}

	public Usuario(Personal personal, String nick, String password, char estatus) {
		this.personal = personal;
		this.nick = nick;
		this.password = password;
		this.estatus = estatus;
	}

	public Usuario(
			Personal personal,
			String nick,
			String password,
			char estatus,
			Set<AsistenciaPersonalEntrenamiento> asistenciaPersonalEntrenamientos,
			Set<ActividadPlanificada> actividadPlanificadas,
			Set<SeguridadFuncional> seguridadFuncionals,
			Set<DesempeoJugador> desempeoJugadors) {
		this.personal = personal;
		this.nick = nick;
		this.password = password;
		this.estatus = estatus;
		this.asistenciaPersonalEntrenamientos = asistenciaPersonalEntrenamientos;
		this.actividadPlanificadas = actividadPlanificadas;
		this.seguridadFuncionals = seguridadFuncionals;
		this.desempeoJugadors = desempeoJugadors;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "personal"))
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
	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	@Column(name = "nick", nullable = false)
	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<AsistenciaPersonalEntrenamiento> getAsistenciaPersonalEntrenamientos() {
		return this.asistenciaPersonalEntrenamientos;
	}

	public void setAsistenciaPersonalEntrenamientos(
			Set<AsistenciaPersonalEntrenamiento> asistenciaPersonalEntrenamientos) {
		this.asistenciaPersonalEntrenamientos = asistenciaPersonalEntrenamientos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<ActividadPlanificada> getActividadPlanificadas() {
		return this.actividadPlanificadas;
	}

	public void setActividadPlanificadas(
			Set<ActividadPlanificada> actividadPlanificadas) {
		this.actividadPlanificadas = actividadPlanificadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<SeguridadFuncional> getSeguridadFuncionals() {
		return this.seguridadFuncionals;
	}

	public void setSeguridadFuncionals(
			Set<SeguridadFuncional> seguridadFuncionals) {
		this.seguridadFuncionals = seguridadFuncionals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<DesempeoJugador> getDesempeoJugadors() {
		return this.desempeoJugadors;
	}

	public void setDesempeoJugadors(Set<DesempeoJugador> desempeoJugadors) {
		this.desempeoJugadors = desempeoJugadors;
	}

}
