package modelo;

// Generated 13-dic-2011 23:21:03 by Hibernate Tools 3.4.0.CR1

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
@Table(name = "recaudo_por_proceso")
public class RecaudoPorProceso implements java.io.Serializable {

	private String codigoRecaudoPorProceso;
	private Proceso proceso;
	private Importancia importancia;
	private Documento documento;
	private int cantidad;
	private char estatus;
	private Set<DocumentoEntregado> documentoEntregados = new HashSet<DocumentoEntregado>(
			0);

	public RecaudoPorProceso() {
	}

	public RecaudoPorProceso(String codigoRecaudoPorProceso, Proceso proceso,
			Importancia importancia, Documento documento, int cantidad,
			char estatus) {
		this.codigoRecaudoPorProceso = codigoRecaudoPorProceso;
		this.proceso = proceso;
		this.importancia = importancia;
		this.documento = documento;
		this.cantidad = cantidad;
		this.estatus = estatus;
	}

	public RecaudoPorProceso(String codigoRecaudoPorProceso, Proceso proceso,
			Importancia importancia, Documento documento, int cantidad,
			char estatus, Set<DocumentoEntregado> documentoEntregados) {
		this.codigoRecaudoPorProceso = codigoRecaudoPorProceso;
		this.proceso = proceso;
		this.importancia = importancia;
		this.documento = documento;
		this.cantidad = cantidad;
		this.estatus = estatus;
		this.documentoEntregados = documentoEntregados;
	}

	@Id
	@Column(name = "codigo_recaudo_por_proceso", unique = true, nullable = false)
	public String getCodigoRecaudoPorProceso() {
		return this.codigoRecaudoPorProceso;
	}

	public void setCodigoRecaudoPorProceso(String codigoRecaudoPorProceso) {
		this.codigoRecaudoPorProceso = codigoRecaudoPorProceso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_proceso", nullable = false)
	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_importancia", nullable = false)
	public Importancia getImportancia() {
		return this.importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_documento", nullable = false)
	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	@Column(name = "cantidad", nullable = false)
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
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