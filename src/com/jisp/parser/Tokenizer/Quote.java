package com.jisp.parser.Tokenizer;

import com.jisp.exceptions.TokenException;
import com.jisp.parser.Tokenizer.Token;

public class Quote implements Token{
    String data;

    Quote(String s) {
        try {
            if (s.toUpperCase().equals("QUOTE") || s.equals("'")) {
                setData(s);
            }else {
                throw new TokenException();
            }

        } catch (TokenException ex) {
            System.out.println("Exception while parsing QUOTE : " + ex.toString());
        }
    }

    public void setData(String s) {
        data = s;
    }

    public String getTypeStr() {
        return TokenType.QUOTE.toString();
    }

    public TokenType getType() {
        return TokenType.QUOTE;
    }

    public String toString() {
        return data;
    }
}