package com.jisp.parser.Tokenizer;

import com.jisp.exceptions.TokenException;

public class Paren implements Token {
    String data;
    p_type paren_type;

    public enum p_type{OPEN, CLOSE}

    Paren(String s){
        try {
            setData(s);
            if (data.equals("(")) {
                paren_type = p_type.OPEN;
            } else if (data.equals(")")) {
                paren_type = p_type.CLOSE;
            }else{
                throw new TokenException();
            }

        }catch (TokenException ex){
            System.out.println("Exception while parsing paren : " + ex.toString());
        }
    }

    public void setData(String s){
        data = s;
    }

    public String getTypeStr(){
        return Token.TokenType.PAREN.toString();
    }

    public TokenType getType(){
        return Token.TokenType.PAREN;
    }

    public String toString(){
        return data;
    }
}
