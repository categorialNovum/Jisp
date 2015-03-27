package com.jisp.environment;

import com.jisp.environment.StandardEnvironment;
import com.jisp.parser.Tokenizer.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Environment {
    StandardEnvironment stdEnv;
    private enum Expression{VAR,NUMBER,QUOTE,CONDITIONAL,DEFINITION,PROCEDURE_CALL}
    //HashMap<String,Expression> fullEnv;
    HashMap<String,Object> fullEnv;

    public Environment(){
        stdEnv = new StandardEnvironment();
        fullEnv = new HashMap<String,Object>();
        fullEnv.put("+", "PLUS");
    }

    public Object eval(ArrayList<Object> l){
        if (l.size() == 0){return null;}
        Object o = l.remove(0); // Pop
        if (o instanceof Symbol){
            return fullEnv.get(o);
        }else if(! (o instanceof ArrayList)){
            return o;
        }else if(o instanceof ArrayList){
            ArrayList<Object> lst = (ArrayList<Object>)o;
            Token t = (Token)lst.remove(0);
            if (t instanceof Quote){
                return lst.remove(0);
            }else if(t instanceof Conditional){
                Object test = lst.remove(0);
                Object consequence = lst.remove(0);
                Object alternative = lst.remove(0);
            }else if (t instanceof Define){
                String var = lst.get(0).toString();
                ArrayList exp = (ArrayList)lst.get(0);
                fullEnv.put(var,eval(exp));
            }
        }
        return o;
    }
}
