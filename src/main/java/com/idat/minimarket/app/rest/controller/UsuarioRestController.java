package com.idat.minimarket.app.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.minimarket.app.model.Usuario;
import com.idat.minimarket.app.service.UsuarioService;
import com.idat.minimarket.app.utils.GenericResponse;

@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {
	
    private final UsuarioService service;

    public UsuarioRestController(UsuarioService service) {
        this.service = service;
    }
    
    @GetMapping("/listarUsuario")
	public List<Usuario> listar() {
		return (List<Usuario>) service.findAll();
	}
    
    @PostMapping("/login")
    public GenericResponse<Usuario> login(HttpServletRequest request){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return this.service.login(email, password);
    }
    
    @PostMapping("/insertarUsuario")
	public ResponseEntity<Object> crear(@RequestBody Usuario usuario) {
        service.insert(usuario);
        return new ResponseEntity<Object>("Usuario creado correctamente en BD", HttpStatus.OK);
    }

}
