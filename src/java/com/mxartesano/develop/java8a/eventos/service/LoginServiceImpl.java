/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.service;

import com.mxartesano.develop.java8a.eventos.model.Login;
import com.mxartesano.develop.java8a.eventos.persistence.LoginPersistence;
import com.mxartesano.develop.java8a.eventos.persistence.LoginPersistenceImpl;

/**
 *
 * @author igarcia
 */
public class LoginServiceImpl implements LoginService{
    private LoginPersistence loginPersistence;

    public LoginServiceImpl() {
        loginPersistence = new LoginPersistenceImpl();
    }
    
    

    /**
     * Si existe no pasa nada
     * Si no existe lanza Exception
     * @param login
     * @throws Exception 
     */
    @Override
    public void existeLogin(Login login) throws Exception {
        
        if(login != null && login.getCorreoElectronico() != null &&
                !login.getCorreoElectronico().isEmpty() &&
                login.getPassword() != null && !login.getPassword().isEmpty())
        {
            boolean respuesta = loginPersistence.existeLogin(login);
            
            if(respuesta == false){
                throw new Exception("Usuario incorrecto");
            }
            
        }else{
            throw new Exception("Datos incorrectos");
        }
        
    }
    
}
