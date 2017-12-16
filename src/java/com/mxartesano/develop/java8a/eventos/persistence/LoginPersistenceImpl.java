/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.persistence;

import com.mxartesano.develop.java8a.eventos.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author igarcia
 */
public class LoginPersistenceImpl implements LoginPersistence{

    @Override
    public boolean existeLogin(Login login) throws Exception {
        
        Connection connection = Conexion.getConexionBD().getConnection();

        PreparedStatement pst = connection.prepareStatement("SELECT id_usuario "
                + "FROM usuario "
                + "WHERE correo = ? AND password = ?");
        pst.setString(1, login.getCorreoElectronico());
        pst.setString(2, login.getPassword());

        
        ResultSet rs = pst.executeQuery();
        boolean respuesta = rs.next();
        
        rs.close();
        pst.close();
        
        
        return respuesta;
    }
    
}
