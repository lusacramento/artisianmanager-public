package br.com.artisianmanager.artisianmanager.domain.exception;

public class EntityNotModifiedException extends BusinessException {

    public EntityNotModifiedException(String message) {
        super(message);
    }
}
