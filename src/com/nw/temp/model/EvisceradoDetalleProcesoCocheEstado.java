package com.nw.temp.model;

 

import com.nw.model.EvisceradoDetalleProcesoCoche;


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
public class EvisceradoDetalleProcesoCocheEstado implements Comparable<EvisceradoDetalleProcesoCocheEstado> {

	private Integer numero;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private boolean estadoCoche;
	private boolean reubicarCoche;
	

	public EvisceradoDetalleProcesoCocheEstado() {

	}

	public EvisceradoDetalleProcesoCocheEstado(int numero,
			EvisceradoDetalleProcesoCoche EvisceradoDetalleProcesoCoche,
			boolean estadoCoche, boolean reubicarCoche) {
		this.numero = numero;
		this.evisceradoDetalleProcesoCoche = EvisceradoDetalleProcesoCoche;
		this.estadoCoche = estadoCoche;
		this.reubicarCoche = reubicarCoche;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(
			EvisceradoDetalleProcesoCoche EvisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = EvisceradoDetalleProcesoCoche;
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
	public int compareTo(EvisceradoDetalleProcesoCocheEstado edpce) {
		 
		return numero.compareTo(edpce.getNumero());
		 
	}




}
