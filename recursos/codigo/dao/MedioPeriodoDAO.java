package com.wm.model.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
/*import java.util.Date;*/
import com.wm.model.MedioPeriodo;

public interface MedioPeriodoDAO extends Dao{

	public MedioPeriodo MedioPeriodoJpaImpl();

	public void createNewMedioPeriodo(String vidmedio, String vtipo,
			BigDecimal mtara, Timestamp dfechahorainicio, Timestamp dfechahorafin, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU);

	public void saveOrupdateMedioPeriodo(String vidmedio, String vtipo,
			BigDecimal mtara, Timestamp dfechahorainicio, Timestamp dfechahorafin, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU);

	public MedioPeriodo getMedioPeriodoByIdAndOP(String vMedio,
			String vTipo, String dfechahorainicio);

	
	public void saveOrUpdate(MedioPeriodo medioperiodo);

}
