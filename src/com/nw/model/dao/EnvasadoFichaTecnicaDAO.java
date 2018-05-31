package com.nw.model.dao;

import com.nw.model.EnvasadoFichaTecnica;

public interface EnvasadoFichaTecnicaDAO {

	public EnvasadoFichaTecnica updateEnvasadoFichaTecnica(EnvasadoFichaTecnica envasadoFichaTecnica);
	public EnvasadoFichaTecnica getByOrden(Integer idproducciondetalleorden);
}
