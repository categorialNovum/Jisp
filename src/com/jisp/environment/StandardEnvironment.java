package com.jisp.environment;

import java.util.ArrayList;
import com.jisp.parser.Tokenizer.Token;
import com.jisp.parser.Tokenizer.Tokenizer;

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

    public static Integer add(Integer a, Integer b){
       return a + b;
    }

    public static Double add(Double a, Integer b){
        return a + b;
    }

    public static Double add(Integer a, Double b){
        return a + b;
    }

    public static Double add(Double a, Double b){
        return a + b;
    }

    public static Integer subtract(Integer a, Integer b){
        return a - b;
    }

    public static Double subtract(Double a, Integer b){
        return a - b;
    }

    public static Double subtract(Integer a, Double b){
        return a - b;
    }

    public static Double subtract(Double a, Double b){
        return a - b;
    }

    public static Integer abs(Integer i){
        return Math.abs(i);
    }

    public static Double abs(Double d){
        return Math.abs(d);
    }

    public static Boolean list_p(Object o){
        System.out.println("Object Type : " + o.getClass().toString());
        return (o instanceof ArrayList);
    }

    public static Token car(ArrayList<Token> list){
        return list.get(0);
    }

    public static ArrayList<Token> cdr(ArrayList<Token> l){
        int len = l.size();
        if (len <= 1){
            return new ArrayList<Token>();
        }
        return (ArrayList<Token>)l.remove(0);
    }

    public static void main (String[] args){
        StandardEnvironment env = new StandardEnvironment();
        ArrayList<Token> list = new ArrayList<Token>();
        Tokenizer t = new Tokenizer();
        String codeStr = t.codeString;
        ArrayList<Token> tokens = t.tokenize(codeStr);
        Integer i = 44;
        Double d = 17.896;
        Boolean isList = env.list_p(list);
        System.out.println("IsList? : " + list.toString() + " -> " + env.list_p(list));
        System.out.println("IsList? : " + i.toString() + " -> " + env.list_p(i));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") + I(" + i.toString() + ") :  -> " + env.add(i,i));
        System.out.println("I(" + i.toString() + ") + D(" + d.toString() + ") :  -> " + env.add(i, d));
        System.out.println("D(" + d.toString() + ") + I(" + i.toString() + ") :  -> " + env.add(d, i));
        System.out.println("D(" + d.toString() + ") + D(" + d.toString() + ") :  -> " + env.add(d,d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("I(" + i.toString() + ") - I(" + i.toString() + ") :  -> " + env.subtract(i, i));
        System.out.println("I(" + i.toString() + ") - D(" + d.toString() + ") :  -> " + env.subtract(i, d));
        System.out.println("D(" + d.toString() + ") - I(" + i.toString() + ") :  -> " + env.subtract(d, i));
        System.out.println("D(" + d.toString() + ") - D(" + d.toString() + ") :  -> " + env.subtract(d, d));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println(codeStr);
        System.out.println("-------------------------------------------------------------------------------------");
        for (Token tok : tokens){
            System.out.println(tok.toString());
        }
    }
}
