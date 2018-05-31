package com.nw.model.dao;

import java.util.List;

import com.nw.model.EnvasadoControlPesoNetoDetalle;

public interface EnvasadoControlPesoNetoDetalleDAO {
	public EnvasadoControlPesoNetoDetalle updateEnvasadoControlPesoNetoDetalle(EnvasadoControlPesoNetoDetalle envasadoControlPesoNetoDetalle);
	public boolean eliminaEnvasadoControlPesoNetoDetalle(EnvasadoControlPesoNetoDetalle ecpnd) ;
	public List<EnvasadoControlPesoNetoDetalle> obtieneByIdEnvasadoControlPesoNetoDetalle(Long idenvasadocontrolpesonetocabecera);
	public List<EnvasadoControlPesoNetoDetalle> obtieneByEnvasadoControlPesoNetoDetalleByCorte(Long idenvasadocontrolnetocortedetalle, Long idenvasadocontrolpesonetocabecera);

}
