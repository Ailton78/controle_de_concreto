package com.parasistema.controle_de_concreto.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public  ResourceNotFoundException(String msg){
        super(msg);
    }
}
