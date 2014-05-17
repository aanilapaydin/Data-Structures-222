/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw01_091044042;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author aanilapaydin
 */
public class GUI extends Form implements ActionListener{

    public GUI(){
        this.myForm = new Form();
        this.readButton = new JButton();
        this.drawButton = new JButton();
        this.clearButton = new JButton();
        this.exitButton = new JButton();
    }
    
    public GUI(Form myForm) {
        this.myForm = myForm;
    }
    
    @Override
    public void process() {
        
        JFrame myFrame = new JFrame("CSE222 HW01 091044042 GUI Options");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(640, 80);
        JPanel myPanel = new JPanel();

        readButton.setText("Read From File");
        myPanel.add(readButton);
        readButton.setBounds(180, 20, 260, 60);        
        drawButton.setText("Draw Functions");
        myPanel.add(drawButton);
        drawButton.setBounds(180, 20, 260, 110);
        clearButton.setText("Clear Table");
        myPanel.add(clearButton);
        clearButton.setBounds(180, 120, 260, 160);
        exitButton.setText("Exit");
        myPanel.add(exitButton);
        exitButton.setBounds(180, 170, 260, 210);
        
        readButton.addActionListener(this);
        drawButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        
        myFrame.add(myPanel);
        myFrame.setVisible(true);
        
    } 
  
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        Object src = evt.getSource();
        if (src == readButton) {
            myForm.read();
        } else if (src == drawButton) {
            myForm.draw();
        } else if (src == clearButton) {
            myForm.clear();
            myForm = null;
            this.myForm = new Form();
        } else if (src == exitButton) {
            System.exit(0);
        }
       
       
    }

    private JButton readButton;
    private JButton drawButton;
    private JButton clearButton;
    private JButton exitButton;
    private Form myForm;
    
}
