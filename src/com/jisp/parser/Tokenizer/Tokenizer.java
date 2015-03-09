package com.jisp.parser.Tokenizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private enum matchType{DIGIT,DOUBLE,OPERATOR,DOT,ALPHA,PAREN}
    private Pattern intMatch = Pattern.compile("\\d");
    private Pattern doubleMatch = Pattern.compile("[0-9\\.]");
    private Pattern operatorMatch = Pattern.compile("[%*-+/]");
    private Pattern dotMatch = Pattern.compile("[\\.]");
    private Pattern alphaMatch = Pattern.compile("[A-z]");
    private Pattern parenMatch = Pattern.compile("\\(|\\)");

    // Test strings for regex
    final static String alphanumeric = "ABCdefghigkj456";
    final static String decimal = "123.456";
    final static String alphaOnly = "ABCDefgHIjklmnOPQRSTUVwxyZ";
    final static String numberOnly = "0123456789";
    final static String jibberish = "fansbdfjeklr32520958u*&(^&%&^*53892)))(*89afssd,afnehrw";
    final static String codeString = "(+ (- 20033 1478) (* 2 (+ 4 9)))";

    private void dumpMatcher(Matcher m){
            System.out.println("Group Count : " + m.groupCount());
            System.out.println("Start : " + m.start());
            System.out.println("End : " + m.end());
            System.out.println("Group : " + m.group());
    }

    private ArrayList<Matcher> matchAll(String s){
        Matcher intResults = intMatch.matcher(s);
        Matcher doubleResults = doubleMatch.matcher(s);
        Matcher alphaResults = alphaMatch.matcher(s);
        Matcher parenResults = parenMatch.matcher(s);
        Matcher dotResults = dotMatch.matcher(s);
        Matcher operatorResults = operatorMatch.matcher(s);
        ArrayList<Matcher> matchList = new ArrayList<Matcher>();
        matchList.add(intResults);
        matchList.add(doubleResults);
        matchList.add(alphaResults);
        matchList.add(parenResults);
        matchList.add(operatorResults);
        matchList.add(dotResults);
        return matchList;
    }

    public void test(){
        System.out.println ("-------------------------------------------");
        System.out.println("Test String : " + alphanumeric);
        System.out.println ("-------------------------------------------");
        testRegex(alphanumeric);
        System.out.println ("-------------------------------------------");
        System.out.println("Test String : " + decimal);
        System.out.println ("-------------------------------------------");
        testRegex(decimal);
        System.out.println ("-------------------------------------------");
        System.out.println("Test String : " + codeString);
        System.out.println ("-------------------------------------------");
        testRegex(codeString);
        System.out.println ("-------------------------------------------");
    }



    private HashMap<String,Boolean> matchAllMap(String s){
        Matcher intResults = intMatch.matcher(s);
        Matcher doubleResults = doubleMatch.matcher(s);
        Matcher alphaResults = alphaMatch.matcher(s);
        Matcher parenResults = parenMatch.matcher(s);
        Matcher dotResults = dotMatch.matcher(s);
        Matcher operatorResults = operatorMatch.matcher(s);
        HashMap<String,Boolean> matchMap = new HashMap<String,Boolean>();
        matchMap.put(matchType.DIGIT.toString(), intResults.find());
        matchMap.put(matchType.DOUBLE.toString(), doubleResults.find());
        matchMap.put(matchType.ALPHA.toString(), alphaResults.find());
        matchMap.put(matchType.PAREN.toString(), parenResults.find());
        matchMap.put(matchType.OPERATOR.toString(), operatorResults.find());
        matchMap.put(matchType.DOT.toString(), dotResults.find());
        return matchMap;
    }

    public void testRegex(String s){
        ArrayList<Matcher> matchers = matchAll(s);
        for (Matcher m : matchers){
            if (m.find()){
                System.out.println(m.toString());
                dumpMatcher(m);
            }else {
                System.out.println(m.toString());
            }
        }
    }

    public Token createToken(String s){
        HashMap<String,Boolean> matches = matchAllMap(s);
        if (matches.get(matchType.PAREN.toString())){
            return new Paren(s);
        }
        else if (matches.get(matchType.DIGIT.toString())
                && !matches.get(matchType.ALPHA.toString())
                && !matches.get(matchType.OPERATOR.toString())
                && !matches.get(matchType.DOT.toString())) {
            return new IntNum(s);
        }
        else if (matches.get(matchType.DOUBLE.toString())
                && matches.get(matchType.DOT.toString())
                && !matches.get(matchType.ALPHA.toString())
                && !matches.get(matchType.OPERATOR.toString())){
            return new DoubleNum(s);
        }else {
            return new Symbol(s);
        }
    }

    // Split a string into pieces and create/return a list of tokens
    public ArrayList<Token> tokenize(String s){
        System.out.println("TOKENIZATION");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String[] items = s.replace("(", " ( ").replace(")", " ) ").split(" ");
        ArrayList<Token> tokens = new ArrayList<Token>();
        for (String item : items){
            if (item.equals(" ") || item.equals("")){
                continue;
            }
            System.out.println("--> " + item);
            tokens.add(createToken(item));
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return tokens;
    }
}
