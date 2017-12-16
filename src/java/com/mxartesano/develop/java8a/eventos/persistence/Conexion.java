/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author igarcia
 */
public class Conexion {
    private static Conexion conexion;
    private Connection connection;
    
    private String bd = "jdbc:mysql://casascoatza.com:3306/casascoa_eventos";
    private String usuario = "casascoa_develop";
    private String pass= "develop2017..";
    
    private Conexion() throws Exception
    {
        cargarControlador();
        abrirConexion();
    }
    
    private void abrirConexion() throws Exception
    {
        connection = DriverManager.getConnection(bd, usuario, pass);
    }

    private void cargarControlador() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
    }
    
    public void cerrarConexion() throws Exception
    {
        connection.close();
     
    }
    
    public static Conexion getConexionBD() throws Exception
    {
        if (conexion == null)
            conexion = new Conexion();
        else
        {
            if(conexion.connection.isClosed())
            {
                 conexion.abrirConexion();
                
            }
        }
        return conexion;
            
    }

    public Connection getConnection() {
        return connection;
    }
    
    
    
}
