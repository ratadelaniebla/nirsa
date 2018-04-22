package com.nw.model.dao;


import java.util.List;

import com.nw.model.BarcoEstibaCuba;


public interface BarcoEstibaCubaDAO extends Dao {


	public BarcoEstibaCuba BarcoEstibaCubaJpaImpl();

	public BarcoEstibaCuba getBarcoEstibaCubaByIdBarcoDescarga(String idBarcoDescarga);
	
	public List<BarcoEstibaCuba> getListBarcoEstibaCubaByIdBarcoDescarga(String idBarcoDescarga);

	public BarcoEstibaCuba getBarcoEstibaCubaById(Long long1);
	
	void saveOrUpdate(BarcoEstibaCuba barcoestibacuba);

	public BarcoEstibaCuba BuscarEstibaCubaByIdBarcoEstibaCuba(String IdBarcoEstibaCuba);

	public BarcoEstibaCuba getBarcoEstibaCubaByIdBarcoDescargaIdBarcoCuba(String idBarcoDescarga, String idBarcoCuba);

	public BarcoEstibaCuba getBarcoEstibaCubaByIdBarcoDescargaIdBarcoCubaEstado(
			String idBarcoDescarga, String idBarcoCuba);

	

}
