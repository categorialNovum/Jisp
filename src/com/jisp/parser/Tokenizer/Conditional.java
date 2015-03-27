package com.jisp.parser.Tokenizer;

public class Conditional implements Token{

    String data;

    Conditional(String s) {
            setData(s);
    }

    public void setData(String s) {
        data = s;
    }

    public String getTypeStr() {
        return TokenType.CONDITIONAL.toString();
    }

    public TokenType getType() {
        return TokenType.CONDITIONAL;
    }

    public String toString() {
        return data;
    }
}
