package comun;

/**
 * Enumerado para mantener los valores constantes de los diferentes tipos de datos b�sicos 
 * @author Robert A.
 * @author German L.
 * @version 0.1
 */
public enum TipoDatoBasico {
	PAIS("1"),
	ESTADO_VENEZUELA("2"), 
    MUNICIPIO("3"),
	PARROQUIA("4"),
	TIPO_AFECCION("9"),
	AFECCION("10"),
	CURSO("11"),
	ANNO_ESCOLAR("12"),
	ACTIVIDAD_SOCIAL("13"),
	INSCRIPCION("24"),
	RECAUDOS_ACADEMICOS("26"),
	RECAUDOS_PERSONALES("27"),
	RECAUDOS_MEDICOS("28"),
	INSTITUCION("29");

	private String codigo;

    private TipoDatoBasico(String codigo) {
       this.codigo = codigo;
    }

    public String getCodigo() {
		return codigo;
	}
}