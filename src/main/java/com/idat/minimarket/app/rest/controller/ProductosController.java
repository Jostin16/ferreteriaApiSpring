package com.idat.minimarket.app.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.idat.minimarket.app.model.Producto;
import com.idat.minimarket.app.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductosController {

	@Autowired
	private ProductoService service;
	
	String[] listaProductos = null;


	@GetMapping("/listarProductos")
	public List<Producto> listar() {
		return (List<Producto>) service.findAll();
	}

	@GetMapping(value = "/productos/{id}")
	public 	Producto buscarPorId(@PathVariable("id") Integer id) {
		Producto producto = service.buscarPorId(id);

		if (producto == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Producto no encontrado, id proporcionado no es correcto.");

		return  producto;
	}
	
	
	@GetMapping("/listarProductosCategoria/{id}")
    public ResponseEntity<List<Producto>> buscarSomeProductos(@PathVariable("id") Integer id) {
        
		List<Producto> listaProductos =  service.findSomeProductos(id);
		
		if (listaProductos.isEmpty()) {
			
			return new ResponseEntity("Productos no encontrados", HttpStatus.OK);
		}

        return new ResponseEntity<List<Producto>>(listaProductos, HttpStatus.OK);
    }


}
