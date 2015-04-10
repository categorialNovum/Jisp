package com.jisp.datatypes;

public class NumVal extends Value{
    Integer data;

    public NumVal(Integer n){
        data = n;
    }
    public NumVal(Double n){
        data = n.intValue();
    }

    public Integer getData(){
        return data;
    }
}
