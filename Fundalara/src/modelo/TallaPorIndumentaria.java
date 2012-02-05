package modelo;

// Generated 04-feb-2012 16:31:02 by Hibernate Tools 3.4.0.CR1

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
 * TallaPorIndumentaria generated by hbm2java
 */
@Entity
@Table(name = "talla_por_indumentaria", schema = "public")
public class TallaPorIndumentaria implements java.io.Serializable {

	private int codigoTallaIndumentaria;
	private DatoBasico datoBasicoByCodigoTalla;
	private DatoBasico datoBasicoByCodigoTipoUniforme;
	private float precio;
	private char estatus;
	private Set<DocumentoIndumentaria> documentoIndumentarias = new HashSet<DocumentoIndumentaria>(
			0);
	private Set<JugadorPlan> jugadorPlans = new HashSet<JugadorPlan>(0);
	private Set<TallaPorJugador> tallaPorJugadors = new HashSet<TallaPorJugador>(
			0);

	public TallaPorIndumentaria() {
	}

	public TallaPorIndumentaria(int codigoTallaIndumentaria,
			DatoBasico datoBasicoByCodigoTalla,
			DatoBasico datoBasicoByCodigoTipoUniforme, float precio,
			char estatus) {
		this.codigoTallaIndumentaria = codigoTallaIndumentaria;
		this.datoBasicoByCodigoTalla = datoBasicoByCodigoTalla;
		this.datoBasicoByCodigoTipoUniforme = datoBasicoByCodigoTipoUniforme;
		this.precio = precio;
		this.estatus = estatus;
	}

	public TallaPorIndumentaria(int codigoTallaIndumentaria,
			DatoBasico datoBasicoByCodigoTalla,
			DatoBasico datoBasicoByCodigoTipoUniforme, float precio,
			char estatus, Set<DocumentoIndumentaria> documentoIndumentarias,
			Set<JugadorPlan> jugadorPlans, Set<TallaPorJugador> tallaPorJugadors) {
		this.codigoTallaIndumentaria = codigoTallaIndumentaria;
		this.datoBasicoByCodigoTalla = datoBasicoByCodigoTalla;
		this.datoBasicoByCodigoTipoUniforme = datoBasicoByCodigoTipoUniforme;
		this.precio = precio;
		this.estatus = estatus;
		this.documentoIndumentarias = documentoIndumentarias;
		this.jugadorPlans = jugadorPlans;
		this.tallaPorJugadors = tallaPorJugadors;
	}

	@Id
	@Column(name = "codigo_talla_indumentaria", unique = true, nullable = false)
	public int getCodigoTallaIndumentaria() {
		return this.codigoTallaIndumentaria;
	}

	public void setCodigoTallaIndumentaria(int codigoTallaIndumentaria) {
		this.codigoTallaIndumentaria = codigoTallaIndumentaria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_talla", nullable = false)
	public DatoBasico getDatoBasicoByCodigoTalla() {
		return this.datoBasicoByCodigoTalla;
	}

	public void setDatoBasicoByCodigoTalla(DatoBasico datoBasicoByCodigoTalla) {
		this.datoBasicoByCodigoTalla = datoBasicoByCodigoTalla;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_uniforme", nullable = false)
	public DatoBasico getDatoBasicoByCodigoTipoUniforme() {
		return this.datoBasicoByCodigoTipoUniforme;
	}

	public void setDatoBasicoByCodigoTipoUniforme(
			DatoBasico datoBasicoByCodigoTipoUniforme) {
		this.datoBasicoByCodigoTipoUniforme = datoBasicoByCodigoTipoUniforme;
	}

	@Column(name = "precio", nullable = false, precision = 8, scale = 8)
	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tallaPorIndumentaria")
	public Set<DocumentoIndumentaria> getDocumentoIndumentarias() {
		return this.documentoIndumentarias;
	}

	public void setDocumentoIndumentarias(
			Set<DocumentoIndumentaria> documentoIndumentarias) {
		this.documentoIndumentarias = documentoIndumentarias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tallaPorIndumentaria")
	public Set<JugadorPlan> getJugadorPlans() {
		return this.jugadorPlans;
	}

	public void setJugadorPlans(Set<JugadorPlan> jugadorPlans) {
		this.jugadorPlans = jugadorPlans;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tallaPorIndumentaria")
	public Set<TallaPorJugador> getTallaPorJugadors() {
		return this.tallaPorJugadors;
	}

	public void setTallaPorJugadors(Set<TallaPorJugador> tallaPorJugadors) {
		this.tallaPorJugadors = tallaPorJugadors;
	}

}
