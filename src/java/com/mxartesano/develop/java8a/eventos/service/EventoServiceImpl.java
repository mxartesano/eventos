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
 * @author Usuario
 */
public class EventoServiceImpl implements EventoService{
    
    private EventoPersistence eventoPersistence;

        public EventoServiceImpl(){
        
            eventoPersistence = new EventoPersistenceImpl();
        }
    @Override
    public List<Evento> obtenerEventos() throws Exception {
        return eventoPersistence.obtenerEventos();
    }

    @Override
    public void registrarEvento(Evento e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
