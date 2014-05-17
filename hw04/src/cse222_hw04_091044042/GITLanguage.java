/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse222_hw04_091044042;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


/**
 *
 * @author AAnılApaydın
 */
public class GITLanguage {
    /* Member initilize */
    private List<String> Lines = new LinkedList<String>();
    private List<Variable> Variables = new LinkedList<Variable>();
    private String resultText = new String();
    /* Variable inner class */
    private class Variable {

        Double value = null;
        String name = null;
        String type = null;
    }
    /* One parameter constructor */
    public GITLanguage(String input){
        
        if(input == null){
            System.err.println("Invalid input file!");
            System.exit(1);
        }
        else{
            lineSeparator(input);
            System.out.println(readFile(input));
            System.out.println("After reading and calculation:\n");
            
            for (int i = 0; i < Lines.size(); ++i) {

                if (isVariable(Lines.get(i))) {} 
                else if (isInput(Lines.get(i))) {}
                else if (isCalculate(Lines.get(i))) {} 
                else if (isPrint(Lines.get(i))) {} 
                else {
                    break;
                }
            } 
            System.out.println(resultText);
        }
    }
    /* Add new lin e between lines */
    private void lineSeparator(String fileName) {
        
        StringTokenizer separator = new StringTokenizer(readFile(fileName));

        while (separator.hasMoreTokens()) {
            Lines.add(separator.nextToken("\n"));
        }
    }
    /* is Variables definition line method */
    private boolean isVariable(String line) {
       StringTokenizer separator = new StringTokenizer(line);
       String word = null;
       
       word = separator.nextToken();
       Variable var = new Variable();
       
       if(word.equals("var")){
           word = separator.nextToken();
           if (varContain(word)) {
               System.err.println("Variable is defined:" + word );
                    return false;
           }
           else{
               var.name = word;
               var.type = "var";
               Variables.add(var);
               return true;
           }
       }
       else
          return false;
    }
    /* is Print line method */
    private boolean isPrint(String line) {
        StringTokenizer separator = new StringTokenizer(line);
        String word = null ;
        double value = 0.0;
        
        word = separator.nextToken();
        
        if(word.equals("print")){
            word = separator.nextToken();
            if(!varContain(word)){
                System.err.println("Undefined Variable :" + word);
            }
            else{
                int index = getVarIndex(word);
                if (Variables.get(index).value == null)
                    System.err.println("Uninitialized Variable :" + word);
                else
                    resultText += Variables.get(index).value + "\n";
            }
            return true;
        }  
        
        return false;
    }
    /* is Calculate line method */
    private boolean isCalculate(String line) {
        
        StringTokenizer separator = new StringTokenizer(line);
        String word = null;
        
        word = separator.nextToken();
        if (word.equals("=")) {
            System.err.println( "No LValue \n");
            return false;
        }
        
        if(!varContain(word) && !word.equals("print")){
            System.err.println("Undefined Variable :" + word);
        }
        else if(varContain(word) && !word.equals("print")){
            int index = getVarIndex(word);
            word = separator.nextToken();
            if (!word.equals("=")) {
                System.err.println("No assigment operator\n");
                return false;
            }
            else{
                word = separator.nextToken("\n");
                Variables.get(index).value = calculateLine(word);
            }
            return true;
        }
        
        return false;
    }
    /* Calculate line assistant method */
    private Double calculateLine(String word){
        
        PostfixEvaluate Calculator = new PostfixEvaluate();
        InfixToPostfixParens inToPost = new InfixToPostfixParens(); 
        double result = 0;
        String postFix = null; 
        
        
        try{
            postFix = inToPost.convert(word);
        } catch(InfixToPostfixParens.SyntaxErrorException e){
            System.err.println(e.getMessage());
            return null;
        }
          
        postFix = calculateVars(postFix);
        if (postFix == null) 
            return null;
        else 
            result = Calculator.eval(postFix);
        
        return result;   
    }
    /* calculate line main calculation method */
    private String calculateVars(String postFix) {
        
        StringTokenizer separator = new StringTokenizer(postFix);
        StringBuilder calculation = new StringBuilder();
        String temp = null;
        String word = null;
        String uniaryNext = null;
        int index;
        
        
        while (separator.hasMoreTokens()) {
            word = separator.nextToken();
            
            if (Character.isLetter(word.charAt(0))){
            
                if(isUniaryOperator(word)){
                    uniaryNext = separator.nextToken();
                    temp = calculateVars(uniaryNext);
                    if(temp == null){
                        System.err.append("Error in uniary variable" + uniaryNext);
                        return null;
                    }
                    else{
                        calculation.append(calculateUniaryExp(word,temp));
                        calculation.append(" ");
                    }
                }
                else{
                
                    for (index = 0; index < Variables.size(); ++index) {
                        if (word.equals(Variables.get(index).name)) {
                            temp = Variables.get(index).value.toString();
                            break;
                        }
                    }

                    if (temp != null) { 
                        if (Variables.get(index).value == null) {
                            System.err.println("Uninitialized Variable :" + word);
                            return null;
                        } 
                        else {
                            calculation.append(temp);
                            calculation.append(" ");
                        }
                    } 
                    else { 
                        System.err.println("Undefined Variable :" + word);
                        return null;
                    }
                }
            }
            else { // is number
                calculation.append(word);
                calculation.append(" ");
            }   
                
        }
        return calculation.toString();
    }
    /* CAlculate uniary op method */
    private String calculateUniaryExp(String word, String uniaryNext) {
        Double temp;
        int index = 0;
        boolean isLetterFlag;
        uniaryNext = uniaryNext.replace(" ", "");
        
        if(Character.isLetter(uniaryNext.charAt(0)))
        {
            for(int i = 0 ; i < Variables.size() ; ++i){
                if(uniaryNext.equals(Variables.get(i).value.toString())){
                    index = i;
                    break;
                }
            }
            isLetterFlag = true;
        }
        else{
            isLetterFlag = false;
        }
        
        
        switch(word){
            case "sin":
                if(isLetterFlag)
                    temp = Math.sin((Variables.get(index).value)*(Math.PI / 180.0));
                else
                    temp = Math.sin(Double.parseDouble(uniaryNext)*(Math.PI / 180.0));
                return temp.toString();
            case "cos":
                if(isLetterFlag)
                    temp = Math.cos((Variables.get(index).value)*(Math.PI / 180.0));
                else
                    temp = Math.cos(Double.parseDouble(uniaryNext)*(Math.PI / 180.0));
                return temp.toString();
            case "sqrt":
                if(isLetterFlag)
                    temp = Math.sqrt(Variables.get(index).value);
                else
                    temp = Math.sqrt(Double.parseDouble(uniaryNext));
                return temp.toString();
            case "log":
                if(isLetterFlag)
                    temp = Math.log10(Variables.get(index).value);
                else
                    temp = Math.log10(Double.parseDouble(uniaryNext));
                return temp.toString();
            case "abs":
                if(isLetterFlag)
                    temp = Math.abs(Variables.get(index).value);
                else
                    temp = Math.abs(Double.parseDouble(uniaryNext));
                return temp.toString();
            case "tan":
                if(isLetterFlag)
                    temp = Math.tan((Variables.get(index).value)*(Math.PI / 180.0));
                else
                    temp = Math.tan(Double.parseDouble(uniaryNext)*(Math.PI / 180.0));
                return temp.toString();
            case "exp":
                if(isLetterFlag)
                    temp = Math.exp(Variables.get(index).value);
                else
                    temp = Math.exp(Double.parseDouble(uniaryNext));
                return temp.toString();
            default:
                return null;
        }
    }
    /* uniary op control method */
    private boolean isUniaryOperator(String word) {
        switch(word){
            case "sin":
            case "cos":
            case "sqrt":
            case "log":
            case "abs":
            case "tan":
            case "exp":
                return true; 
            default:
                return false;
        }
    }
    
