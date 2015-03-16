package com.jisp.environment;

import com.jisp.environment.StandardEnvironment;
import com.jisp.parser.Tokenizer.Symbol;
import com.jisp.parser.Tokenizer.Token;
import java.util.HashMap;
import java.util.ArrayList;

public class Environment {
    StandardEnvironment stdEnv;
    private enum Expression{VAR,NUMBER,QUOTE,CONDITIONAL,DEFINITION,PROCEDURE_CALL}
    //HashMap<String,Expression> fullEnv;
    HashMap<String,String> fullEnv;

    public Environment(){
        stdEnv = new StandardEnvironment();
        fullEnv.put("+", "PLUS");
    }

    public Object eval(ArrayList<Object> l){
        if (l.size() == 0){return null;}
        Object o = l.get(0);
        if (o instanceof Symbol){
            //todo : return mapped value.
            // figure out best way to map to functions
        }else if(o instanceof ArrayList){
            ArrayList currentList = (ArrayList)o;
            Object currentObj = currentList.get(0);

            //handle quote

            //handle conditional

            //handle define

            //else -> recursive call to eval


        }

        return o;
    }
}
