/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw01_091044042;

import java.awt.Graphics;

/**
 *
 * @author aanilapaydin
 */
public interface FormInterface {
    public void draw();
    public void drawCoordinates(Graphics g);
    public void drawFunctions(Graphics g);
    public void read();
    public void clear();
    public void process();
}
