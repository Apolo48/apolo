package modelo;

// Generated 13-dic-2011 23:21:03 by Hibernate Tools 3.4.0.CR1

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
 * Divisa generated by hbm2java
 */
@Entity
@Table(name = "divisa")
public class Divisa implements java.io.Serializable {

	private String codigoDivisa;
	private Parroquia parroquia;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private String personaContacto;
	private byte[] logo;
	private Set<Equipo> equipos = new HashSet<Equipo>(0);

	public Divisa() {
	}

	public Divisa(String codigoDivisa, Parroquia parroquia, String nombre,
			String direccion, String telefono, String correoElectronico,
			String personaContacto) {
		this.codigoDivisa = codigoDivisa;
		this.parroquia = parroquia;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.personaContacto = personaContacto;
	}

	public Divisa(String codigoDivisa, Parroquia parroquia, String nombre,
			String direccion, String telefono, String correoElectronico,
			String personaContacto, byte[] logo, Set<Equipo> equipos) {
		this.codigoDivisa = codigoDivisa;
		this.parroquia = parroquia;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.personaContacto = personaContacto;
		this.logo = logo;
		this.equipos = equipos;
	}

	@Id
	@Column(name = "codigo_divisa", unique = true, nullable = false)
	public String getCodigoDivisa() {
		return this.codigoDivisa;
	}

	public void setCodigoDivisa(String codigoDivisa) {
		this.codigoDivisa = codigoDivisa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_parroquia", nullable = false)
	public Parroquia getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "direccion", nullable = false)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "telefono", nullable = false)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "correo_electronico", nullable = false)
	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Column(name = "persona_contacto", nullable = false)
	public String getPersonaContacto() {
		return this.personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	@Column(name = "logo")
	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "divisa")
	public Set<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

}
