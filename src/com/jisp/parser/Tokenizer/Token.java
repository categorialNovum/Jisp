package com.jisp.parser.Tokenizer;

public  interface Token <T>{
    public enum TokenType {NUMBER, SYMBOL, OPEN_PAREN, CLOSE_PAREN}

    public String toString();

    public String getTypeStr();

    public TokenType getType();
}
