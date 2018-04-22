package com.wm.model.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.wm.model.OrdenFabricacionUp;



public interface OrdenFabricacionUpDAO extends Dao {

	public OrdenFabricacionUp getNewOrdenFabricacionUp();

	void createNewOrdenFabricacionUp(String vidordenfabricacionsap, String idmaterial, String idlote,
			String idpackinlist, Timestamp ifechaproduccion, int idiajuliano, int igrupoprocesos, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU);

	void saveOrupdateOrdenFabricacionUp(long iordenfabricacion, String idlote, String vidordenfabricacionsap, String idmaterial,
			String idpackinlist, Timestamp ifechaproduccion, int idiajuliano, int igrupoprocesos, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU);

	public List<OrdenFabricacionUp> getOrdenesByDate(String dFProduccion);

	public List getOrdenArchivo(String ordenfabsap, String material, String lote);

	public OrdenFabricacionUp getOrdenxOrdenFab(long ordenfab);
	
}
