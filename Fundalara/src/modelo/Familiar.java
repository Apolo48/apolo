package modelo;

// Generated 16-dic-2011 17:19:16 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Familiar generated by hbm2java
 */
@Entity
@Table(name = "familiar")
public class Familiar implements java.io.Serializable {

	private String cedulaRif;
	private DatoBasico datoBasico;
	private Persona persona;
	private Set<FamiliarJugador> familiarJugadors = new HashSet<FamiliarJugador>(
			0);

	public Familiar() {
	}

	public Familiar(DatoBasico datoBasico, Persona persona) {
		this.datoBasico = datoBasico;
		this.persona = persona;
	}

	public Familiar(DatoBasico datoBasico, Persona persona,
			Set<FamiliarJugador> familiarJugadors) {
		this.datoBasico = datoBasico;
		this.persona = persona;
		this.familiarJugadors = familiarJugadors;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_profesion", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jugador")
	public Set<FamiliarJugador> getFamiliarJugadors() {
		return this.familiarJugadors;
	}

	public void setFamiliarJugadors(Set<FamiliarJugador> familiarJugadors) {
		this.familiarJugadors = familiarJugadors;
	}

}
