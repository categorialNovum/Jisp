package com.jisp.parser.Tokens;

public  interface Token <T>{
    public enum TokenType {NUMBER, SYMBOL, OPEN_PAREN, CLOSE_PAREN, QUOTE, CONDITIONAL,DEFINE}

    public String toString();

    public String getTypeStr();

    public TokenType getType();
}
