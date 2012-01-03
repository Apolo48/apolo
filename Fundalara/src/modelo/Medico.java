package modelo;

// Generated 02-ene-2012 20:17:38 by Hibernate Tools 3.4.0.CR1

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
 * Medico generated by hbm2java
 */
@Entity
@Table(name = "medico", schema = "public")
public class Medico implements java.io.Serializable {

	private String numeroColegio;
	private DatoBasico datoBasico;
	private String matricula;
	private String cedulaMedico;
	private String nombre;
	private String apellido;
	private String telefonoOficina;
	private String telefonoCelular;
	private Date fechaIngreso;
	private char estatus;
	private Set<DatoMedico> datoMedicos = new HashSet<DatoMedico>(0);

	public Medico() {
	}

	public Medico(String numeroColegio, String nombre, String apellido,
			Date fechaIngreso, char estatus) {
		this.numeroColegio = numeroColegio;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaIngreso = fechaIngreso;
		this.estatus = estatus;
	}

	public Medico(String numeroColegio, DatoBasico datoBasico,
			String matricula, String cedulaMedico, String nombre,
			String apellido, String telefonoOficina, String telefonoCelular,
			Date fechaIngreso, char estatus, Set<DatoMedico> datoMedicos) {
		this.numeroColegio = numeroColegio;
		this.datoBasico = datoBasico;
		this.matricula = matricula;
		this.cedulaMedico = cedulaMedico;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefonoOficina = telefonoOficina;
		this.telefonoCelular = telefonoCelular;
		this.fechaIngreso = fechaIngreso;
		this.estatus = estatus;
		this.datoMedicos = datoMedicos;
	}

	@Id
	@Column(name = "numero_colegio", unique = true, nullable = false)
	public String getNumeroColegio() {
		return this.numeroColegio;
	}

	public void setNumeroColegio(String numeroColegio) {
		this.numeroColegio = numeroColegio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_especialidad")
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "matricula")
	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Column(name = "cedula_medico")
	public String getCedulaMedico() {
		return this.cedulaMedico;
	}

	public void setCedulaMedico(String cedulaMedico) {
		this.cedulaMedico = cedulaMedico;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", nullable = false)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "telefono_oficina")
	public String getTelefonoOficina() {
		return this.telefonoOficina;
	}

	public void setTelefonoOficina(String telefonoOficina) {
		this.telefonoOficina = telefonoOficina;
	}

	@Column(name = "telefono_celular")
	public String getTelefonoCelular() {
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medico")
	public Set<DatoMedico> getDatoMedicos() {
		return this.datoMedicos;
	}

	public void setDatoMedicos(Set<DatoMedico> datoMedicos) {
		this.datoMedicos = datoMedicos;
	}

}
