/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw01_091044042;


import javax.swing.JOptionPane;

/**
 *
 * @author aanilapaydin
 */
public class CSE222_HW01_091044042 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Form myForm;
        myForm = getUI();
        myForm.process();    
    }
    
    //Object Factory
    public static Form getUI(){
        
        String figType = JOptionPane.showInputDialog("Enter C for Console User Interface"
                + "\nEnter G for Graphical User Interface\n");
        
        if(figType.equalsIgnoreCase("c"))
            return new ConsoleUI();
        else if(figType.equalsIgnoreCase("g"))
            return new GUI();
        else
            return null;
    }
}
