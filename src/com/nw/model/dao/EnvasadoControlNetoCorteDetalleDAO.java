package com.nw.model.dao;

import java.util.List;

import com.nw.model.EnvasadoControlNetoCorteDetalle;

public interface EnvasadoControlNetoCorteDetalleDAO {
	
	public boolean eliminaTodos(List<EnvasadoControlNetoCorteDetalle> listECFCD);
	
	public boolean elimina(EnvasadoControlNetoCorteDetalle ecfcd);

}
