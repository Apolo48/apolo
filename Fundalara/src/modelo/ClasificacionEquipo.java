package modelo;

// Generated 05-dic-2011 18:58:46 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ClasificacionEquipo generated by hbm2java
 */
@Entity
@Table(name = "clasificacion_equipo")
public class ClasificacionEquipo implements java.io.Serializable {

	private String codigoClasificacion;
	private String nombre;
	private String descripcion;
	private char estatus;
	private Set<Equipo> equipos = new HashSet<Equipo>(0);

	public ClasificacionEquipo() {
	}

	public ClasificacionEquipo(String codigoClasificacion, String nombre,
			String descripcion, char estatus) {
		this.codigoClasificacion = codigoClasificacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public ClasificacionEquipo(String codigoClasificacion, String nombre,
			String descripcion, char estatus, Set<Equipo> equipos) {
		this.codigoClasificacion = codigoClasificacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.equipos = equipos;
	}

	@Id
	@Column(name = "codigo_clasificacion", unique = true, nullable = false)
	public String getCodigoClasificacion() {
		return this.codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clasificacionEquipo")
	public Set<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

}