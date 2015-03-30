package com.jisp.parser.Tokens;

public class Define implements Token {

    String data;

    public Define(String s) {
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
