package com.idat.minimarket.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.idat.minimarket.app.model.Usuario;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE u.email=:email AND u.password=:password")
	Optional<Usuario> logueo (String email, String password);


}
