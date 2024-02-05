package com.assignment_1.Part1;
import java.lang.Math; 
public class RightTriangle implements FigureInterface{
    
    protected double leg1;
    protected double leg2;

    public RightTriangle(double leg1, double leg2){
        this.leg1 = leg1;
        this.leg2 = leg2;
    }

    public double perimeter(){
        double leg3 = Math.sqrt(Math.pow(leg1,2) + Math.pow(leg2,2));
        return(leg1+leg2+leg3);
    }

    public double area(){
        return((leg1*leg2)/2);
    }

}
