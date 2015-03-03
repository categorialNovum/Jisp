package com.jisp.parser;

import com.jisp.parser.Token;
import java.util.List;

import java.util.Arrays;

/**
 * Created by jbeaumon on 2/25/15.
 */
public class Tokenizer {
    public static List<String> tokenize(String line){
        String[] strTokens = line.split(" ");
        List<String> tokens = Arrays.asList(strTokens);
        return tokens;
    }

    public static List<Token> makeTokens(String line){
        String[]strTokens = line.split(" ");
        List<Token<String>> tokens;
        tokens = new List<Token<String>>();
        for (String s : strTokens){
            Token <String> t = new Token(s);
            tokens.add(t);
        }
        return tokens;
    }
}
