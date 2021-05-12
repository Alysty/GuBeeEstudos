package com.web_services.projeto_web_services_secao25.services.exceptions;

public class DatabaseException  extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg){
        super(msg);
    }
}
