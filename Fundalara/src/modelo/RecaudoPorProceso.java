package modelo;

// Generated 13/02/2012 02:19:00 PM by Hibernate Tools 3.4.0.CR1

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
 * RecaudoPorProceso generated by hbm2java
 */
@Entity
@Table(name = "recaudo_por_proceso", schema = "public")
public class RecaudoPorProceso implements java.io.Serializable {

	private int codigoRecaudoPorProceso;
	private DatoBasico datoBasicoByCodigoDocumento;
	private DatoBasico datoBasicoByCodigoImportancia;
	private DatoBasico datoBasicoByCodigoProceso;
	private Integer cantidad;
	private char estatus;
	private Set<DocumentoEntregado> documentoEntregados = new HashSet<DocumentoEntregado>(
			0);

	public RecaudoPorProceso() {
	}

	public RecaudoPorProceso(int codigoRecaudoPorProceso,
			DatoBasico datoBasicoByCodigoDocumento,
			DatoBasico datoBasicoByCodigoImportancia,
			DatoBasico datoBasicoByCodigoProceso, char estatus) {
		this.codigoRecaudoPorProceso = codigoRecaudoPorProceso;
		this.datoBasicoByCodigoDocumento = datoBasicoByCodigoDocumento;
		this.datoBasicoByCodigoImportancia = datoBasicoByCodigoImportancia;
		this.datoBasicoByCodigoProceso = datoBasicoByCodigoProceso;
		this.estatus = estatus;
	}

	public RecaudoPorProceso(int codigoRecaudoPorProceso,
			DatoBasico datoBasicoByCodigoDocumento,
			DatoBasico datoBasicoByCodigoImportancia,
			DatoBasico datoBasicoByCodigoProceso, Integer cantidad,
			char estatus, Set<DocumentoEntregado> documentoEntregados) {
		this.codigoRecaudoPorProceso = codigoRecaudoPorProceso;
		this.datoBasicoByCodigoDocumento = datoBasicoByCodigoDocumento;
		this.datoBasicoByCodigoImportancia = datoBasicoByCodigoImportancia;
		this.datoBasicoByCodigoProceso = datoBasicoByCodigoProceso;
		this.cantidad = cantidad;
		this.estatus = estatus;
		this.documentoEntregados = documentoEntregados;
	}

	@Id
	@Column(name = "codigo_recaudo_por_proceso", unique = true, nullable = false)
	public int getCodigoRecaudoPorProceso() {
		return this.codigoRecaudoPorProceso;
	}

	public void setCodigoRecaudoPorProceso(int codigoRecaudoPorProceso) {
		this.codigoRecaudoPorProceso = codigoRecaudoPorProceso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_documento", nullable = false)
	public DatoBasico getDatoBasicoByCodigoDocumento() {
		return this.datoBasicoByCodigoDocumento;
	}

	public void setDatoBasicoByCodigoDocumento(
			DatoBasico datoBasicoByCodigoDocumento) {
		this.datoBasicoByCodigoDocumento = datoBasicoByCodigoDocumento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_importancia", nullable = false)
	public DatoBasico getDatoBasicoByCodigoImportancia() {
		return this.datoBasicoByCodigoImportancia;
	}

	public void setDatoBasicoByCodigoImportancia(
			DatoBasico datoBasicoByCodigoImportancia) {
		this.datoBasicoByCodigoImportancia = datoBasicoByCodigoImportancia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_proceso", nullable = false)
	public DatoBasico getDatoBasicoByCodigoProceso() {
		return this.datoBasicoByCodigoProceso;
	}

	public void setDatoBasicoByCodigoProceso(
			DatoBasico datoBasicoByCodigoProceso) {
		this.datoBasicoByCodigoProceso = datoBasicoByCodigoProceso;
	}

	@Column(name = "cantidad")
	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "recaudoPorProceso")
	public Set<DocumentoEntregado> getDocumentoEntregados() {
		return this.documentoEntregados;
	}

	public void setDocumentoEntregados(
			Set<DocumentoEntregado> documentoEntregados) {
		this.documentoEntregados = documentoEntregados;
	}

}
