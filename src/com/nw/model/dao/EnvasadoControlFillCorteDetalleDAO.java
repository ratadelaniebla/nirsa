package com.nw.model.dao;

import java.util.List;

import com.nw.model.EnvasadoControlFillCorteDetalle;

public interface EnvasadoControlFillCorteDetalleDAO {
	
	public boolean eliminaTodos(List<EnvasadoControlFillCorteDetalle> listECFCD);
	
	public boolean elimina(EnvasadoControlFillCorteDetalle ecfcd);

}
