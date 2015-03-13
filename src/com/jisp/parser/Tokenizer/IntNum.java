package com.jisp.parser.Tokenizer;

/**
 * Created by jbeaumon on 3/7/15.
 */
public class IntNum implements Token, Number {
    Integer data;
    public IntNum(String s){
        setData(s);
    }

    public void setData(String s){
        data = Integer.parseInt(s);
    }

    public String toString(){
        return data.toString();
    }

    public Double toDouble(){
        return new Double(data);
    }

    public Integer toInt(){
        return data;
    }

    public String getTypeStr(){
        return Token.TokenType.NUMBER.toString();
    }

    public TokenType getType(){
        return Token.TokenType.NUMBER;
    }
}
