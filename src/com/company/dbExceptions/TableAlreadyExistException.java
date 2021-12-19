package com.company.dbExceptions;

public class TableAlreadyExistException extends Exception
{
        public TableAlreadyExistException(String errorMessage) {
            super(errorMessage);
        }
}

