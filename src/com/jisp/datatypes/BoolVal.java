package com.jisp.datatypes;

public class BoolVal {
    String data;
    BoolVal(Boolean b){
        if (b){
            data = "#t";
        }else{
            data = "#f";
        }
    }
    public String getVal(){return data;}
}
