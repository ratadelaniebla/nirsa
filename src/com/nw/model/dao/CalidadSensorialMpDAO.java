package com.nw.model.dao;


import com.nw.model.CalidadSensorialMp;


public interface CalidadSensorialMpDAO extends Dao{

	public CalidadSensorialMp CalidadSensorialMpJpaImpl();

/*	public void createNewMedioPeriodo(String vidmedio, String vtipo,
			BigDecimal mtara, Timestamp dfechahorainicio, Timestamp dfechahorafin, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU);
*/
/*	public void saveOrupdateMedioPeriodo(String vidmedio, String vtipo,
			BigDecimal mtara, Timestamp dfechahorainicio, Timestamp dfechahorafin, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU);
*/
/*	public MedioPeriodo getMedioPeriodoByIdAndOP(String vMedio,
			String vTipo, String dfechahorainicio);
*/
	public CalidadSensorialMp getCalidadSensorialMpByIdBarcoDescarga(String idBarcoDescarga);

	
	public void saveOrUpdate(CalidadSensorialMp calidadsensorialmp);


}
