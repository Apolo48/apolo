package controlador.jugador.bean;

import java.util.Date;

import modelo.DatoBasico;

public class Jugador {
	private String nacionalidad;
	private String cedula;
	private String secuencia;
	private Telefono telefonoHabitacion;
	private Telefono telefonoCelular;
	private int numero;
	private TipoSangre tipoSangre;
	private double peso;
	private double altura;
	private DatoBasico brazoLanzar;
	private DatoBasico posicionBateo;
	private DatoBasico tallaCalzado;
	private DatoBasico tallaPantalon;
	private DatoBasico tallaCamisa;
	private DatoBasico paisNac;
	private DatoBasico parroquiaNac;
	private DatoBasico parroquiaResi;
	private String correoElectronico;
	private String facebook;
	private String twitter;
	private String direccion;
	private Date fechaNacimiento;
	private char sexo;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private byte[] foto;
	
	public Jugador() {
		telefonoHabitacion = new Telefono();
		telefonoCelular = new Telefono();
		tipoSangre = new TipoSangre();
		brazoLanzar = new DatoBasico();
		posicionBateo = new DatoBasico();
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public Telefono getTelefonoHabitacion() {
		return telefonoHabitacion;
	}

	public void setTelefonoHabitacion(Telefono telefonoHabitacion) {
		this.telefonoHabitacion = telefonoHabitacion;
	}

	public Telefono getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(Telefono telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public TipoSangre getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(TipoSangre tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public DatoBasico getBrazoLanzar() {
		return brazoLanzar;
	}

	public void setBrazoLanzar(DatoBasico brazoLanzar) {
		this.brazoLanzar = brazoLanzar;
	}

	public DatoBasico getPosicionBateo() {
		return posicionBateo;
	}

	public void setPosicionBateo(DatoBasico posicionBateo) {
		this.posicionBateo = posicionBateo;
	}

	public DatoBasico getPaisNac() {
		return paisNac;
	}

	public void setPaisNac(DatoBasico paisNac) {
		this.paisNac = paisNac;
	}

	public DatoBasico getParroquiaNac() {
		return parroquiaNac;
	}

	public void setParroquiaNac(DatoBasico parroquiaNac) {
		this.parroquiaNac = parroquiaNac;
	}

	public DatoBasico getParroquiaResi() {
		return parroquiaResi;
	}

	public void setParroquiaResi(DatoBasico parroquiaResi) {
		this.parroquiaResi = parroquiaResi;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public DatoBasico getTallaCalzado() {
		return tallaCalzado;
	}

	public void setTallaCalzado(DatoBasico tallaCalzado) {
		this.tallaCalzado = tallaCalzado;
	}

	public DatoBasico getTallaPantalon() {
		return tallaPantalon;
	}

	public void setTallaPantalon(DatoBasico tallaPantalon) {
		this.tallaPantalon = tallaPantalon;
	}

	public DatoBasico getTallaCamisa() {
		return tallaCamisa;
	}

	public void setTallaCamisa(DatoBasico tallaCamisa) {
		this.tallaCamisa = tallaCamisa;
	}

	public String getCedulaCompleta() {
		return nacionalidad.toUpperCase() + "-" + cedula
				+ (secuencia == "" ? "" : "-" + secuencia);
	}

}
