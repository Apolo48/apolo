package controlador.jugador.bean;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.zkoss.image.AImage;

public class Anuario {
	private String nombreJugador;
	private String apellidoJugador;
	private Image fotoJugador;
		
	public String getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public String getApellidoJugador() {
		return apellidoJugador;
	}
	public void setApellidoJugador(String apellidoJugador) {
		this.apellidoJugador = apellidoJugador;
	}
	public Image getFotoJugador() {
		return fotoJugador;
	}
	public void setFotoJugador(Image fotoJugador) {
		this.fotoJugador = fotoJugador;
	}
	
	
}
