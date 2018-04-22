package com.nw.model.dao;

import java.util.List;


import com.nw.model.EvisceradoPescadosLata;

public interface EvisceradoPescadosLataDAO extends Dao {
	
   public List <EvisceradoPescadosLata> getEvisceradoPescadosLatas();
   void saveOrUpdate(EvisceradoPescadosLata evisceradoPescadosLata);
   public List <EvisceradoPescadosLata> getListaPescadosLatasxPeso(Double peso);
   
}
