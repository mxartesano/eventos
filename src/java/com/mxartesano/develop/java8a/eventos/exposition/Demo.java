/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.exposition;

import com.mxartesano.develop.java8a.eventos.persistence.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igarcia
 */
public class Demo {
    public static void main(String[] args) {
        try {
            Conexion.getConexionBD();
            System.out.println("Conexion OK");
            
            Connection connection = Conexion.getConexionBD().getConnection();
         

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from eventos ");
            
            while(rs.next()){
                System.out.println("Datos:");
            }

            
        } catch (Exception ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
