package com.nw.temp.model;

public class CoccionRociadoProcesoCoche {
	
	private int idCocheGlobal;
	private int idCoche;
	private int idCocina;
	private int canastillas;
	private int idEvisceradopescadoLata;
	private int idDuchaRociado;
	private int idLote;
	private int idCoccionDetalleProcesoCoche;
	
	
	public CoccionRociadoProcesoCoche(){
		
	}
	
	public CoccionRociadoProcesoCoche(int idCocheGlobal, int idCoche, 
			int idCocina, int canastillas, int idEvisceradopescadoLata, 
			int idDuchaRociado, int idLote){
		this.setIdCocheGlobal(idCocheGlobal);
		this.setIdCoche(idCoche);
		this.setIdCocina(idCocina);
		this.setCanastillas(canastillas);
		this.setIdEvisceradopescadoLata(idEvisceradopescadoLata);
		this.setIdDuchaRociado(idDuchaRociado);
		this.setIdLote(idLote);
		
	}

	public int getIdCocheGlobal() {
		return idCocheGlobal;
	}

	public void setIdCocheGlobal(int idCocheGlobal) {
		this.idCocheGlobal = idCocheGlobal;
	}

	public int getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	public int getIdCocina() {
		return idCocina;
	}

	public void setIdCocina(int idCocina) {
		this.idCocina = idCocina;
	}

	public int getCanastillas() {
		return canastillas;
	}

	public void setCanastillas(int canastillas) {
		this.canastillas = canastillas;
	}

	public int getIdEvisceradopescadoLata() {
		return idEvisceradopescadoLata;
	}

	public void setIdEvisceradopescadoLata(int idEvisceradopescadoLata) {
		this.idEvisceradopescadoLata = idEvisceradopescadoLata;
	}

	public int getIdDuchaRociado() {
		return idDuchaRociado;
	}

	public void setIdDuchaRociado(int idDuchaRociado) {
		this.idDuchaRociado = idDuchaRociado;
	}

	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public int getIdCoccionDetalleProcesoCoche() {
		return idCoccionDetalleProcesoCoche;
	}

	public void setIdCoccionDetalleProcesoCoche(int idCoccionDetalleProcesoCoche) {
		this.idCoccionDetalleProcesoCoche = idCoccionDetalleProcesoCoche;
	}
	
	
	
	
	

}
