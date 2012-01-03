package modelo;

// Generated 02-ene-2012 20:17:38 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AfeccionPersonal generated by hbm2java
 */
@Entity
@Table(name = "afeccion_personal", schema = "public")
public class AfeccionPersonal implements java.io.Serializable {

	private AfeccionPersonalId id;
	private DatoBasico datoBasico;
	private Personal personal;
	private char estatus;

	public AfeccionPersonal() {
	}

	public AfeccionPersonal(AfeccionPersonalId id, DatoBasico datoBasico,
			Personal personal, char estatus) {
		this.id = id;
		this.datoBasico = datoBasico;
		this.personal = personal;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cedulaRif", column = @Column(name = "cedula_rif", nullable = false)),
			@AttributeOverride(name = "codigoTipoAfeccion", column = @Column(name = "codigo_tipo_afeccion", nullable = false)) })
	public AfeccionPersonalId getId() {
		return this.id;
	}

	public void setId(AfeccionPersonalId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_afeccion", nullable = false, insertable = false, updatable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_rif", nullable = false, insertable = false, updatable = false)
	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
