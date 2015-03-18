package com.jisp.parser;

import com.jisp.exceptions.SyntaxException;
import com.jisp.parser.Tokenizer.Token;


import java.util.ArrayList;

public class Parser {

    public Parser() {
    }

    public static Object parse(ArrayList<Token> tokens) {
        //System.out.println("TOKENS 1 : " + tokens.toString());
        //ArrayList<Object> returnList = new ArrayList<Object>();
        //try {
           /* if (tokens.size() == 0) {
                throw new SyntaxException("Empty List -> Unbalanced Expression.");
            }*/
            if (tokens.size() == 1){
                //System.out.println("# TOKENS SIZE == 1 : 8----> " + tokens.toString());
                return tokens.get(0);
            }
            Token token = tokens.remove(0); // POP
            //System.out.println("# TOP POP 8----> " + token.toString());
            //System.out.println("TOKENS 2 : " + tokens.toString());
            //Open Paren
            if (token.getType() == Token.TokenType.OPEN_PAREN) {
                //System.out.println("# OPEN PAREN SEEN ");
                ArrayList expr = new ArrayList<Object>();
                token = tokens.get(0); // POP
                //System.out.println("TOKENS 3 : " + tokens.toString());
                // Read until closing Paren
                while (tokens.size() >=1 && tokens.get(0).getType() != Token.TokenType.CLOSE_PAREN) {
                 //   System.out.println("Token (while) -> " + token.toString());
                  //  System.out.println("TOKENS 4 : " + tokens.toString());
                    expr.add(parse(tokens));
                   // System.out.println("TOKENS 4.5 : " + tokens.toString());
                }
                return expr;
            } else if (token.getType() == Token.TokenType.CLOSE_PAREN) {
                System.out.println("# INCORRECTLY NESTED CLOSE PAREN 8----> " + token.toString());
            }
            //} else {
                System.out.println("***** ATOMIC SYMBOL / NUMBER -->  [" + token.toString() + "]");
             return token;
            //}
        /*} catch (SyntaxException ex) {
            System.out.println(ex.toString());
        }*/
        //return returnList;
    }
}
