package com.solid.lsp;

public class Square{ 
    
    // We need to cut the bond (extends) from Rectangle class
    // Because if Square object can be able to use setHeight and setWidth, 
    // this can be catastrophic when we get the lastest Area of square

    private Rectangle obj;

    //constructor
    Square(int side) {

    // We create a new Rectangle object inside Square class 
    // make the object to "do their job" and can use only method that this class have 
        this.obj = new Rectangle(side,side);

    }

    //setter
    public void setSide(int side) {
        this.obj.setWidth(side);
        this.obj.setHeight(side);
    }

    //getter
    public int getSide() {
        return this.obj.getHeight();
    }
    public int getWidth() {
        return this.obj.getWidth();
    }
    public int getHeight() {
        return this.obj.getHeight();
    }
    public int getArea() { 
        return this.obj.getArea();
    }


}
