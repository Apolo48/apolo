package modelo;

// Generated 05-dic-2011 23:09:14 by Hibernate Tools 3.4.0.CR1

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
 * Familiar generated by hbm2java
 */
@Entity
@Table(name = "familiar")
public class Familiar implements java.io.Serializable {

	private String cedulaFamiliar;
	private Profesion profesion;
	private Parroquia parroquia;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String direccionHabitacion;
	private String email;
	private String twitter;
	private String telefonoHabitacion;
	private String telefonoCelular;
	private byte[] foto;
	private Date fechaIngreso;
	private char estatus;
	private Set<FamiliarJugador> familiarJugadors = new HashSet<FamiliarJugador>(
			0);

	public Familiar() {
	}

	public Familiar(String cedulaFamiliar, Profesion profesion,
			Parroquia parroquia, String primerNombre, String primerApellido,
			String direccionHabitacion, byte[] foto, Date fechaIngreso,
			char estatus) {
		this.cedulaFamiliar = cedulaFamiliar;
		this.profesion = profesion;
		this.parroquia = parroquia;
		this.primerNombre = primerNombre;
		this.primerApellido = primerApellido;
		this.direccionHabitacion = direccionHabitacion;
		this.foto = foto;
		this.fechaIngreso = fechaIngreso;
		this.estatus = estatus;
	}

	public Familiar(String cedulaFamiliar, Profesion profesion,
			Parroquia parroquia, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido,
			String direccionHabitacion, String email, String twitter,
			String telefonoHabitacion, String telefonoCelular, byte[] foto,
			Date fechaIngreso, char estatus,
			Set<FamiliarJugador> familiarJugadors) {
		this.cedulaFamiliar = cedulaFamiliar;
		this.profesion = profesion;
		this.parroquia = parroquia;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.direccionHabitacion = direccionHabitacion;
		this.email = email;
		this.twitter = twitter;
		this.telefonoHabitacion = telefonoHabitacion;
		this.telefonoCelular = telefonoCelular;
		this.foto = foto;
		this.fechaIngreso = fechaIngreso;
		this.estatus = estatus;
		this.familiarJugadors = familiarJugadors;
	}

	@Id
	@Column(name = "cedula_familiar", unique = true, nullable = false)
	public String getCedulaFamiliar() {
		return this.cedulaFamiliar;
	}

	public void setCedulaFamiliar(String cedulaFamiliar) {
		this.cedulaFamiliar = cedulaFamiliar;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_profesion", nullable = false)
	public Profesion getProfesion() {
		return this.profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_parroquia", nullable = false)
	public Parroquia getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	@Column(name = "primer_nombre", nullable = false)
	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	@Column(name = "segundo_nombre")
	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	@Column(name = "primer_apellido", nullable = false)
	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	@Column(name = "segundo_apellido")
	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	@Column(name = "direccion_habitacion", nullable = false)
	public String getDireccionHabitacion() {
		return this.direccionHabitacion;
	}

	public void setDireccionHabitacion(String direccionHabitacion) {
		this.direccionHabitacion = direccionHabitacion;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "twitter")
	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Column(name = "telefono_habitacion")
	public String getTelefonoHabitacion() {
		return this.telefonoHabitacion;
	}

	public void setTelefonoHabitacion(String telefonoHabitacion) {
		this.telefonoHabitacion = telefonoHabitacion;
	}

	@Column(name = "telefono_celular")
	public String getTelefonoCelular() {
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	@Column(name = "foto", nullable = false)
	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso", nullable = false, length = 13)
	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familiar")
	public Set<FamiliarJugador> getFamiliarJugadors() {
		return this.familiarJugadors;
	}

	public void setFamiliarJugadors(Set<FamiliarJugador> familiarJugadors) {
		this.familiarJugadors = familiarJugadors;
	}

}
