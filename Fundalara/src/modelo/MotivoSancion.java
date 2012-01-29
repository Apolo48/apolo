package modelo;

// Generated 28-ene-2012 22:13:44 by Hibernate Tools 3.4.0.CR1

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
 * MotivoSancion generated by hbm2java
 */
@Entity
@Table(name = "motivo_sancion", schema = "public")
public class MotivoSancion implements java.io.Serializable {

	private MotivoSancionId id;
	private DatoConducta datoConducta;
	private DatoBasico datoBasico;
	private char estatus;

	public MotivoSancion() {
	}

	public MotivoSancion(MotivoSancionId id, DatoConducta datoConducta,
			DatoBasico datoBasico, char estatus) {
		this.id = id;
		this.datoConducta = datoConducta;
		this.datoBasico = datoBasico;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoMotivo", column = @Column(name = "codigo_motivo", nullable = false)),
			@AttributeOverride(name = "codigoDatoConducta", column = @Column(name = "codigo_dato_conducta", nullable = false)) })
	public MotivoSancionId getId() {
		return this.id;
	}

	public void setId(MotivoSancionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_dato_conducta", nullable = false, insertable = false, updatable = false)
	public DatoConducta getDatoConducta() {
		return this.datoConducta;
	}

	public void setDatoConducta(DatoConducta datoConducta) {
		this.datoConducta = datoConducta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_motivo", nullable = false, insertable = false, updatable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

}
