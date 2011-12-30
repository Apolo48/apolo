package modelo;

// Generated 30-dic-2011 0:38:42 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProveedorBanco generated by hbm2java
 */
@Entity
@Table(name = "proveedor_banco", schema = "public")
public class ProveedorBanco implements java.io.Serializable {

	private String codigoCuentaBanco;
	private PersonaJuridica personaJuridica;
	private DatoBasico datoBasico;
	private String titular;

	public ProveedorBanco() {
	}

	public ProveedorBanco(String codigoCuentaBanco,
			PersonaJuridica personaJuridica, DatoBasico datoBasico) {
		this.codigoCuentaBanco = codigoCuentaBanco;
		this.personaJuridica = personaJuridica;
		this.datoBasico = datoBasico;
	}

	public ProveedorBanco(String codigoCuentaBanco,
			PersonaJuridica personaJuridica, DatoBasico datoBasico,
			String titular) {
		this.codigoCuentaBanco = codigoCuentaBanco;
		this.personaJuridica = personaJuridica;
		this.datoBasico = datoBasico;
		this.titular = titular;
	}

	@Id
	@Column(name = "codigo_cuenta_banco", unique = true, nullable = false)
	public String getCodigoCuentaBanco() {
		return this.codigoCuentaBanco;
	}

	public void setCodigoCuentaBanco(String codigoCuentaBanco) {
		this.codigoCuentaBanco = codigoCuentaBanco;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_rif", nullable = false)
	public PersonaJuridica getPersonaJuridica() {
		return this.personaJuridica;
	}

	public void setPersonaJuridica(PersonaJuridica personaJuridica) {
		this.personaJuridica = personaJuridica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_banco", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "titular")
	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
