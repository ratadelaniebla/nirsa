package com.nw.model.dao;

import java.util.List;
import com.nw.model.CalidadDetallePcc;

public interface CalidadDetallePccDAO extends Dao{

	public CalidadDetallePcc CalidadDetallePccJpaImpl();

	public void saveOrUpdate(CalidadDetallePcc calidaddetallepcc);
	
	public List<CalidadDetallePcc> getCalidadDetallePccByIdCubaIdMuestreoIdEspecie(String idCuba, String idMuestreo, String idEspecie);

	public CalidadDetallePcc getCalidadDetallePccp(Long idbarcoestibacuba, Integer nummuestreo, Integer idespecietalla, Integer nummuestra);
}