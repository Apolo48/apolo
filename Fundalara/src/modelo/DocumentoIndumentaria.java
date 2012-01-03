package modelo;

// Generated 02-ene-2012 20:17:38 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DocumentoIndumentaria generated by hbm2java
 */
@Entity
@Table(name = "documento_indumentaria", schema = "public")
public class DocumentoIndumentaria implements java.io.Serializable {

	private DocumentoIndumentariaId id;
	private TallaPorIndumentaria tallaPorIndumentaria;
	private DocumentoAcreedor documentoAcreedor;
	private double monto;
	private int cantidad;
	private char estatus;

	public DocumentoIndumentaria() {
	}

	public DocumentoIndumentaria(DocumentoIndumentariaId id,
			TallaPorIndumentaria tallaPorIndumentaria,
			DocumentoAcreedor documentoAcreedor, double monto, int cantidad,
			char estatus) {
		this.id = id;
		this.tallaPorIndumentaria = tallaPorIndumentaria;
		this.documentoAcreedor = documentoAcreedor;
		this.monto = monto;
		this.cantidad = cantidad;
		this.estatus = estatus;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoDocumentoAcreedor", column = @Column(name = "codigo_documento_acreedor", nullable = false)),
			@AttributeOverride(name = "codigoTallaIndumentaria", column = @Column(name = "codigo_talla_indumentaria", nullable = false)) })
	public DocumentoIndumentariaId getId() {
		return this.id;
	}

	public void setId(DocumentoIndumentariaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_talla_indumentaria", nullable = false, insertable = false, updatable = false)
	public TallaPorIndumentaria getTallaPorIndumentaria() {
		return this.tallaPorIndumentaria;
	}

	public void setTallaPorIndumentaria(
			TallaPorIndumentaria tallaPorIndumentaria) {
		this.tallaPorIndumentaria = tallaPorIndumentaria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_documento_acreedor", nullable = false, insertable = false, updatable = false)
	public DocumentoAcreedor getDocumentoAcreedor() {
		return this.documentoAcreedor;
	}

	public void setDocumentoAcreedor(DocumentoAcreedor documentoAcreedor) {
		this.documentoAcreedor = documentoAcreedor;
	}

	@Column(name = "monto", nullable = false, precision = 17, scale = 17)
	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
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

}
