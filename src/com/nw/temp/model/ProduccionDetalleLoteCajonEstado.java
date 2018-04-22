package com.nw.temp.model;

 

import com.nw.model.ProduccionDetalleLoteCajon;


/**
 * Esta clase personalizada permite seleccionar los item para reubicarlos de
 * origen a destino segun los que se escojan y ademas permitira saber si son
 * datos provenientes de la base de datos o si son nuevos y con esto puedo
 * determinar lo q tengo q modificar o guardar
 * 
 * @author Carlos Holguin
 * @since 09-07-2014
 * @version 1.0
 * 
 */

// Comparable<EvisceradoDetalleProcesoCocheEstado>       Comparator
public class ProduccionDetalleLoteCajonEstado implements Comparable<ProduccionDetalleLoteCajonEstado> {

	private Integer numero;
	private ProduccionDetalleLoteCajon produccionDetalleLoteCajon;
	private boolean estadoCoche;
	private boolean reubicarCoche;
	
	private String horainicio;
	private String horafin;
	

	public ProduccionDetalleLoteCajonEstado() {

	}

	public ProduccionDetalleLoteCajonEstado
	(int numero, ProduccionDetalleLoteCajon produccionDLoteCajon,
	boolean estadoCoche, boolean reubicarCoche, String horainicio, String horafin) 
	{
		this.numero = numero;
		this.setProduccionDetalleLoteCajon(produccionDLoteCajon);
		this.estadoCoche = estadoCoche;
		this.reubicarCoche = reubicarCoche;
		this.horainicio = horainicio;
		this.horafin = horafin;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	


	public boolean isEstadoCoche() {
		return estadoCoche;
	}

	public void setEstadoCoche(boolean estadoCoche) {
		this.estadoCoche = estadoCoche;
	}

	public boolean isReubicarCoche() {
		return reubicarCoche;
	}

	public void setReubicarCoche(boolean reubicarCoche) {
		this.reubicarCoche = reubicarCoche;
	}

//	@Override
//	public int compare(EvisceradoDetalleProcesoCocheEstado o1,
//			EvisceradoDetalleProcesoCocheEstado o2) {
//		EvisceradoDetalleProcesoCocheEstado edpc1 = (EvisceradoDetalleProcesoCocheEstado)o1;
//		EvisceradoDetalleProcesoCocheEstado edpc2 = (EvisceradoDetalleProcesoCocheEstado)o2;
//        return edpc1.getNumero().
//                compareTo(edpc2.getNumero());
//		 
//	}

	@Override
	public int compareTo(ProduccionDetalleLoteCajonEstado edpce) {
		 
		return numero.compareTo(edpce.getNumero());
		 
	}

	public ProduccionDetalleLoteCajon getProduccionDetalleLoteCajon() {
		return produccionDetalleLoteCajon;
	}

	public void setProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		this.produccionDetalleLoteCajon = produccionDetalleLoteCajon;
	}

	/**
	 * @return the horainicio
	 */
	public String getHorainicio() {
		return horainicio;
	}

	/**
	 * @param horainicio the horainicio to set
	 */
	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}

	/**
	 * @return the horafin
	 */
	public String getHorafin() {
		return horafin;
	}

	/**
	 * @param horafin the horafin to set
	 */
	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}




}
