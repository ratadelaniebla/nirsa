package com.nw.model.dao;

import java.util.List;

import com.nw.model.CalidadObservacionesMuestraCuba;

public interface CalidadObservacionesMuestraCubaDAO extends Dao {

	public List<CalidadObservacionesMuestraCuba> getCalidadObservacionesMuestraCuba();

	public CalidadObservacionesMuestraCuba findById(Integer idcalidadobservacion);
}
