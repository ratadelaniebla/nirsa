package com.nw.model.dao;

import com.nw.model.Cliente;


public interface HarinaClienteDAO extends Dao {

	void saveOrUpdate(Cliente cliente);

}
