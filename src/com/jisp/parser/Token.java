package com.jisp.parser;

/**
 * Created by jbeaumon on 2/25/15.
 */
public abstract class Token <T>{
    public T data;

    public Token(T t){
        data = t;
    }

    public String toString(){
        return data.toString();
    }
}
