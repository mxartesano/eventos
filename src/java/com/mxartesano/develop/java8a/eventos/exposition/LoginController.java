/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.exposition;

import com.mxartesano.develop.java8a.eventos.model.Evento;
import com.mxartesano.develop.java8a.eventos.model.Login;
import com.mxartesano.develop.java8a.eventos.service.EventoService;
import com.mxartesano.develop.java8a.eventos.service.EventosServiceImpl;
import com.mxartesano.develop.java8a.eventos.service.LoginService;
import com.mxartesano.develop.java8a.eventos.service.LoginServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author igarcia
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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
       
        
        response.sendRedirect("registro.jsp");
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
    @Override // redefinicion de metodo
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override //sobreescritura de metodo
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String correoElectronico = request.getParameter("email");
            String password = request.getParameter("password");
            
            Login login = new Login();
            login.setCorreoElectronico(correoElectronico);
            login.setPassword(password);
            
            LoginService loginService = new LoginServiceImpl();
            loginService.existeLogin(login);
            
            System.out.println("Login OK");
            
           
            EventoService eventoService = new EventosServiceImpl();
            List<Evento> eventos = eventoService.obtenerEventos();
            
            request.getSession().setAttribute("eventos", eventos);
            response.sendRedirect("eventos.jsp");
            
            
        } catch (Exception e) {
            request.setAttribute("loginError", e.getMessage());
            response.sendRedirect("index.jsp");
            e.printStackTrace();
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
