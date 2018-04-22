package com.nw.model.dao;

import java.util.Date;
import java.util.List;

import com.nw.model.CamaraCajon;
import com.nw.model.BarcoDescarga;

public interface CamaraCajonBarcoDescargaMantenimientoDAO extends Dao {
	
   public List<CamaraCajon> getCamaraCajonPorBarcoDescarga(BarcoDescarga barcodescarga);
   public List <BarcoDescarga> getBarcoDescargaPorFechaDescarga(Date fechaInicio, Date fechaFin);
   void saveOrUpdate(CamaraCajon camaraCajon);
   
   
}
