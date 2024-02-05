package com.assignment_1.Part1;
public class Square implements FigureInterface {

    protected double length;
    
    public Square(double length){
        this.length = length;
    }

    public double perimeter(){
        return(4 * length);
    }

    public double area(){
        return(length * length);
    }

}