    private boolean isInput(String line) {
        StringTokenizer separator = new StringTokenizer(line);
        String word = null;
        String temp = null;
        
        word = separator.nextToken();  
        if(word.equals("input")){
            temp = separator.nextToken();
            if(!varContain(temp)){
                System.err.println("Undefined Variable :" + temp);
            }
            else{
                int index = getVarIndex(temp);
                Variables.get(index).value = Double.parseDouble( JOptionPane.showInputDialog( 
                                                                 "Enter a number for " + temp +":") );
            }
            return true;
        }
        return false;
    }
    /* is variable defined before */
    private boolean varContain(String varName) {

        for (int i = 0; i < Variables.size(); ++i) {
            if (varName.equals(Variables.get(i).name)) {
                return true;
            }
        }

        return false;
    }
    /* get variable's defined value */
    private int getVarIndex(String varName) {

        int i;
        
        for (i = 0; i < Variables.size(); ++i) {
            if (varName.equals(Variables.get(i).name)) {
                return i;
            }
        }
        
        return i;
    }
    /* Scan file assign lines */
    private String readFile(String fileName){
    
        File file = new File(fileName);
        Scanner Reader = null;
        try {
            Reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("File is not exist: " 
                                  + fileName );
            return null;
        }
    
        StringBuilder strBuild = new StringBuilder();

        while (Reader.hasNext()) {
            String line = Reader.nextLine();
            strBuild.append(line);
            strBuild.append("\n");
        }

        return strBuild.toString();
    
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GITLanguage prog;
        Integer selection = Integer.parseInt(JOptionPane.showInputDialog( 
                           "Enter a number for input file:"
                                   + "\n1 for program.git\n2 for program2.git\n .\n .\n .") );
        
        
        switch(selection){
            
            case 1:
                prog = new GITLanguage("program.git");
            break;
            case 2:
                prog = new GITLanguage("program2.git");
            break;
            case 3:
                prog = new GITLanguage("program3.git");
            break;
            case 4:
                prog = new GITLanguage("program4.git");
            break;
            case 5:
                prog = new GITLanguage("program5.git");
            break;    
            default:
                prog = new GITLanguage(null);
            break;
        };

        System.exit(0);
        
    }
    
}
