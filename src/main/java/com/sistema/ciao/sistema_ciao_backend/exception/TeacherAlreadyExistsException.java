package com.sistema.ciao.sistema_ciao_backend.exception;

public class TeacherAlreadyExistsException extends RuntimeException{
    public TeacherAlreadyExistsException(String message) {
        super(message);
    }
}