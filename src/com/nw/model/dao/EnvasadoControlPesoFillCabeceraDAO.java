package com.nw.model.dao;

import java.util.List;

import com.nw.model.EnvasadoControlPesoFillCabecera;

public interface EnvasadoControlPesoFillCabeceraDAO {
	public EnvasadoControlPesoFillCabecera updateEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera);
	public EnvasadoControlPesoFillCabecera getByProduccionTurnoOrden(Long idenvasadoproceso, Long idproducciondetalleorden);
	public List<EnvasadoControlPesoFillCabecera> getByProduccion(Long idenvasadoproceso);
	public boolean eliminaEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera ecpfc);
}
