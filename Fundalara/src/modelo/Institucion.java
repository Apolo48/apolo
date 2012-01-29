package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

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
 * Institucion generated by hbm2java
 */
@Entity
@Table(name = "institucion", schema = "public")
public class Institucion implements java.io.Serializable {

	private int codigoInstitucion;
	private DatoBasico datoBasicoByCodigoTipoInstitucion;
	private DatoBasico datoBasicoByCodigoParroquia;
	private String nombre;
	private String direccion;
	private char estatus;
	private Set<DatoAcademico> datoAcademicos = new HashSet<DatoAcademico>(0);
	private Set<DatoSocial> datoSocials = new HashSet<DatoSocial>(0);

	public Institucion() {
	}

	public Institucion(int codigoInstitucion,
			DatoBasico datoBasicoByCodigoTipoInstitucion, String nombre,
			char estatus) {
		this.codigoInstitucion = codigoInstitucion;
		this.datoBasicoByCodigoTipoInstitucion = datoBasicoByCodigoTipoInstitucion;
		this.nombre = nombre;
		this.estatus = estatus;
	}

	public Institucion(int codigoInstitucion,
			DatoBasico datoBasicoByCodigoTipoInstitucion,
			DatoBasico datoBasicoByCodigoParroquia, String nombre,
			String direccion, char estatus, Set<DatoAcademico> datoAcademicos,
			Set<DatoSocial> datoSocials) {
		this.codigoInstitucion = codigoInstitucion;
		this.datoBasicoByCodigoTipoInstitucion = datoBasicoByCodigoTipoInstitucion;
		this.datoBasicoByCodigoParroquia = datoBasicoByCodigoParroquia;
		this.nombre = nombre;
		this.direccion = direccion;
		this.estatus = estatus;
		this.datoAcademicos = datoAcademicos;
		this.datoSocials = datoSocials;
	}

	@Id
	@Column(name = "codigo_institucion", unique = true, nullable = false)
	public int getCodigoInstitucion() {
		return this.codigoInstitucion;
	}

	public void setCodigoInstitucion(int codigoInstitucion) {
		this.codigoInstitucion = codigoInstitucion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_institucion", nullable = false)
	public DatoBasico getDatoBasicoByCodigoTipoInstitucion() {
		return this.datoBasicoByCodigoTipoInstitucion;
	}

	public void setDatoBasicoByCodigoTipoInstitucion(
			DatoBasico datoBasicoByCodigoTipoInstitucion) {
		this.datoBasicoByCodigoTipoInstitucion = datoBasicoByCodigoTipoInstitucion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_parroquia")
	public DatoBasico getDatoBasicoByCodigoParroquia() {
		return this.datoBasicoByCodigoParroquia;
	}

	public void setDatoBasicoByCodigoParroquia(
			DatoBasico datoBasicoByCodigoParroquia) {
		this.datoBasicoByCodigoParroquia = datoBasicoByCodigoParroquia;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "direccion")
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institucion")
	public Set<DatoAcademico> getDatoAcademicos() {
		return this.datoAcademicos;
	}

	public void setDatoAcademicos(Set<DatoAcademico> datoAcademicos) {
		this.datoAcademicos = datoAcademicos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institucion")
	public Set<DatoSocial> getDatoSocials() {
		return this.datoSocials;
	}

	public void setDatoSocials(Set<DatoSocial> datoSocials) {
		this.datoSocials = datoSocials;
	}

}
