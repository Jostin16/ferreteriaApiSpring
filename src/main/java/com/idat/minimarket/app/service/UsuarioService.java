package com.idat.minimarket.app.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.idat.minimarket.app.dao.UsuarioDao;
import com.idat.minimarket.app.model.Usuario;
import com.idat.minimarket.app.utils.GenericResponse;
import com.idat.minimarket.app.utils.Globals;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioDao dao;

    public UsuarioService(UsuarioDao repository) {
        this.dao = repository;
    }
    //Método para iniciar sesión
    public GenericResponse<Usuario> login(String email, String contrasenia){
        Optional<Usuario> optU = this.dao.logueo(email, contrasenia);
        if(optU.isPresent()){
            return new GenericResponse<Usuario>(Globals.TIPO_AUTH, Globals.RPTA_OK, "Haz iniciado sesión correctamente", optU.get());
        }else{
            return new GenericResponse<Usuario>(Globals.TIPO_AUTH, Globals.RPTA_WARNING, "Lo sentimos, ese usuario no existe", new Usuario());
        }
    }
    
    public Usuario insert(Usuario usuario) {
		return dao.save(usuario);
	}
    
    public List<Usuario> findAll(){
		return (List<Usuario>) dao.findAll();
	}
}