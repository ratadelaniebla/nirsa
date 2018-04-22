package com.wm.model.dao;

import java.math.BigDecimal;


import com.wm.model.OrdenFabricacionUpl;

public interface OrdenFabricacionUplDAO extends Dao {

	public OrdenFabricacionUpl getNewOrdenFabricacionUpl();

	void createNewOrdenFabricacionUpl(long iordenfabricacion, String vmedio,
			BigDecimal mpesoiniciop1/*, BigDecimal mpesofinalp1*/);

	void saveOrupdateOrdenFabricacionUpl(long iordenfabricacion, String vmedio,
			BigDecimal mpesoiniciop1/*, BigDecimal mpesofinalp1*/);

	public OrdenFabricacionUpl getMedioByIdAndOP(long iOrdenFabricacion,
			String vMedio);

	public OrdenFabricacionUpl getMedioByIdAndFOP(String vIdMedio, String dFProduccion);	

	public Number getCountTinasOPWithOutWeigth(long iOrdenFabricacion);

	public void saveOrUpdate(OrdenFabricacionUpl ordenfabricacionupl);

}
