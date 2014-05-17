package cse222_hw05_091044042;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAnılApaydın
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


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
            /* Main reading and calculating */
            lineSeparator(input);
            System.out.println(readFile(input));
            System.out.println("After reading and calculation:\n");
            
            int loopInserter = 0;
            
            for (int i = 0; i < Lines.size(); ++i) {

                if (isVariable(Lines.get(i),Variables)) {} 
                else if (isInput(Lines.get(i),Variables)) {}
                 
                else if (isPrint(Lines.get(i),Variables)) {} 
                else if (isLoop(Lines.get(i),Variables)) {
                      StringTokenizer separator = new StringTokenizer(Lines.get(i));
                      String word = null;
                      word = separator.nextToken();
                      word = separator.nextToken();
                      /* Run that loop and after finish insert it */ 
                      loopInserter = runLoops(Lines.get(i+1),i+1,getVarIndex(word,Variables),
                                                        Variables); 
                      if(loopInserter == 1){
                          System.exit(1);
                      }    
                      i += loopInserter;
                      loopInserter = 0;
                }
                else if (isCalculate(Lines.get(i),Variables)) {}
                else {
                    break;
                }
            } 
            System.out.println(resultText);
            
        }
    }
    /* Add new line between lines */
    private void lineSeparator(String fileName) {
        
        StringTokenizer separator = new StringTokenizer(readFile(fileName));

        while (separator.hasMoreTokens()) {
            Lines.add(separator.nextToken("\n"));
        }
    }
    /* is Variables definition line method */
    private boolean isVariable(String line,List<Variable> vars) {
       StringTokenizer separator = new StringTokenizer(line);
       String word = null;
       
       word = separator.nextToken();
       Variable var = new Variable();
       
       if(word.equals("var")){
           word = separator.nextToken();
           if (varContain(word,vars)) {
               System.err.println("Variable is defined:" + word );
                    return true;
           }
           else{
               var.name = word;
               var.type = "var";
               vars.add(var);
               return true;
           }
       }
       else
          return false;
    }
    
    /* Run loop or nested loops method */
    private int runLoops(String line,int beginLine,int loopCountIndex,List<Variable> vars) {
        StringTokenizer separator = new StringTokenizer(line);
        String word = null ;
        int count = 1;
        int beginEndEqu = 0;
        List<String> LoopLines = new LinkedList<String>();
        
        word = separator.nextToken();
        /* Run Loop's inside */
        if(word.equals("begin")){
            beginEndEqu = 1;
            /* Calculate that loop lines */
            while(beginEndEqu != 0){
                if(Lines.get(beginLine+count).equals("begin")){
                    LoopLines.add(Lines.get(beginLine+count));
                    beginEndEqu++;
                }
                else if(Lines.get(beginLine+count).equals("end")){
                    LoopLines.add(Lines.get(beginLine+count));
                    beginEndEqu--;
                }
                else{
                    LoopLines.add(Lines.get(beginLine+count));
                }
                count++;   
            }
            
          
            /* 
                After determining loop's lines copy current variables
                to LoopVariables List 
            */ 
            List<Variable> LoopVariables = new LinkedList<Variable>();
          
            for(int i = 0 ; i < vars.size() ; ++i ){
                LoopVariables.add(vars.get(i));
            }

            /* Run that loop */
            while(LoopVariables.get(loopCountIndex).value > 0){
            
                for(int i = 0 ; i < LoopLines.size() ; ++i){
                    StringTokenizer loopSeparator = new StringTokenizer(LoopLines.get(i));
                    String loopWord = null;
                    loopWord = loopSeparator.nextToken();
                    if(loopWord.equals("begin")||
                       loopWord.equals("end")){}
                    else if (isVariable(LoopLines.get(i),LoopVariables)) {}
                    else if(isLoop(LoopLines.get(i),LoopVariables)){
                        loopWord = loopSeparator.nextToken();
                        int tempInserter;
                        tempInserter = runLoops(LoopLines.get(i+1),beginLine+i+2,
                                                    getVarIndex(loopWord,LoopVariables),LoopVariables); 
                        if(tempInserter == 1){
                            System.exit(1);
                        }    
                        i += tempInserter;
                        tempInserter = 0;
                    }
                    
                    else if(isInput(LoopLines.get(i),LoopVariables)){}
                    else if(isCalculate(LoopLines.get(i),LoopVariables)){}
                    else if(isPrint(LoopLines.get(i),LoopVariables)){}       
                }
                /* 
                    Update previous list that name vars and delete created local 
                    variables in LoopVariables for creating again
                */
                for(int i = 0 ; i < vars.size() ; ++i )           
                    vars.get(i).value = LoopVariables.get(i).value; 
     
                for(int i = LoopVariables.size()-1 ; i >= vars.size() ; --i)
                    LoopVariables.remove(i);
            }
  
            /* Return loop's lines count for inserting */ 
            return count;
        }
        /* Loop without begin statement */
        else
        {
           System.err.println("Invalid loop definition:" + word); 
        }
        return 1;     
    }
    
    /* is Loop line method */
    private boolean isLoop(String line,List<Variable> vars) { 
        StringTokenizer separator = new StringTokenizer(line);
        String word = null ;
        
        word = separator.nextToken();
        /* Control Loop statement "Loop [valid var]" etc. */ 
        if(word.equals("loop")){
            word = separator.nextToken();
            if(!varContain(word,vars)){
                System.err.println("Undefined Loop Counter Variable :" + word);
            }
            else{
                return true;
            }           
        }
        return false; 
    }
    
    /* is Print line method */
    private boolean isPrint(String line,List<Variable> vars) {
        StringTokenizer separator = new StringTokenizer(line);
        String word = null ;
        double value = 0.0;
        
        word = separator.nextToken();
        
        if(word.equals("print")){
            word = separator.nextToken();
            if(!varContain(word,vars)){
                System.err.println("Undefined Variable :" + word);
            }
            else{
                int index = getVarIndex(word,vars);
                if (vars.get(index).value == null)
                    System.err.println("Uninitialized Variable :" + word);
                else
                    resultText += vars.get(index).value + "\n";
            }
            return true;
        }  
        
        return false;
    }
    /* is Calculate line method */
    private boolean isCalculate(String line,List<Variable> vars) {
        
        StringTokenizer separator = new StringTokenizer(line);
        String word = null;
        
        word = separator.nextToken();
        if (word.equals("=")) {
            System.err.println( "No LValue \n");
            return false;
        }
        
        if(!varContain(word,vars) && !word.equals("print")){
            System.err.println("Undefined Variable :" + word);
            return false;
        }
        
        else if(varContain(word,vars) && !word.equals("print")){
            int index = getVarIndex(word,vars);
            word = separator.nextToken();
            if (!word.equals("=")) {
                System.err.println("No assigment operator\n");
                return false;
            }
            else{
                word = separator.nextToken("\n");
                vars.get(index).value = calculateLine(word,vars);
            }
            return true;
        }
        
        return false;
    }
    /* Calculate line assistant method */
    private Double calculateLine(String word,List<Variable> vars){
        
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
          
        postFix = calculateVars(postFix,vars);
        if (postFix == null) 
            return null;
        else 
            result = Calculator.eval(postFix);
        
        return result;   
    }
    /* calculate line main calculation method */
    private String calculateVars(String postFix,List<Variable> vars) {
        
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
                    temp = calculateVars(uniaryNext,vars);
                    if(temp == null){
                        System.err.append("Error in uniary variable" + uniaryNext);
                        return null;
                    }
                    else{
                        calculation.append(calculateUniaryExp(word,temp,vars));
                        calculation.append(" ");
                    }
                }
                else{
                
                    for (index = 0; index < vars.size(); ++index) {
                        if (word.equals(vars.get(index).name)) {
                            temp = vars.get(index).value.toString();
                            break;
                        }
                    }

                    if (temp != null) { 
                        if (vars.get(index).value == null) {
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
    private String calculateUniaryExp(String word, String uniaryNext,List<Variable> vars) {
        Double temp;
        int index = 0;
        boolean isLetterFlag;
        uniaryNext = uniaryNext.replace(" ", "");
        
        if(Character.isLetter(uniaryNext.charAt(0)))
        {
            for(int i = 0 ; i < vars.size() ; ++i){
                if(uniaryNext.equals(vars.get(i).value.toString())){
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
                    temp = Math.sin((vars.get(index).value)*(Math.PI / 180.0));
                else
                    temp = Math.sin(Double.parseDouble(uniaryNext)*(Math.PI / 180.0));
                return temp.toString();
            case "cos":
                if(isLetterFlag)
                    temp = Math.cos((vars.get(index).value)*(Math.PI / 180.0));
                else
                    temp = Math.cos(Double.parseDouble(uniaryNext)*(Math.PI / 180.0));
                return temp.toString();
            case "sqrt":
                if(isLetterFlag)
                    temp = Math.sqrt(vars.get(index).value);
                else
                    temp = Math.sqrt(Double.parseDouble(uniaryNext));
                return temp.toString();
            case "log":
                if(isLetterFlag)
                    temp = Math.log10(vars.get(index).value);
                else
                    temp = Math.log10(Double.parseDouble(uniaryNext));
                return temp.toString();
            case "abs":
                if(isLetterFlag)
                    temp = Math.abs(vars.get(index).value);
                else
                    temp = Math.abs(Double.parseDouble(uniaryNext));
                return temp.toString();
            case "tan":
                if(isLetterFlag)
                    temp = Math.tan((vars.get(index).value)*(Math.PI / 180.0));
                else
                    temp = Math.tan(Double.parseDouble(uniaryNext)*(Math.PI / 180.0));
                return temp.toString();
            case "exp":
                if(isLetterFlag)
                    temp = Math.exp(vars.get(index).value);
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
    
    private boolean isInput(String line,List<Variable> vars) {
        StringTokenizer separator = new StringTokenizer(line);
        String word = null;
        String temp = null;
        
        word = separator.nextToken();  
        if(word.equals("input")){
            temp = separator.nextToken();
            if(!varContain(temp,vars)){
                System.err.println("Undefined Variable :" + temp);
            }
            else{
                int index = getVarIndex(temp,vars);
                vars.get(index).value = Double.parseDouble( JOptionPane.showInputDialog( 
                                                                 "Enter a number for " + temp +":") );
            }
            return true;
        }
        return false;
    }
    /* is variable defined before */
    private boolean varContain(String varName,List<Variable> vars) {

        for (int i = 0; i < vars.size(); ++i) {
            if (varName.equals(vars.get(i).name)) {
                return true;
            }
        }

        return false;
    }
    /* get variable's defined value */
    private int getVarIndex(String varName,List<Variable> vars) {

        int i;
        
        for (i = 0; i < vars.size(); ++i) {
            if (varName.equals(vars.get(i).name)) {
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
        
        /* Program selection menu */
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
