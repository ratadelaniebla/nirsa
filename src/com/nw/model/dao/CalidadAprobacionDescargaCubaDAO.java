package com.nw.model.dao;
import com.nw.model.CalidadAprobacionDescargaCuba;
import com.nw.model.CalidadDetallePcc;


public interface CalidadAprobacionDescargaCubaDAO extends Dao{

	void saveOrUpdate(CalidadAprobacionDescargaCuba calidadaprobaciondescargacuba);

	public CalidadDetallePcc CalidadDetallePccJpaImpl();

	public CalidadDetallePcc getCalidadDetallePccp(Integer idbarcoestibacuba);

	void saveOrUpdate(CalidadDetallePcc calidaddetallepcc);
}