package modelo;

// Generated 13-dic-2011 23:21:03 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Benefactor generated by hbm2java
 */
@Entity
@Table(name = "benefactor")
public class Benefactor implements java.io.Serializable {

	private String rif;
	private Parroquia parroquia;
	private String codMunicipio;
	private String fax;
	private String direccion;
	private Date fechaIngreso;
	private String telefono1;
	private char estatus;
	private String correoElectronico;
	private String cuentaTwitter;
	private String nombre;

	public Benefactor() {
	}

	public Benefactor(String rif, Parroquia parroquia, String codMunicipio,
			String direccion, Date fechaIngreso, char estatus, String nombre) {
		this.rif = rif;
		this.parroquia = parroquia;
		this.codMunicipio = codMunicipio;
		this.direccion = direccion;
		this.fechaIngreso = fechaIngreso;
		this.estatus = estatus;
		this.nombre = nombre;
	}

	public Benefactor(String rif, Parroquia parroquia, String codMunicipio,
			String fax, String direccion, Date fechaIngreso, String telefono1,
			char estatus, String correoElectronico, String cuentaTwitter,
			String nombre) {
		this.rif = rif;
		this.parroquia = parroquia;
		this.codMunicipio = codMunicipio;
		this.fax = fax;
		this.direccion = direccion;
		this.fechaIngreso = fechaIngreso;
		this.telefono1 = telefono1;
		this.estatus = estatus;
		this.correoElectronico = correoElectronico;
		this.cuentaTwitter = cuentaTwitter;
		this.nombre = nombre;
	}

	@Id
	@Column(name = "rif", unique = true, nullable = false)
	public String getRif() {
		return this.rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_parroquia", nullable = false)
	public Parroquia getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	@Column(name = "cod_municipio", nullable = false)
	public String getCodMunicipio() {
		return this.codMunicipio;
	}

	public void setCodMunicipio(String codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	@Column(name = "fax")
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "direccion", nullable = false)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso", nullable = false, length = 13)
	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Column(name = "telefono1")
	public String getTelefono1() {
		return this.telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@Column(name = "correo_electronico")
	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Column(name = "cuenta_twitter")
	public String getCuentaTwitter() {
		return this.cuentaTwitter;
	}

	public void setCuentaTwitter(String cuentaTwitter) {
		this.cuentaTwitter = cuentaTwitter;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
