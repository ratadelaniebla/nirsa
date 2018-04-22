package com.wm.model.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import com.wm.model.Medio;
import com.wm.model.OrdenFabricacionUpl;

public interface MedioDAO extends Dao{

	public Medio MedioJpaImpl();

	public void createNewMedio(String vidmedio, String vtipo,
			BigDecimal mtara, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU);

	public void saveOrupdateMedio(String vidmedio, String vtipo,
			BigDecimal mtara, String vobservaciones,
			Timestamp horaingreso_AU, String usuarioingreso_AU, Timestamp horamodificacion_AU, String usuariomodificacion_AU);

	public Medio getMedioByIdAndOP(String vMedio,
			String vTipo);

	
	public void saveOrUpdate(Medio medio);

}
