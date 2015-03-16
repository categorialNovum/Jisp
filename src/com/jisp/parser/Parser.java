package com.jisp.parser;

import com.jisp.exceptions.SyntaxException;
import com.jisp.parser.Tokenizer.Token;
import java.util.Iterator;

import java.util.ArrayList;

public class Parser {

   public Parser(){}

   public static ArrayList<Object> parse(ArrayList<Token> tokens){
      ArrayList<Object> returnList = new ArrayList<Object>();
      try{
         if (tokens.size() <= 0){
            throw new SyntaxException("Empty List -> Unbalanced Expression.");
         }
         Iterator<Token> it = tokens.iterator();
         Token token = null;
         while (it.hasNext()) {
            token = it.next();
            System.out.println("Token (outer) -> " + token.toString());
            if (token.getType() == Token.TokenType.PAREN && token.toString().equals("(")) {
               System.out.println("# OPEN PAREN 8----> " + token.toString());
               ArrayList expr = new ArrayList<Object>();
               Boolean keep_reading = Boolean.TRUE;
               while (keep_reading){
                  token = it.next();
                  System.out.println("Token (inner) -> " + token.toString());
                  if (token.getType() == Token.TokenType.PAREN && token.toString().equals(")")) {
                     System.out.println("# SYNTACTICALLY CORRECT CLOSE PAREN 8----> " + token.toString());
                     keep_reading = Boolean.FALSE;
                     returnList.add(expr);
                  }else{
                     System.out.println("Adding '" + token.toString() + "' to  expression");
                     expr.add(token);
                  }
               }
            }else if (token.getType() == Token.TokenType.PAREN && token.toString().equals(")")){
               System.out.println("# INCORRECTLY NESTED CLOSE PAREN 8----> " + token.toString());
            }else if (token.getType() == Token.TokenType.NUMBER){
               System.out.println("# NUMBER 8----> " + token.toString());
               returnList.add(token);
            }else{
               System.out.println("# SYMBOL 8----> " + token.toString());
               returnList.add(token);
            }
         }
      }catch (SyntaxException ex){
         System.out.println(ex.toString());
      }
      return returnList;
   }
}
