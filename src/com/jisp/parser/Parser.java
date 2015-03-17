package com.jisp.parser;

import com.jisp.exceptions.SyntaxException;
import com.jisp.parser.Tokenizer.Token;


import java.util.ArrayList;

public class Parser {

    public Parser() {
    }

    //public static ArrayList<Object> parse(ArrayList<Token> tokens){
    public static Object parse(Object obj) {
        System.out.println("OBJECT : " + obj.toString());
        ArrayList<Object> returnList = new ArrayList<Object>();
        try {
            if (obj == null) {
                throw new SyntaxException("Empty List -> Unbalanced Expression.");
            }
            if (obj instanceof ArrayList && ((ArrayList)obj).size() == 1) {
                return ((ArrayList)obj).remove(0);
            }
            if (obj instanceof ArrayList && ((ArrayList)obj).size() == 0) {
                //todo  : create a NIL object to return here instead of a null Object
                return new Object();
            }
            ArrayList<Token> tokens = (ArrayList<Token>) obj;
            if (tokens.size() == 1){
                return tokens.remove(0);
            }
            Token token = tokens.remove(0); // POP
//            System.out.println("Token (outer) -> " + token.toString());
            //Open Paren
            if (token.getType() == Token.TokenType.OPEN_PAREN) {
                System.out.println("# OPEN PAREN 8----> " + token.toString());
                ArrayList expr = new ArrayList<Object>();
                // Read until closing Paren
                //token = tokens.remove(0); // POP
                while (token.getType() != Token.TokenType.CLOSE_PAREN) {
                    token = tokens.remove(0); // POP
                    System.out.println("Token (inner) -> " + token.toString());
                    expr.add(parse(tokens));
                }
                return expr;
            } else if (token.getType() == Token.TokenType.CLOSE_PAREN) {
                System.out.println("# INCORRECTLY NESTED CLOSE PAREN 8----> " + token.toString());
            } else {
                System.out.println("# SYMBOL / NUMBER 8----> " + token.toString());
                return token;
            }
        } catch (SyntaxException ex) {
            System.out.println(ex.toString());
        }
        return returnList;
    }
}
