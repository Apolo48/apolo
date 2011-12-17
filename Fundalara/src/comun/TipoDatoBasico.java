package comun;

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
