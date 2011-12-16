package modelo;

// Generated 16-dic-2011 17:19:16 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * MotivoSancion generated by hbm2java
 */
@Entity
@Table(name = "motivo_sancion")
public class MotivoSancion implements java.io.Serializable {

	private String codigoMotivo;
	private DatoBasico datoBasico;
	private char estatus;

	public MotivoSancion() {
	}

	public MotivoSancion(DatoBasico datoBasico, char estatus) {
		this.datoBasico = datoBasico;
		this.estatus = estatus;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "datoBasico"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "codigo_motivo", unique = true, nullable = false)
	public String getCodigoMotivo() {
		return this.codigoMotivo;
	}

	public void setCodigoMotivo(String codigoMotivo) {
		this.codigoMotivo = codigoMotivo;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
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
