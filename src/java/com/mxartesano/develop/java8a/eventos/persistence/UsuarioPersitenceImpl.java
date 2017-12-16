/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.persistence;

import com.mxartesano.develop.java8a.eventos.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igarcia
 */
public class UsuarioPersitenceImpl implements UsuarioPersitence{

    @Override
    public List<Usuario> obtenerUsuarios() throws Exception {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Connection connection = Conexion.getConexionBD().getConnection();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT id_usuario, ap_paterno, ap_materno, correo, nombre, password "
                + "FROM usuario");

        Usuario u;
        while(rs.next()){
            u = new Usuario();
            u.setId(rs.getInt("id_usuario"));
            u.setNombre(rs.getString("nombre"));
            u.setApellidoPaterno(rs.getString("ap_paterno"));
            u.setApellidoMaterno(rs.getString("ap_materno"));
            u.setCorreoelectronico(rs.getString("correo"));
            u.setPassword(rs.getString("password"));
            
            usuarios.add(u);
        }
        
        rs.close();
        st.close();
        
        return usuarios;
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws Exception {
        Connection connection = Conexion.getConexionBD().getConnection();
        PreparedStatement pst = connection.prepareStatement("INSERT INTO usuario(ap_paterno, ap_materno, correo, nombre, password ) "
                + "VALUES (?,?,?,?,?)");
        
        pst.setString(1, usuario.getApellidoPaterno());
        pst.setString(2, usuario.getApellidoMaterno());
        pst.setString(3, usuario.getCorreoelectronico());
        pst.setString(4, usuario.getNombre());
        pst.setString(5, usuario.getPassword());
        
        pst.executeUpdate();
        pst.close();

    }
    
}
