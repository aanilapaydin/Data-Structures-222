/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw01_091044042;

import java.util.Scanner;

/**
 *
 * @author aanilapaydin
 */
public class ConsoleUI extends Form{
    public ConsoleUI(){
        this.myForm = new Form();
    }

    public ConsoleUI(Form myForm) {
        this.myForm = myForm;
    }
    
    @Override
    public void process() {
        
        String ch = "";
        while(!ch.toString().equals("E") && !ch.toString().equals("e"))
        {
            
                System.out.println("CSE222 HW01 091044042 Console Options\n");
                System.out.println("(R)ead From File\n(D)raw Functions\n"
                                    + "(C)lear Table\n(E)xit\n");
                Scanner scanner = new Scanner(System.in);
                ch = scanner.next().toString();
                
                if(ch.toString().equals("R") || ch.toString().equals("r")){
                    myForm.read();
                }
                else if(ch.toString().equals("D") || ch.toString().equals("d")){
                    myForm.draw();
                }
                else if(ch.toString().equals("C") || ch.toString().equals("c")){
                    myForm.clear();
                    myForm = null;
                    this.myForm = new Form();
                }
                else if(ch.toString().equals("E") || ch.toString().equals("e")){
                     System.exit(0);
                } 

        }
    }
    
    
    private Form myForm;
}
