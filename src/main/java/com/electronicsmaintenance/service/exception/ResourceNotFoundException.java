package com.electronicsmaintenance.service.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {
        super("Serviço não encontrado ou inexistente.");
    }

    public ResourceNotFoundException(Throwable cause) {
        super("Serviço não encontrado ou inexistente.", cause);
    }
}
