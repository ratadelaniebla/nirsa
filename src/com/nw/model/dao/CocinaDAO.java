package com.nw.model.dao;

import java.util.List;


import com.nw.model.Cocina;

public interface CocinaDAO extends Dao {
	
   public List <Cocina> getCocinas();
   void saveOrUpdate(Cocina cocina);

   
}
