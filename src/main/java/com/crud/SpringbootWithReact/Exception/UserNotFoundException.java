package com.crud.SpringbootWithReact.Exception;

public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException(Long id){
        super("Could not find the id"+id);
    }
}
