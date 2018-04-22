package com.nw.model.dao;

import java.util.List;

import com.nw.model.dao.Dao;
import com.nw.model.Usuario;

@SuppressWarnings("unchecked")

public interface UsuarioDAO extends Dao {

	 public Usuario getUser(String id);
	 
	 public List getOpcionesAsignadas(String id);

	 public List<Usuario> getUsers(Usuario user);
	 
}
