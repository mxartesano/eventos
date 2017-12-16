/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.service;

import com.mxartesano.develop.java8a.eventos.model.Usuario;
import com.mxartesano.develop.java8a.eventos.persistence.UsuarioPersitence;
import com.mxartesano.develop.java8a.eventos.persistence.UsuarioPersitenceImpl;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioServiceImpl implements UsuarioService{
    
    private UsuarioPersitence usuarioPersitence;
    
    public UsuarioServiceImpl() {
        usuarioPersitence = new UsuarioPersitenceImpl();
    }
    /*
    ninguno de las sig variables puede ser nula
    nombre
    apellidoPaterno
    apellidoMaterno
    correoEklectronico
    password
    */
    //@Override
    
    public List<Usuario> obtenerUsuarios() throws Exception {
        return usuarioPersitence.obtenerUsuarios();
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws Exception {
       if(usuario != null || usuario.getNombre() != null || !usuario.getNombre().isEmpty() && usuario.getApellidoPaterno() != null || !usuario.getApellidoPaterno().isEmpty() &&
             usuario.getApellidoMaterno() != null || !usuario.getApellidoMaterno().isEmpty() && usuario.getCorreoelectronico() != null || !usuario.getCorreoelectronico().isEmpty() &&
             usuario.getPassword() != null || !usuario.getPassword().isEmpty())
        {
        usuarioPersitence.registrarUsuario(usuario);
        
        }else{
            throw new Exception ("Revisar campos XD");
        }  
    }
    
}
