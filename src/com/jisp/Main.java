package com.jisp;


import java.io.*;
import com.jisp.parser.Tokenizer.Tokenizer;
import java.util.List;

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
            String alphanumeric = "ABCdefghigkj456";
            String decimal = "123.456";
            String alphaOnly = "ABCDefgHIjklmnOPQRSTUVwxyZ";
            String numberOnly = "0123456789";
            String jibberish = "fansbdfjeklr32520958u*&(^&%&^*53892)))(*89afssd,afnehrw";
            String codeString = "(+ (- 20033 1478) (* 2 (+ 4 9)))";
            Tokenizer t = new Tokenizer();
            while (reader.ready()){
                line = reader.readLine();
                System.out.println(line);
            }
            System.out.println ("-------------------------------------------");
            System.out.println("Test String : " + alphanumeric);
            System.out.println ("-------------------------------------------");
            t.testRegex(alphanumeric);
            System.out.println ("-------------------------------------------");
            System.out.println("Test String : " + decimal);
            System.out.println ("-------------------------------------------");
            t.testRegex(decimal);
            System.out.println ("-------------------------------------------");
            System.out.println("Test String : " + line);
            System.out.println ("-------------------------------------------");
            t.testRegex(line);
            System.out.println("--> Finished <--");
        }catch (FileNotFoundException ex){
            System.out.println("JiSP file not found. exiting");
        }catch (IOException ex){
            System.out.println("IO exception");
        }
    }
}
