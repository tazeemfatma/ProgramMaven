package org.example;

import java.io.IOException;
import java.util.Stack;

public class CheckBalancedBrackets {
    public static void main(String[] args) throws IOException {
       String str="Hello(World)";
       int i;
       char c;
        Stack<Character> count=new Stack<>();
       for(i=0;i<str.length();i++){
           c=str.charAt(i);

           if(c=='('){
               count.push(c);
           }
           else if(c==')'){
               count.pop();
           }
       }

    }
}
