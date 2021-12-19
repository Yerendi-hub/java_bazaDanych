package com.company.dbExceptions;

public class DatabaseAlreadyExistException extends Exception {
    public DatabaseAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
