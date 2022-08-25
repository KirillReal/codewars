package com.algorythms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackX {
    private int maxSize;
    private char[] chars;
    private int top;

    public StackX(int max) {
        maxSize = max;
        chars = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        chars[++top] = j;
    }

    public char pop() {
        return chars[top--];
    }

    public char peek() {
        return chars[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

class BracketChecker {
    private final String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length();
        StackX stackX = new StackX(stackSize);
        for(int j = 0; j < input.length();j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stackX.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stackX.isEmpty()) {
                        char chx = stackX.pop();
                        if((ch == '}' && chx != '{') || (ch == ']' && chx != '[')
                        || (ch == ')' && chx != '('))
                        System.out.println("Error: "+ch+" at "+j);
                    }
                    break;
                default:
                    break;
            }
        }
        if(!stackX.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}

class BracketApp {
    public static void main(String[] args) throws IOException {
        String input;
        while(true) {
            System.out.print(
                    "Enter string containing delimiters: ");
            System.out.flush();
            input = getString();
            if(input.equals("")){
                break;
            }
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();
        }

    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
