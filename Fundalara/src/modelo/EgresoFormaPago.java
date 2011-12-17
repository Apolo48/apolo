package modelo;

// Generated 17-dic-2011 16:31:20 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * EgresoFormaPago generated by hbm2java
 */
@Entity
@Table(name = "egreso_forma_pago")
public class EgresoFormaPago implements java.io.Serializable {

	private String numeroDocumento;
	private Egreso egreso;
	private DatoBasico datoBasicoByCodigoBanco;
	private DatoBasico datoBasicoByCodigoTarjeta;
	private double monto;
	private char estatus;
	private String numeroDocuemntoPago;

	public EgresoFormaPago() {
	}

	public EgresoFormaPago(Egreso egreso, DatoBasico datoBasicoByCodigoBanco,
			DatoBasico datoBasicoByCodigoTarjeta, double monto, char estatus) {
		this.egreso = egreso;
		this.datoBasicoByCodigoBanco = datoBasicoByCodigoBanco;
		this.datoBasicoByCodigoTarjeta = datoBasicoByCodigoTarjeta;
		this.monto = monto;
		this.estatus = estatus;
	}

	public EgresoFormaPago(Egreso egreso, DatoBasico datoBasicoByCodigoBanco,
			DatoBasico datoBasicoByCodigoTarjeta, double monto, char estatus,
			String numeroDocuemntoPago) {
		this.egreso = egreso;
		this.datoBasicoByCodigoBanco = datoBasicoByCodigoBanco;
		this.datoBasicoByCodigoTarjeta = datoBasicoByCodigoTarjeta;
		this.monto = monto;
		this.estatus = estatus;
		this.numeroDocuemntoPago = numeroDocuemntoPago;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "egreso"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "numero_documento", unique = true, nullable = false)
	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Egreso getEgreso() {
		return this.egreso;
	}

	public void setEgreso(Egreso egreso) {
		this.egreso = egreso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_banco", nullable = false)
	public DatoBasico getDatoBasicoByCodigoBanco() {
		return this.datoBasicoByCodigoBanco;
	}

	public void setDatoBasicoByCodigoBanco(DatoBasico datoBasicoByCodigoBanco) {
		this.datoBasicoByCodigoBanco = datoBasicoByCodigoBanco;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tarjeta", nullable = false)
	public DatoBasico getDatoBasicoByCodigoTarjeta() {
		return this.datoBasicoByCodigoTarjeta;
	}

	public void setDatoBasicoByCodigoTarjeta(
			DatoBasico datoBasicoByCodigoTarjeta) {
		this.datoBasicoByCodigoTarjeta = datoBasicoByCodigoTarjeta;
	}

	@Column(name = "monto", nullable = false, precision = 17, scale = 17)
	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Column(name = "estatus", nullable = false, length = 1)
	public char getEstatus() {
		return this.estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	@Column(name = "numero_docuemnto_pago")
	public String getNumeroDocuemntoPago() {
		return this.numeroDocuemntoPago;
	}

	public void setNumeroDocuemntoPago(String numeroDocuemntoPago) {
		this.numeroDocuemntoPago = numeroDocuemntoPago;
	}

}
