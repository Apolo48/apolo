package modelo;

// Generated 13-dic-2011 21:15:29 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoActividadSocial generated by hbm2java
 */
@Entity
@Table(name = "tipo_actividad_social")
public class TipoActividadSocial implements java.io.Serializable {

	private String codigoActividadSocial;
	private String nombre;
	private char estatus;
	private Set<DatoSocial> datoSocials = new HashSet<DatoSocial>(0);

	public TipoActividadSocial() {
	}

	public TipoActividadSocial(String codigoActividadSocial, String nombre,
			char estatus) {
		this.codigoActividadSocial = codigoActividadSocial;
		this.nombre = nombre;
		this.estatus = estatus;
	}

	public TipoActividadSocial(String codigoActividadSocial, String nombre,
			char estatus, Set<DatoSocial> datoSocials) {
		this.codigoActividadSocial = codigoActividadSocial;
		this.nombre = nombre;
		this.estatus = estatus;
		this.datoSocials = datoSocials;
	}

	@Id
	@Column(name = "codigo_actividad_social", unique = true, nullable = false)
	public String getCodigoActividadSocial() {
		return this.codigoActividadSocial;
	}

	public void setCodigoActividadSocial(String codigoActividadSocial) {
		this.codigoActividadSocial = codigoActividadSocial;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoActividadSocial")
	public Set<DatoSocial> getDatoSocials() {
		return this.datoSocials;
	}

	public void setDatoSocials(Set<DatoSocial> datoSocials) {
		this.datoSocials = datoSocials;
	}

}
