/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.service;

import com.mxartesano.develop.java8a.eventos.model.Evento;
import java.util.List;

/**
 * CAPA DE NEGOCIO
 * @author igarcia
 */
public interface EventoService {
    List<Evento> obtenerEventos() throws Exception;
    void registrarEvento(Evento e) throws Exception;
}
