package com.jisp.parser.Tokens;

import com.jisp.utils.JispUtils;

public class Symbol implements Token {
    private String data;
    private Boolean isStdOp;

    public Symbol(String s){
        setData(s);
        isStdOp = JispUtils.isStdOp(s);
    }

    public void setData(String s){
        data = s;
    }

    public Boolean getIsStdOp(){return isStdOp;}

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
