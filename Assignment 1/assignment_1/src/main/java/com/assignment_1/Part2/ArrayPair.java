package com.assignment_1.Part2;

//I think this is what I'm supposed to do? I'm not quite sure
public class ArrayPair<T> implements PairInterface<T> {
    
    //Variables
    protected T[] pair;

    //Constructor
    public ArrayPair(){
        this.pair = (T[]) new Object[2];
    }
    public ArrayPair(T object1, T object2){
        this.pair = (T[]) new Object[2];
        this.pair[0] = object1;
        this.pair[1] = object2;
    }

    //Getters
    public T getFirstObject(){return pair[0];}
    public T getSecondObject(){return pair[1];}

    //Setters
    public void setFirstObject(T object){this.pair[0] = object;}
    public void setSecondObject(T object){this.pair[1] = object;}
    
}
