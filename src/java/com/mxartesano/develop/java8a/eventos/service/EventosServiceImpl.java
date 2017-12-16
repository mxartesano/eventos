/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.service;

import com.mxartesano.develop.java8a.eventos.model.Evento;
import com.mxartesano.develop.java8a.eventos.persistence.EventoPersistence;
import com.mxartesano.develop.java8a.eventos.persistence.EventoPersistenceImpl;
import java.util.List;

/**
 *
 * @author Valeria
 */
public class EventosServiceImpl implements EventoService{

    private EventoPersistence eventoPersistence;
    
    public EventosServiceImpl(){
        eventoPersistence = new EventoPersistenceImpl();
        
        
    }
    
    @Override
    public List<Evento> obtenerEventos() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        return eventoPersistence.obtenerEventos();
    }

    @Override
    public void registrarEvento(Evento e) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if(e!= null && e.getNombre() !=null && !e.getNombre().isEmpty() && e.getFecha()!= null && e.getUbicacion()!=null && !e.getUbicacion().isEmpty()){
            System.out.println("Datos correctos");
            eventoPersistence.registrarEvento(e);
            
        }else{
            System.out.println("Verificar Datos");
            throw new Exception("Verificar Datos de Evento ");
        
        }
        
        
    }
    
}
