package br.com.artisianmanager.artisianmanager.domain.exception;

public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    BusinessException(String message){
        super(message);
    }
}
