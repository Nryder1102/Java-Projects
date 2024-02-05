package com.assignment_1.Part2;

public class BasicPair<T> implements PairInterface<T>{

    //Variables
    protected T object1;
    protected T object2;

    //Constructor
    public BasicPair(T object1,T object2){
        this.object1 = object1;
        this.object2 = object2;
    }

    //Getters
    public T getFirstObject(){return(object1);}
    public T getSecondObject(){return(object2);}

    //Setters 
    public void setFirstObject(T object){this.object1 = object;}
    public void setSecondObject(T object){this.object2 = object;}
    
}
