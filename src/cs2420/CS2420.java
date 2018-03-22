/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2420;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author OWNER
 */
public class CS2420 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       binaryConversion(50);
       StdOut.print();
       
    }
    
    
    private static void binaryConversion(int n){
        Stack<Integer> stack = new Stack<>();
        
        while(n>0){
            stack.push(n%2);
            n/=2;
        }
        for(Integer el : stack )StdOut.print(el);
        StdOut.println();
}
    
}


