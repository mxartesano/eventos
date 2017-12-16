/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.persistence;

import com.mxartesano.develop.java8a.eventos.model.Evento;
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
public class EventoPersistenceImpl implements EventoPersistence{

    @Override
    public List<Evento> obtenerEventos() throws Exception {
        List<Evento> eventos = new ArrayList<Evento>();
        Connection connection = Conexion.getConexionBD().getConnection();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT id_evento, nombre, fecha, ubicacion "
                + "FROM eventos");

        Evento e;
        while (rs.next()) {
            e = new Evento();
            e.setIdEvento(rs.getInt("id_evento"));
            e.setNombre(rs.getString("nombre"));
            e.setFecha(rs.getDate("fecha"));
            e.setUbicacion(rs.getString("ubicacion"));
            
            eventos.add(e);
              
        }
            rs.close();
            st.close();
            
        return eventos;
    }

    @Override
    public void registrarEvento(Evento e) throws Exception {
        
        Connection connection = Conexion.getConexionBD().getConnection();
        PreparedStatement pst = connection.prepareStatement("insert into eventos(nombre, fecha, ubicacion) values (?,?,NOW())");
        pst.setString(1, e.getNombre());
        pst.setDate(2, new java.sql.Date(e.getFecha().getTime()));
        pst.setString(3, e.getUbicacion());
        
        pst.executeUpdate();
        pst.close();
        
    }
    
}
