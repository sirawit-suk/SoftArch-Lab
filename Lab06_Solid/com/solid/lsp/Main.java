package com.solid.lsp;


/**
 *  This is the 1st Problem: Rectangle & Square
 *  Problem: Refactor code by avoid the problem from LSP violation
 *  Solved: It is based on delegation. 
 *          Concretely, it means that each instance of Square uses an instance of Rectangle 
 *          to "do the job". This instance is called delegate in the implementation. 
 *          The classes Rectangle and Test remain unchanged.
 * 
 *  why did I choose this method: 
 *          because Sensei gave the instruction that Rectangle class can not be change.
 *          this is a limitation of adapting some code to become an abstraction class or even interface
 *  sol1 (not use): 
 *          Rectangle class -> abstract shape
 *          Square class -> abstract shape
 *          This is I was prefer to do but we need to implement code of rectangle class
 *          due to attribute and some method that is too excess. 
 *          for me, i don't think it is a good idea if we can't change the Rectangle code if we use this sol.            
 * sol2 (not use):
 *          Rectangle class -> interface shape
 *          Square class -> interface shape
 *          This is an alternative one but not recommend because Rectangle and Square have some common methods (inside)
 *          those are the same and have a common attribute so I prefer sol1 than this
 * sol3 (used): 
 *          used this one as I mention above, is the best practice for this situation. 
 * 
 *  Reference: https://dept-info.labri.fr/~baudon/Master/POA/Vietnam10/rectangle.html
 */


public class Main {

    private static final int width = 2;
    private static final int height = 10;

    public static void main(String[] args) {
        Rectangle reg1 = new Rectangle(width, height);
        System.out.println("==== Rectangle ====");
        System.out.println("Width = " + reg1.getWidth());
        System.out.println("Height = " + reg1.getHeight());
        System.out.println("Area = " + reg1.getArea());

        Square reg2 = new Square(5);
        //** Error, because Square don't have method setWidth and setHeight
        // reg2.setWidth(width);
        // reg2.setHeight(height);
        reg2.setSide(20); // set to new side of square
        System.out.println("====   Square  ====");
        System.out.println("Width = " + reg2.getWidth());
        System.out.println("Height = " + reg2.getHeight());
        System.out.println("Side = " + reg2.getSide());
        System.out.println("Area = " + reg2.getArea());
    }
}
