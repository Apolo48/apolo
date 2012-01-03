package modelo;

// Generated 02-ene-2012 20:17:38 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * PersonaJuridica generated by hbm2java
 */
@Entity
@Table(name = "persona_juridica", schema = "public")
public class PersonaJuridica implements java.io.Serializable {

	private String cedulaRif;
	private Persona persona;
	private String nit;
	private String fax;
	private String razonSocial;
	private Set<ProveedorBanco> proveedorBancos = new HashSet<ProveedorBanco>(0);

	public PersonaJuridica() {
	}

	public PersonaJuridica(Persona persona, String nit, String fax,
			String razonSocial) {
		this.persona = persona;
		this.nit = nit;
		this.fax = fax;
		this.razonSocial = razonSocial;
	}

	public PersonaJuridica(Persona persona, String nit, String fax,
			String razonSocial, Set<ProveedorBanco> proveedorBancos) {
		this.persona = persona;
		this.nit = nit;
		this.fax = fax;
		this.razonSocial = razonSocial;
		this.proveedorBancos = proveedorBancos;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "persona"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "cedula_rif", unique = true, nullable = false)
	public String getCedulaRif() {
		return this.cedulaRif;
	}

	public void setCedulaRif(String cedulaRif) {
		this.cedulaRif = cedulaRif;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Column(name = "nit", nullable = false)
	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	@Column(name = "fax", nullable = false)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "razon_social", nullable = false)
	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaJuridica")
	public Set<ProveedorBanco> getProveedorBancos() {
		return this.proveedorBancos;
	}

	public void setProveedorBancos(Set<ProveedorBanco> proveedorBancos) {
		this.proveedorBancos = proveedorBancos;
	}

}
