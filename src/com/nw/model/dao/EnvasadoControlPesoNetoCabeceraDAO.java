package com.nw.model.dao;

import java.util.List;

import com.nw.model.EnvasadoControlPesoNetoCabecera;

public interface EnvasadoControlPesoNetoCabeceraDAO {
	public EnvasadoControlPesoNetoCabecera updateEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera);
	public EnvasadoControlPesoNetoCabecera getByProduccionTurnoOrden(Long idenvasadoproceso, Integer idproducciondetalleorden);
	public List<EnvasadoControlPesoNetoCabecera> getByProduccion(Long idenvasadoproceso);
	public boolean eliminaEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera ecpfc);
}
