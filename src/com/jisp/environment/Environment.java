package com.jisp.environment;

import com.jisp.environment.StandardEnvironment;
import com.jisp.parser.Tokenizer.Token;
import java.util.HashMap;
import java.util.ArrayList;

public class Environment {
    StandardEnvironment stdEnv;
    private enum Expression{VAR,NUMBER,QUOTE,CONDITIONAL,DEFINITION,PROCEDURE_CALL}
    HashMap<String,Expression> fullEnv;

    public Environment(){
        stdEnv = new StandardEnvironment();
    }

    public void addToEnv(String s, Expression exp){
        fullEnv.put(s,exp);
    }

    public void eval(ArrayList<Token> l){
        Token t = l.get(0);
        switch(t.getType()){
            case SYMBOL:
            case NUMBER:
            case PAREN:
        }

    }
}
