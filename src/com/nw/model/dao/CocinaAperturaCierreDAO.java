package com.nw.model.dao;

import java.util.List;

import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.Produccion;

public interface CocinaAperturaCierreDAO extends Dao {
	
   public List<CocinaAperturaCierreDetalle> obtenerCocinasDetalle(Produccion idPro);
   void saveOrUpdate(CocinaAperturaCierreDetalle cocina); 
   
}
