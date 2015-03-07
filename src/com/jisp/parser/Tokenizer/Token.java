package com.jisp.parser.Tokenizer;

/**
 * Created by jbeaumon on 2/25/15.
 */
public  interface Token <T>{
    public enum TokenType {NUMBER, SYMBOL, PAREN}
    //public static T data;

    //public Token(T t);

    public String toString();

    //public void setData();

    public String getType();
}
