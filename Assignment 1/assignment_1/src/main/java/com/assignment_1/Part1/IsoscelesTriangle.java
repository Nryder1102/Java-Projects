package com.assignment_1.Part1;
public class IsoscelesTriangle implements FigureInterface{

    protected double height;
    protected double base;

    public IsoscelesTriangle(double height, double base){
        this.height = height;
        this.base = base;
    }

    public double perimeter(){
        double angle = Math.sqrt(Math.pow(base/2,2) + Math.pow(height,2));
        return(2*angle + base);
    }

    public double area(){
        return((base*height)/2);
    }
    
}
