package modelo;

// Generated 11-ene-2012 21:47:34 by Hibernate Tools 3.4.0.CR1

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
 * ConceptoNomina generated by hbm2java
 */
@Entity
@Table(name = "concepto_nomina", schema = "public")
public class ConceptoNomina implements java.io.Serializable {

	private int codigoConceptoNomina;
	private DatoBasico datoBasico;
	private Double valor;
	private boolean aplicableSueldo;
	private Date fechaCreacion;
	private char estatus;
	private String descripcion;
	private boolean fijo;
	private Set<PersonalConceptoNomina> personalConceptoNominas = new HashSet<PersonalConceptoNomina>(
			0);
	private Set<Movimiento> movimientos = new HashSet<Movimiento>(0);

	public ConceptoNomina() {
	}

	public ConceptoNomina(int codigoConceptoNomina, DatoBasico datoBasico,
			boolean aplicableSueldo, Date fechaCreacion, char estatus,
			String descripcion, boolean fijo) {
		this.codigoConceptoNomina = codigoConceptoNomina;
		this.datoBasico = datoBasico;
		this.aplicableSueldo = aplicableSueldo;
		this.fechaCreacion = fechaCreacion;
		this.estatus = estatus;
		this.descripcion = descripcion;
		this.fijo = fijo;
	}

	public ConceptoNomina(int codigoConceptoNomina, DatoBasico datoBasico,
			Double valor, boolean aplicableSueldo, Date fechaCreacion,
			char estatus, String descripcion, boolean fijo,
			Set<PersonalConceptoNomina> personalConceptoNominas,
			Set<Movimiento> movimientos) {
		this.codigoConceptoNomina = codigoConceptoNomina;
		this.datoBasico = datoBasico;
		this.valor = valor;
		this.aplicableSueldo = aplicableSueldo;
		this.fechaCreacion = fechaCreacion;
		this.estatus = estatus;
		this.descripcion = descripcion;
		this.fijo = fijo;
		this.personalConceptoNominas = personalConceptoNominas;
		this.movimientos = movimientos;
	}

	@Id
	@Column(name = "codigo_concepto_nomina", unique = true, nullable = false)
	public int getCodigoConceptoNomina() {
		return this.codigoConceptoNomina;
	}

	public void setCodigoConceptoNomina(int codigoConceptoNomina) {
		this.codigoConceptoNomina = codigoConceptoNomina;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_concepto", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "valor", precision = 17, scale = 17)
	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Column(name = "aplicable_sueldo", nullable = false)
	public boolean isAplicableSueldo() {
		return this.aplicableSueldo;
	}

	public void setAplicableSueldo(boolean aplicableSueldo) {
		this.aplicableSueldo = aplicableSueldo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion", nullable = false, length = 13)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "fijo", nullable = false)
	public boolean isFijo() {
		return this.fijo;
	}

	public void setFijo(boolean fijo) {
		this.fijo = fijo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conceptoNomina")
	public Set<PersonalConceptoNomina> getPersonalConceptoNominas() {
		return this.personalConceptoNominas;
	}

	public void setPersonalConceptoNominas(
			Set<PersonalConceptoNomina> personalConceptoNominas) {
		this.personalConceptoNominas = personalConceptoNominas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conceptoNomina")
	public Set<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

}
