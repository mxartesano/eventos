/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.exposition;

import com.mxartesano.develop.java8a.eventos.model.Evento;
import com.mxartesano.develop.java8a.eventos.persistence.EventoPersistence;
import com.mxartesano.develop.java8a.eventos.service.EventoService;
import com.mxartesano.develop.java8a.eventos.service.EventosServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mxartesano
 */
@WebServlet(name = "Registro", urlPatterns = {"/registroEvento"})
public class RegistroController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //   processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            request.getSession().removeAttribute("message");
            request.getParameter("");
            
            EventoService eventoService = new EventosServiceImpl();
            Evento evento = new Evento();
            evento.setNombre(request.getParameter("nombre"));
            evento.setUbicacion(request.getParameter("ubicacion"));
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            evento.setFecha(sdf.parse(request.getParameter("fecha")));
            
            eventoService.registrarEvento(evento);
             request.getSession().setAttribute("message", "Registrado");
             
            response.sendRedirect("registroEvento");
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("message", e.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
