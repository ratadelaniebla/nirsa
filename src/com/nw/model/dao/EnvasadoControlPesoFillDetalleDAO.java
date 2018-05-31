package com.nw.model.dao;

import java.util.List;

import com.nw.model.EnvasadoControlPesoFillDetalle;

public interface EnvasadoControlPesoFillDetalleDAO {
	public EnvasadoControlPesoFillDetalle updateEnvasadoControlPesoFillDetalle(EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle);
	public boolean eliminaEnvasadoControlPesoFillDetalle(EnvasadoControlPesoFillDetalle ecpfd) ;
	public List<EnvasadoControlPesoFillDetalle> obtieneByIdEnvasadoControlPesoFillDetalle(Long idenvasadocontrolpesofillcabecera);
	public List<EnvasadoControlPesoFillDetalle> obtieneByEnvasadoControlPesoFillDetalleByCorte(Long idenvasadocontrolfillcortedetalle, Long idenvasadocontrolpesofillcabecera);
}
