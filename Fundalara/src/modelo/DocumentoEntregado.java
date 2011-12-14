package modelo;

// Generated 13-dic-2011 21:15:29 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DocumentoEntregado generated by hbm2java
 */
@Entity
@Table(name = "documento_entregado")
public class DocumentoEntregado implements java.io.Serializable {

	private String codigoDocumentoEntregado;
	private RecaudoPorProceso recaudoPorProceso;
	private byte[] documento;
	private Date fecha;
	private int cantidad;
	private char estatus;
	private Set<DocumentoAcademico> documentoAcademicos = new HashSet<DocumentoAcademico>(
			0);
	private Set<DocumentoMedico> documentoMedicos = new HashSet<DocumentoMedico>(
			0);

	public DocumentoEntregado() {
	}

	public DocumentoEntregado(String codigoDocumentoEntregado,
			RecaudoPorProceso recaudoPorProceso, byte[] documento, Date fecha,
			int cantidad, char estatus) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
		this.recaudoPorProceso = recaudoPorProceso;
		this.documento = documento;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.estatus = estatus;
	}

	public DocumentoEntregado(String codigoDocumentoEntregado,
			RecaudoPorProceso recaudoPorProceso, byte[] documento, Date fecha,
			int cantidad, char estatus,
			Set<DocumentoAcademico> documentoAcademicos,
			Set<DocumentoMedico> documentoMedicos) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
		this.recaudoPorProceso = recaudoPorProceso;
		this.documento = documento;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.estatus = estatus;
		this.documentoAcademicos = documentoAcademicos;
		this.documentoMedicos = documentoMedicos;
	}

	@Id
	@Column(name = "codigo_documento_entregado", unique = true, nullable = false)
	public String getCodigoDocumentoEntregado() {
		return this.codigoDocumentoEntregado;
	}

	public void setCodigoDocumentoEntregado(String codigoDocumentoEntregado) {
		this.codigoDocumentoEntregado = codigoDocumentoEntregado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_recaudo_por_proceso", nullable = false)
	public RecaudoPorProceso getRecaudoPorProceso() {
		return this.recaudoPorProceso;
	}

	public void setRecaudoPorProceso(RecaudoPorProceso recaudoPorProceso) {
		this.recaudoPorProceso = recaudoPorProceso;
	}

	@Column(name = "documento", nullable = false)
	public byte[] getDocumento() {
		return this.documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 13)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documentoEntregado")
	public Set<DocumentoAcademico> getDocumentoAcademicos() {
		return this.documentoAcademicos;
	}

	public void setDocumentoAcademicos(
			Set<DocumentoAcademico> documentoAcademicos) {
		this.documentoAcademicos = documentoAcademicos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documentoEntregado")
	public Set<DocumentoMedico> getDocumentoMedicos() {
		return this.documentoMedicos;
	}

	public void setDocumentoMedicos(Set<DocumentoMedico> documentoMedicos) {
		this.documentoMedicos = documentoMedicos;
	}

}
