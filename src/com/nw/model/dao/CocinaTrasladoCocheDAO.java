package com.nw.model.dao;

import java.util.List;

import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.EvisceradoDetalleProcesoCoche;

public interface CocinaTrasladoCocheDAO extends Dao {
	
   //public List <CocinaAperturaCierreDetalle> getCocinasAperturaCierreDetallePorFechaProduccion(int idproduccion);
  
   public List <CocinaAperturaCierreDetalle> getCocinasAperturaCierreDetallePorProduccionCocina(Long idproduccion , Long idcocina);
   
   public List <EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCochePorCocina (Long idcocinaaperturacierredetalle);
   
   void saveOrUpdate(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche);
   
}
