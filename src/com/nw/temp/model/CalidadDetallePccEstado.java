package com.nw.temp.model;

import  com.nw.model.CalidadDetallePcc;
 

public class CalidadDetallePccEstado {

	private CalidadDetallePcc CalidadDetallePcc;
	private boolean editingStatus;
	private boolean saveStatus;
	private double fluorometro;
	private double pesoMuestra;
	private double consumo;
	private String ph;
	private String nitrogeno;
	private String estamina;
	private String sal;

	public CalidadDetallePccEstado(CalidadDetallePcc CalidadDetallePcc,
			boolean editingStatus, boolean saveStatus, double fluorometro ,double pesoMuestra,double consumo,String ph,String nitrogeno, 
			String estamina, String sal) {
		this.CalidadDetallePcc = CalidadDetallePcc;
		this.editingStatus = editingStatus;
		this.saveStatus = saveStatus;
		this.fluorometro = fluorometro;
		 this.pesoMuestra= pesoMuestra;
		 this.consumo= consumo;
		 this.ph=ph;
		 this.nitrogeno= nitrogeno;
		 this.estamina= estamina;
		 this.sal=sal;
	}

	public CalidadDetallePcc getCalidadDetallePcc() {
		return CalidadDetallePcc;
	}

	public void setCalidadDetallePcc(CalidadDetallePcc CalidadDetallePcc) {
		this.CalidadDetallePcc = CalidadDetallePcc;
	}

	public boolean getEditingStatus() {
		return editingStatus;
	}

	public void setEditingStatus(boolean editingStatus) {
		this.editingStatus = editingStatus;
	}

	public boolean getSaveStatus() {
		return saveStatus;
	}

	public void setSaveStatus(boolean saveStatus) {
		this.saveStatus = saveStatus;
	}
	
	public double getFluorometro() {
		return fluorometro;
	}

	public void setFluorometro(double fluorometro) {
		this.fluorometro = fluorometro;
	}

	public double getPesoMuestra() {
		return pesoMuestra;
	}

	public void setPesoMuestra(double pesoMuestra) {
		this.pesoMuestra = pesoMuestra;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getNitrogeno() {
		return nitrogeno;
	}

	public void setNitrogeno(String nitrogeno) {
		this.nitrogeno = nitrogeno;
	}

	public String getEstamina() {
		return estamina;
	}

	public void setEstamina(String estamina) {
		this.estamina = estamina;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

}
