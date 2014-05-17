package cse222_hw05_091044042;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Stack;
import java.util.StringTokenizer;

/** Class can evaluate a postfix expression
*   @author Koffman & Wolfgang
*/

public class PostfixEvaluate {

    private Stack stack;

     // Constructor
    public PostfixEvaluate() {
        stack = new Stack();
    }

    // Postfix Evulate
    public double eval(String expr) {
        
        stack = new Stack();
        double LValue, RValue, result = 0.0;
        String Word;
        StringTokenizer tokenizer = new StringTokenizer(expr);

        while (tokenizer.hasMoreTokens()) {
            Word = tokenizer.nextToken();
            
            if (isOperator(Word)) {
                RValue = ((Double) stack.pop()).doubleValue();
                LValue = ((Double) stack.pop()).doubleValue();
                result = evalOp(Word.charAt(0), LValue, RValue);
                stack.push(new Double(result));
            }
            else {
                stack.push(new Double(Double.parseDouble(Word)));
            }
        }

        result = ((Double) stack.pop()).doubleValue();
        return result;
    }

    // IsOperator
    private boolean isOperator(String token) {
        return (
            token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/"));
    }

    // Two value evulator
    private double evalOp(char operation, double LValue, double RValue) {
        double result = 0;

        switch (operation) {
            case '+' :
                result = LValue + RValue;
                break;
            case '-' :
                result = LValue - RValue;
                break;
            case '*' :
                result = LValue * RValue;
                break;
            case '/' :
                result = LValue / RValue;
                break;
        }
        
        return result;
    }

}