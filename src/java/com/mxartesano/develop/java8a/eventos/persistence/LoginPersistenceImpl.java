/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mxartesano.develop.java8a.eventos.persistence;

import com.mxartesano.develop.java8a.eventos.model.Login;

/**
 *
 * @author igarcia
 */
public class LoginPersistenceImpl implements LoginPersistence{

    @Override
    public boolean existeLogin(Login login) throws Exception {
        return false;
    }
    
}
