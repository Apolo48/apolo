package modelo;

// Generated 22-dic-2011 17:58:31 by Hibernate Tools 3.4.0.CR1

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
 * DatoAcademicoPersonal generated by hbm2java
 */
@Entity
@Table(name = "dato_academico_personal", schema = "public")
public class DatoAcademicoPersonal implements java.io.Serializable {

	private int codigoDatoAcademico;
	private Personal personal;
	private String titulo;
	private String instituto;
	private Date fechaEgreso;
	private char estatus;

	public DatoAcademicoPersonal() {
	}

	public DatoAcademicoPersonal(int codigoDatoAcademico, Personal personal,
			String titulo, String instituto, Date fechaEgreso, char estatus) {
		this.codigoDatoAcademico = codigoDatoAcademico;
		this.personal = personal;
		this.titulo = titulo;
		this.instituto = instituto;
		this.fechaEgreso = fechaEgreso;
		this.estatus = estatus;
	}

	@Id
	@Column(name = "codigo_dato_academico", unique = true, nullable = false)
	public int getCodigoDatoAcademico() {
		return this.codigoDatoAcademico;
	}

	public void setCodigoDatoAcademico(int codigoDatoAcademico) {
		this.codigoDatoAcademico = codigoDatoAcademico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_rif", nullable = false)
	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	@Column(name = "titulo", nullable = false)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "instituto", nullable = false)
	public String getInstituto() {
		return this.instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_egreso", nullable = false, length = 13)
	public Date getFechaEgreso() {
		return this.fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
