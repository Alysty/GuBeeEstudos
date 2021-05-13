package com.web_services.projeto_web_services_secao25.services.exceptions;


import com.web_services.projeto_web_services_secao25.entities.User;

public class ResouceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResouceNotFoundException(Object id){
        super("Resource not found. Id: " + id);
    }
}
