/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.service;

import com.mxartesano.develop.java8a.eventos.model.Usuario;
import java.util.List;

/**
 *
 * @author igarcia
 */
public interface UsuarioService {
    List<Usuario> obtenerUsuarios() throws Exception;
    void registrarUsuario(Usuario usuario) throws Exception;
}
