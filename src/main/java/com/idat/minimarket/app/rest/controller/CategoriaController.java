package com.idat.minimarket.app.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.idat.minimarket.app.model.Categoria;
import com.idat.minimarket.app.service.CategoriaService;

@RestController
@RequestMapping("/api")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;

	@GetMapping("/listarCategorias")
	public List<Categoria> listar() {
		return (List<Categoria>) service.findAll();
	}

	@GetMapping(value = "/{id}")
	
	public 	Categoria buscarPorId(@PathVariable("id") Integer id) {
		Categoria categoria = service.buscarPorId(id);

		if (categoria == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Categoria no encontrada, id proporcionado no es correcto.");

		return  categoria;
	}

	@PostMapping("/insertarCategoria")
	public ResponseEntity<Object> insertar(@RequestBody Categoria categoria) {
        service.crear(categoria);
        return new ResponseEntity<Object>("Categoria creado correctamente en BD", HttpStatus.OK);
    }
	
	@PutMapping(value = "/editar/categoria/{id}")
    public ResponseEntity<Object> actualizarCategoria(@PathVariable("id") Integer id, @RequestBody Categoria categoriaActualizar) 
    {
       
		Categoria categoria = this.service.buscarPorId(id);

		if(categoria == null){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}else{
			categoriaActualizar.setId(id);
			return new ResponseEntity<>(this.service.update(categoriaActualizar),HttpStatus.OK);
		}
    }


}
