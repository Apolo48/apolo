package modelo;

// Generated 05-dic-2011 22:14:58 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoInstalacion generated by hbm2java
 */
@Entity
@Table(name = "tipo_instalacion")
public class TipoInstalacion implements java.io.Serializable {

	private String codigoTipoInstalacion;
	private String descripcion;
	private String estatus;
	private Set<Instalacion> instalacions = new HashSet<Instalacion>(0);

	public TipoInstalacion() {
	}

	public TipoInstalacion(String codigoTipoInstalacion, String descripcion,
			String estatus) {
		this.codigoTipoInstalacion = codigoTipoInstalacion;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	public TipoInstalacion(String codigoTipoInstalacion, String descripcion,
			String estatus, Set<Instalacion> instalacions) {
		this.codigoTipoInstalacion = codigoTipoInstalacion;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.instalacions = instalacions;
	}

	@Id
	@Column(name = "codigo_tipo_instalacion", unique = true, nullable = false)
	public String getCodigoTipoInstalacion() {
		return this.codigoTipoInstalacion;
	}

	public void setCodigoTipoInstalacion(String codigoTipoInstalacion) {
		this.codigoTipoInstalacion = codigoTipoInstalacion;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estatus", nullable = false)
	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoInstalacion")
	public Set<Instalacion> getInstalacions() {
		return this.instalacions;
	}

	public void setInstalacions(Set<Instalacion> instalacions) {
		this.instalacions = instalacions;
	}

}
