package modelo;

// Generated 30-dic-2011 0:38:42 by Hibernate Tools 3.4.0.CR1

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
 * PersonalForaneo generated by hbm2java
 */
@Entity
@Table(name = "personal_foraneo", schema = "public")
public class PersonalForaneo implements java.io.Serializable {

	private int codigoPersonalForaneo;
	private DatoBasico datoBasico;
	private String nombre;
	private Set<PersonalForaneoJuego> personalForaneoJuegos = new HashSet<PersonalForaneoJuego>(
			0);

	public PersonalForaneo() {
	}

	public PersonalForaneo(int codigoPersonalForaneo, DatoBasico datoBasico,
			String nombre) {
		this.codigoPersonalForaneo = codigoPersonalForaneo;
		this.datoBasico = datoBasico;
		this.nombre = nombre;
	}

	public PersonalForaneo(int codigoPersonalForaneo, DatoBasico datoBasico,
			String nombre, Set<PersonalForaneoJuego> personalForaneoJuegos) {
		this.codigoPersonalForaneo = codigoPersonalForaneo;
		this.datoBasico = datoBasico;
		this.nombre = nombre;
		this.personalForaneoJuegos = personalForaneoJuegos;
	}

	@Id
	@Column(name = "codigo_personal_foraneo", unique = true, nullable = false)
	public int getCodigoPersonalForaneo() {
		return this.codigoPersonalForaneo;
	}

	public void setCodigoPersonalForaneo(int codigoPersonalForaneo) {
		this.codigoPersonalForaneo = codigoPersonalForaneo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_personal_juego", nullable = false)
	public DatoBasico getDatoBasico() {
		return this.datoBasico;
	}

	public void setDatoBasico(DatoBasico datoBasico) {
		this.datoBasico = datoBasico;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personalForaneo")
	public Set<PersonalForaneoJuego> getPersonalForaneoJuegos() {
		return this.personalForaneoJuegos;
	}

	public void setPersonalForaneoJuegos(
			Set<PersonalForaneoJuego> personalForaneoJuegos) {
		this.personalForaneoJuegos = personalForaneoJuegos;
	}

}
