package comun;

/**
 * Enumerado para mantener los valores constantes de los diferentes tipos de datos básicos 
 * @author Robert A.
 * @author German L.
 * @version 0.1
 */
public enum TipoDatoBasico {
	PAIS("1"),
	ESTADO_VENEZUELA("2"), 
    MUNICIPIO("3"),
	PARROQUIA("4");

	private String codigo;

    private TipoDatoBasico(String codigo) {
       this.codigo = codigo;
    }

    public String getCodigo() {
		return codigo;
	}
}