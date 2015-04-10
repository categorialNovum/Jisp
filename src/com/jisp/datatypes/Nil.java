package com.jisp.datatypes;

public class Nil extends Value{
    String data;
    Nil(){
        data = "nil";
    }
    public String getData(){return data;}
}
