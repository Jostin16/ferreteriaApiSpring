package com.idat.minimarket.app.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idat.minimarket.app.dao.ProductoDao;
import com.idat.minimarket.app.model.Categoria;
import com.idat.minimarket.app.model.Producto;

@Service
@Transactional
public class ProductoService {
	
	@Autowired
	private ProductoDao dao;
	
	public List<Producto> findAll(){
		return  (List<Producto>) dao.findAll();
	}
	
	
	
	public Producto buscarPorId(Integer id) {
		Optional<Producto> producto = dao.findById(id);
		
		if (producto.isPresent())
   		  return dao.findById(id).get();
		else
			return null;
	}

	public List<Producto> findSomeProductos(Integer id){
		return (List<Producto>) dao.findSomeProducts(id);
	}
	
	public Producto crear(Producto producto) {
		return dao.save(producto);
	}
	
	public Producto update(Producto producto) {
		Producto actualProducto = dao.findById(producto.getId()).get();
		actualProducto.setId(producto.getId());
		actualProducto.setCantidad(producto.getCantidad());
		actualProducto.setMarca(producto.getMarca());
		actualProducto.setUrl(producto.getUrl());
		actualProducto.setNombre(producto.getNombre());
		actualProducto.setCategoria(producto.getCategoria());
		return dao.save(producto);
	}
	
	public Producto aumentarStock(Integer id, Integer stockAactualizar){
		Producto productoActual = dao.findById(id).get();

		productoActual.setCantidad(productoActual.getCantidad()+stockAactualizar);

		Producto productoActualizado = dao.save(productoActual);

		return productoActualizado;
	}

	public Producto disminuirStock(Integer id, Integer stockAactualizar){
		Producto productoActual = dao.findById(id).get();
		
		productoActual.setCantidad(productoActual.getCantidad()-stockAactualizar);

		Producto productoActualizado = dao.save(productoActual);

		return productoActualizado;
	}
	
}
