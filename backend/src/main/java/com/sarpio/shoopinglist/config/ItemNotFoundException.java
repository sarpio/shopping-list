package com.sarpio.shoopinglist.config;

/**
 * @author Piotr Sarnecki
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message){
        super(message);
    }
}
