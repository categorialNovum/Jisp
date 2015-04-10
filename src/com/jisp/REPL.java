package com.jisp;

import java.util.Scanner;
import com.jisp.datatypes.*;
import com.jisp.parser.Parser;
import com.jisp.parser.Tokens.Token;
import com.jisp.parser.Tokenizer.Tokenizer;

public class REPL {
    static Tokenizer tokenizer;

    private void init(){
        tokenizer = new Tokenizer();
    }

    public static Token[] read(Scanner in){
       return tokenizer.tokenize_array(in.nextLine());
    }

    public static Value eval(Token tokens[]){
        return tokens[0].getData();
    }

    public static void write(Value v){
        System.out.println(v.getVal().toString());
    }

    public static void main(String args[]){
        System.out.println("##################################################");
        System.out.println("JiSP REPL 1.0");
        System.out.println("##################################################");

        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("->");
            // READ -> EVAL -> PRINT
            write(eval(read(input)));
            System.out.print("\n");
        }
    }
}
