/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw01_091044042;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;




/**
 *
 * @author aanilapaydin
 */
public class Form extends JPanel implements FormInterface{

    
    
    public Form() {
        super();
        functionNames = new ArrayList<String>();
        firstInputs = new ArrayList<Double>();
        lastInputs = new ArrayList<Double>();
        colors = new ArrayList<String>();
    }

    
    

    @Override
    public void draw() {
 
        functions.setTitle("Functions Table");
        functions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        functions.setSize(640, 480);
        functions.add(this);
        functions.setVisible(true);

        
    }

    @Override
    public void drawCoordinates(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(320, 10, 320, 470);
        
        g.setColor(Color.black);
        g.drawLine(100, 240, 540, 240);
        
        g.drawString("-5", 120, 240);
        g.drawString("-4", 160, 240);
        g.drawString("-3", 200, 240);
        g.drawString("-2", 240, 240);
        g.drawString("-1", 280, 240);
        g.drawString("0", 320, 240);
        g.drawString("1", 360, 240);
        g.drawString("2", 400, 240);
        g.drawString("3", 440, 240);
        g.drawString("4", 480, 240);
        g.drawString("5", 520, 240);
        
        g.drawString("-5", 320, 440);
        g.drawString("-4", 320, 400);
        g.drawString("-3", 320, 360);
        g.drawString("-2", 320, 320);
        g.drawString("-1", 320, 280);
        g.drawString("1", 320, 200);
        g.drawString("2", 320, 160);
        g.drawString("3", 320, 120);
        g.drawString("4", 320, 80);
        g.drawString("5", 320, 40);
    }

