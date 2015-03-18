package com.jisp;


import java.io.*;
import java.util.ArrayList;
import com.jisp.parser.Tokenizer.Tokenizer;
import com.jisp.parser.Tokenizer.Token;
import com.jisp.parser.Parser;

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
            Parser p = new Parser();
//            t.test();
            while (reader.ready()){
                line = reader.readLine();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("LINE : " + line);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                ArrayList<Token> tokens = t.tokenize(line);
                System.out.println("TOKENIZED : " + tokens);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                ArrayList<Object> parsed = (ArrayList<Object>)p.parse(tokens);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("PARSED (" + parsed.size() + ") : " + parsed);

                for(Object o : parsed){
                    System.out.println("% : " + o.toString());
                }
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("--> Finished <--");
        }catch (FileNotFoundException ex){
            System.out.println("JiSP file not found. exiting");
        }catch (IOException ex){
            System.out.println("IO exception");
        }
    }
}
