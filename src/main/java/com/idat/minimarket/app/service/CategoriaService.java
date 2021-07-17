package com.idat.minimarket.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idat.minimarket.app.dao.CategoriaDao;
import com.idat.minimarket.app.model.Categoria;

@Service
@Transactional
public class CategoriaService {
	
	@Autowired
	private CategoriaDao dao;
	
	public List<Categoria> findAll(){
		return (List<Categoria>) dao.findAll();
	}
	
	public Categoria crear(Categoria categoria) {
		return dao.save(categoria);
	}
	
	public Categoria update(Categoria categoria) {
		Categoria actualCategoria = dao.findById(categoria.getId()).get();
		actualCategoria.setId(categoria.getId());
		actualCategoria.setDescripcion(categoria.getDescripcion());
		actualCategoria.setUrl(categoria.getUrl());
		return dao.save(categoria);
	}
	
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> categoria = dao.findById(id);
		
		if (categoria.isPresent())
   		  return dao.findById(id).get();
		else
			return null;
	}
	

}