    @Override
    public void drawFunctions(Graphics g) {
       
        for(int i=0;i<functionNames.size();++i){
            
            if(functionNames.get(i).toString().equals("sin(x)")){
                g.setColor(getFunctionColor(i));
                double first = Double.parseDouble(firstInputs.get(i).toString());
                double last = Double.parseDouble(lastInputs.get(i).toString());
                double count = 0.01;
                for(double k=first;k<=last-count;k+=count){
                    g.drawLine((int)(320+40*k),(int)((Math.sin(-k)*40)+240),
                               (int)(320+40*(k+count)),(int)(Math.sin(-k+count)*40)+240);
                
                }
            }
            else if(functionNames.get(i).toString().equals("x")){
                g.setColor(getFunctionColor(i));
                double first = Double.parseDouble(firstInputs.get(i).toString());
                double last = Double.parseDouble(lastInputs.get(i).toString());
                
                g.drawLine((int)(320+(40*first)), (int)(240-(40*first)),
                           (int)(320+(40*last)), (int)(240-(40*last)));
                
            }
            else if(functionNames.get(i).equals("cos(x)")){
                g.setColor(getFunctionColor(i));
                double first = Double.parseDouble(firstInputs.get(i).toString());
                double last = Double.parseDouble(lastInputs.get(i).toString());
                double count = 0.01;
                for(double k=first;k<=last-count;k+=count){
                    g.drawLine((int)(320+40*k),(int)(-(Math.cos(-k)*40)+240),
                               (int)(320+40*(k+count)),(int)(-(Math.cos(-k+count)*40)+240));
                
                }
            }
            else if(functionNames.get(i).equals("log(x)")){
                g.setColor(getFunctionColor(i));
                double first = Double.parseDouble(firstInputs.get(i).toString());
                double last = Double.parseDouble(lastInputs.get(i).toString());
                double count = 0.01;
                for(double k=first;k<=last-count;k+=count){
                    g.drawLine((int)(320+40*k),(int)(-(Math.log10(k)*40)+240),
                               (int)(320+40*(k+count)),(int)(-(Math.log10(k+count)*40)+240));
                
                }
            }
            else if(functionNames.get(i).equals("ln(x)")){
                g.setColor(getFunctionColor(i));
                double first = Double.parseDouble(firstInputs.get(i).toString());
                double last = Double.parseDouble(lastInputs.get(i).toString());
                double count = 0.01;
                for(double k=first;k<=last-count;k+=count){
                    g.drawLine((int)(320+40*k),(int)(-(Math.log(k)*40)+240),
                               (int)(320+40*(k+count)),(int)(-(Math.log(k+count)*40)+240));
                
                }
            }
            else if(functionNames.get(i).equals("tan(x)")){
                g.setColor(getFunctionColor(i));
                double first = Double.parseDouble(firstInputs.get(i).toString());
                double last = Double.parseDouble(lastInputs.get(i).toString());
                double count = 0.01;
                for(double k=first;k<=last-count;k+=count){
                    g.drawLine((int)(320+40*k),(int)(-(Math.tan(k)*40)+240),
                               (int)(320+40*(k+count)),(int)(-(Math.tan(k+count)*40)+240));
                
                }
            }
            else if(functionNames.get(i).equals("cot(x)")){
                g.setColor(getFunctionColor(i));
                double first = Double.parseDouble(firstInputs.get(i).toString());
                double last = Double.parseDouble(lastInputs.get(i).toString());
                double count = 0.01;
                for(double k=first;k<=last-count;k+=count){
                    g.drawLine((int)(320+40*k),(int)(Math.pow(-(Math.tan(k)*40) , -1)+240),
                               (int)(320+40*(k+count)),(int)(Math.pow(-(Math.tan(k+count)*40) , -1)+240));
                
                }
            }
            else if(functionNames.get(i).equals("sec(x)")){
                g.setColor(getFunctionColor(i));
                double first = Double.parseDouble(firstInputs.get(i).toString());
                double last = Double.parseDouble(lastInputs.get(i).toString());
                double count = 0.01;
                for(double k=first;k<=last-count;k+=count){
                    g.drawLine((int)(320+40*k),(int)((1/-(Math.cos(-k)*40))+240),
                               (int)(320+40*(k+count)),(int)((1/-(Math.cos(-k+count)*40))+240));
                
                }
            }
            else if(functionNames.get(i).equals("cosec(x)")){
                g.setColor(getFunctionColor(i));
                double first = Double.parseDouble(firstInputs.get(i).toString());
                double last = Double.parseDouble(lastInputs.get(i).toString());
                double count = 0.01;
                for(double k=first;k<=last-count;k+=count){
                    g.drawLine((int)(320+40*k),(int)(1/(Math.sin(-k)*40)+240),
                               (int)(320+40*(k+count)),(int)(1/(Math.sin(-k+count)*40)+240));
                
                }
            }
        
        }
        
        
    }

    public Color getFunctionColor(int i){
            
            if(colors.get(i).toString().equals("magenta"))
                return Color.magenta;
            else if(colors.get(i).toString().equals("green"))
                return Color.green;
            else if(colors.get(i).toString().equals("yellow"))
                return Color.yellow;
            else if(colors.get(i).toString().equals("red"))
                return Color.red;
            else if(colors.get(i).toString().equals("blue"))
                return Color.blue;
            else if(colors.get(i).toString().equals("cyan"))
                return Color.cyan;
            else if(colors.get(i).toString().equals("gray"))
                return Color.gray;
            else if(colors.get(i).toString().equals("pink"))
                return Color.pink;
            else if(colors.get(i).toString().equals("orange"))
                return Color.orange;
        
            return Color.black;
    }
    
    @Override
    public void read() {
        File file = new File("input.txt");
        
        try {
 
            Scanner scanner= new Scanner(file).useDelimiter(", |\n");
            
            while (scanner.hasNext()){
                
                functionNames.add(scanner.next().toString());
                firstInputs.add(Double.valueOf(scanner.next().toString()));
                lastInputs.add(Double.valueOf(scanner.next().toString()));
                colors.add(scanner.next().toString());

            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        functions.getContentPane().removeAll();
        functions.repaint();
        functions.dispose();
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        drawCoordinates(g);
        drawFunctions(g);
        
    }
   
    private List functionNames;
    private List firstInputs;
    private List lastInputs;
    private List colors;
    

    JFrame functions =  new JFrame();
}
