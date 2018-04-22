package com.nw.model.dao;


import com.nw.model.CalidadDetalleSensorialMp;

/*import java.util.Date;*/
//import com.wm.model.MedioPeriodo;

public interface CalidadDetalleSensorialMpDAO extends Dao{

	public CalidadDetalleSensorialMp CalidadDetalleSensorialMpJpaImpl();

	public void saveOrUpdate(CalidadDetalleSensorialMp calidaddetallesensorialmp);

	public int getCalidadDetalleSensorialMpByNumMuestraSensorialMp(String valorcalidadSensMp, String campoidcalsensmp);
	
}
