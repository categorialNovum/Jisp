package com.jisp.environment;

/**
 * Created by u0133933 on 3/9/2015.
 */
public class StandardEnvironment {
    //Trailing _P denotes a predicate ; EQ? -> EQ_P
    public enum StandardOps{PLUS, GT, ABS, APPEND, APPLY, BEGIN, CAR, CDR, CONS, EQ_P, EQUAL_P, LENGTH, LIST, LIST_P,
                            MAP, MAX, MIN, NOT, NULL_P, NUMBER_P, PROCEDURE_P, ROUND, SYMBOL_P}

    public static Boolean isStdOp(String s){
        // convert token to uppercase, convert ? to _P for predicates
        String token = s.toUpperCase().replace("?", "_P");
        for (StandardOps op : StandardOps.values()){
            if (token.equals(op.toString()));
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
