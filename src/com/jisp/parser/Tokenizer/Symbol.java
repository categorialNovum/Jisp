package com.jisp.parser.Tokenizer;

/**
 * Created by jbeaumon on 3/7/15.
 */
public class Symbol implements Token {
    String data;

    public Symbol(String s){
        setData(s);
    }

    public void setData(String s){
        data = s;
    }

    public String getTypeStr(){
        return TokenType.SYMBOL.toString();
    }

    public TokenType getType(){
        return TokenType.SYMBOL;
    }

    public String toString(){
        return data;
    }

}
