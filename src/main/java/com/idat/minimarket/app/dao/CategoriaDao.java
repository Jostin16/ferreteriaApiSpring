package com.idat.minimarket.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.minimarket.app.model.Categoria;

@Repository
public interface CategoriaDao extends CrudRepository<Categoria, Integer> {

}
