package com.nw.temp.model;

 
import com.nw.model.BarcoCuba;
 


/**
 * Esta clase personalizada permite seleccionar los item para eliminarlos 
 * segun los que se escojan y ademas permitira saber si son datos provenientes de la base de datos 
 * o si son nuevos y  con esto puedo determinar lo q tengo q modificar o guardar
 * 
 * @author Carlos Holguin
 * @since 19-06-2014
 * @version 1.0
 *
 */
public class BarcoCubaEstado {

	
	private BarcoCuba barcoCuba; 
	private boolean estadoCuba;
	private boolean eliminarCuba;
	
	public BarcoCubaEstado() {
	 
	}
	
	public BarcoCubaEstado( BarcoCuba barcoCuba, boolean estadoCuba , boolean eliminarCuba) {
	 this.barcoCuba = barcoCuba;
	 this.estadoCuba = estadoCuba;
	 this.eliminarCuba = eliminarCuba;
		
	}

	public BarcoCuba getBarcoCuba() {
		return barcoCuba;
	}

	public void setBarcoCuba(BarcoCuba barcoCuba) {
		this.barcoCuba = barcoCuba;
	}

	public boolean isEstadoCuba() {
		return estadoCuba;
	}


	public void setEstadoCuba(boolean estadoCuba) {
		this.estadoCuba = estadoCuba;
	}


	public boolean isEliminarCuba() {
		return eliminarCuba;
	}


	public void setEliminarCuba(boolean eliminarCuba) {
		this.eliminarCuba = eliminarCuba;
	}

	
	
	
	
}
