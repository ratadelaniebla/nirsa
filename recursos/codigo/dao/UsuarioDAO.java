package com.wm.model.dao;

import java.util.List;

import com.wm.model.dao.Dao;
import com.wm.model.Usuario;

@SuppressWarnings("unchecked")

public interface UsuarioDAO extends Dao {

	 public Usuario getUser(String id);
	 
	 public List getOpcionesAsignadas(String id);

	 public List<Usuario> getUsers(Usuario user);
	 
}
