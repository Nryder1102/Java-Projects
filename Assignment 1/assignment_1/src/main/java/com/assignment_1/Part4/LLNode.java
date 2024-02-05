package com.assignment_1.Part4;

public class LLNode<T> {
    
    //Variables
    protected T info;
    protected LLNode<T> link;

    //Constructor
    public LLNode(T info){
        this.info = info;
        link = null;
    }

    //Getters
    public T getInfo(){return this.info;}
    public LLNode<T> getLink(){return this.link;}

    //Setters
    public void setInfo(T info){this.info = info;}
    public void setLink(LLNode<T> link){this.link = link;}

}
