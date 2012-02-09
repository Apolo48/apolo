package dao.general;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import comun.TipoDatoBasico;

import modelo.DatoBasico;
import modelo.DocumentoEntregado;
import modelo.Jugador;

import dao.generico.GenericDao;

/**
 * Clase de acceso y manejo de los datos relacionados a los documentos
 * entregados
 * 
 * @author Robert A
 * @author German L
 * @version 0.1 02/01/2012
 * 
 */
public class DaoDocumentoEntregado extends GenericDao {
	public static String SECUENCIA = "documentos_entregados_codigo_documento_seq";



}
