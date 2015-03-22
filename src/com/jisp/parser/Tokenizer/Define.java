package com.jisp.parser.Tokenizer;

import com.jisp.parser.Tokenizer.Token.TokenType;

public class Define implements Token{

    String data;

    Define(String s) {
        setData(s);
    }

    public void setData(String s) {
        data = s;
    }

    public String getTypeStr() {
        return TokenType.DEFINE.toString();
    }

    public TokenType getType() {
        return TokenType.DEFINE;
    }

    public String toString() {
        return data;
    }

}
