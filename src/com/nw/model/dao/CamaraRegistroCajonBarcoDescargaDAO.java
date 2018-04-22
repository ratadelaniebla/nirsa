package com.nw.model.dao;

import java.util.List;

import com.nw.model.CajonDetalleBarcoDescarga;

public interface CamaraRegistroCajonBarcoDescargaDAO extends Dao{

	void saveOrUpdate(CajonDetalleBarcoDescarga cajondetallebarcodescarga);

	public CajonDetalleBarcoDescarga getCajonDetalleBarcoDescargaByIdBarcoDescargaIdBanda(String idBarcoDescarga, String idBanda, String Idcajon);
	
	public CajonDetalleBarcoDescarga getBuscarCajonAsignadoBandaByIdBarcoDescargaIdBandaIdCajon(String idBarcoDescarga, String idBanda, String idCajon);

	public CajonDetalleBarcoDescarga getBuscarCajonAsignadoBandaByIdBarcoDescargaIdCajon(String idBarcoDescarga, String idCajon);

	public List<CajonDetalleBarcoDescarga> getListCajonDetalleBarcoDescargaByIdBarcoDescarga(String idBarcoDescarga, String idBanda);

	public CajonDetalleBarcoDescarga getCajonDetalleBarcoDescargaByIdBarcoDescargaIdCajon(String idBarcoDescarga, String Idcajon);

	//public List<CajonDetalleBarcoDescarga> getListCajonDetalleBarcoDescargaByIdBarcoDescargaIdBandaIdCajon(String idBarcoDescarga, String idBanda, String idCajon);
	//public CajonDetalleBarcoDescarga getCajonDetalleBarcoDescargaDisponibleByIdBarcoDescargaIdCajon(String idBarcoDescarga, String Idcajon);

	public CajonDetalleBarcoDescarga getCajonDetalleBarcoDescargaDisponibleByIdBarcoDescargaIdCajon(String idBarcoDescarga, String idBanda, String idCajon);
}