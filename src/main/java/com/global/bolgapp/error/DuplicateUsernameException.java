package com.global.bolgapp.error;

public class DuplicateUsernameException extends RuntimeException{
    
    public DuplicateUsernameException(){
        super();
    }
    
    public DuplicateUsernameException(String message){
        super(message);
    }

}
