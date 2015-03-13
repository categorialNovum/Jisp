package com.jisp.parser.Tokenizer;

public class DoubleNum implements Token{
    Double data;

    public DoubleNum(String s){
        setData(s);
    }

    public void setData(String s){
        data = Double.parseDouble(s);
    }

    public String toString(){
        return data.toString();
    }

    public Double toDouble(){
        return data;
    }

    public Integer toInt(){
        return data.intValue();
    }

    public String getTypeStr(){
        return Token.TokenType.NUMBER.toString();
    }

    public TokenType getType(){
        return Token.TokenType.NUMBER;
    }
}

