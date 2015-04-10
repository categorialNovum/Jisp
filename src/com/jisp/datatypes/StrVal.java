package com.jisp.datatypes;

public class StrVal extends Value{
    String data;

    public StrVal(String s){
        data = s;
    }

    public String getVal(){
       return data;
    }

}
