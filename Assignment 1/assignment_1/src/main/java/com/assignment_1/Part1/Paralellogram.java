package com.assignment_1.Part1;
public class Paralellogram implements FigureInterface{
    
    protected double height;
    protected double base;
    protected double angle;

    public Paralellogram(double height, double base, double angle){
        this.height = height;
        this.base = base;
        this.angle = angle;
    }

    public double perimeter(){
        return(2*(angle + base));
    }

    public double area(){
        return(base * height);
    }

}
