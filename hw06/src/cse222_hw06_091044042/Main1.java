/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse222_hw06_091044042;

/**
 *
 * @author AAnılApaydın
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GITPriorityQueue myQueue = new GITPriorityQueue();
        Integer first = new Integer(2);
        Integer second = new Integer(4);
        myQueue.offer(first);
        myQueue.offer(second);
        myQueue.offer(new Integer(5));
        myQueue.offer(new Integer(3));
        myQueue.offer(new Integer(4));
        myQueue.offer(new Integer(5));
        
        System.out.println("size:"+myQueue.getSize());
        System.out.println(myQueue.remove());
        System.out.println("size:"+myQueue.getSize());
        System.out.println(myQueue.remove());
        System.out.println("size:"+myQueue.getSize());
        System.out.println(myQueue.remove());
        System.out.println("size:"+myQueue.getSize());
        
    }
    
}
