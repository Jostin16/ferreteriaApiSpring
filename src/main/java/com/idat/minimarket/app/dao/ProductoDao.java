package com.idat.minimarket.app.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.idat.minimarket.app.model.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Integer> {

	@Query("from Producto")
	public String[] obtenerProductos(); 
	
	@Query(value="SELECT p.id,p.nombre,p.marca,p.precio,p.cantidad,p.url,p.categoria FROM productos p JOIN categorias c ON p.categoria=c.id WHERE c.id=:id",nativeQuery=true)
	public List<Producto> findSomeProducts(Integer id);
}
