package com.jisp;


import java.io.*;
import java.util.ArrayList;
import com.jisp.parser.Tokenizer.Tokenizer;
import com.jisp.parser.Tokenizer.Token;

public class Main {

    public static void main(String[] args) {
	    if (args.length < 1){
            System.out.println("Requires a JiSP file as input. Exiting");
            System.exit(0);
        }
        try {
            FileReader input = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(input);
            String line = "";
            Tokenizer t = new Tokenizer();
//            t.test();
            while (reader.ready()){
                line = reader.readLine();
                System.out.println("LINE : " + line);
                ArrayList<Token> tokens = t.tokenize(line);
                for (Token token : tokens){
                    System.out.println(token.getType() + " : " + token.toString());
                }
            }
            System.out.println("--> Finished <--");
        }catch (FileNotFoundException ex){
            System.out.println("JiSP file not found. exiting");
        }catch (IOException ex){
            System.out.println("IO exception");
        }
    }
}
