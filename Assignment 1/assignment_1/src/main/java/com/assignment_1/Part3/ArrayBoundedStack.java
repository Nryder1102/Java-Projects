//----------------------------------------------------------------
// ArrayBoundedStack.java    by Dale/Joyce/Weems         Chapter 2
//
// Implements StackInterface using an array to hold the 
// stack elements.
//
// Two constructors are provided: one that creates an array of a 
// default size and one that allows the calling program to 
// specify the size.
//----------------------------------------------------------------

package com.assignment_1.Part3;

import com.assignment_1.Part4.LLNode;

public class ArrayBoundedStack<T> implements StackInterface<T> 
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // holds stack elements
  protected int topIndex = -1;      // index of top element in stack

  public ArrayBoundedStack() 
  {
    elements = (T[]) new Object[DEFCAP];
  }

  public ArrayBoundedStack(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
  }

  public void push(T element)
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.
  {      
    if (isFull())
      throw new StackOverflowException("Push attempted on a full stack.");
    else
    {
      topIndex++;
      elements[topIndex] = element;
    }
  }

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
      elements[topIndex] = null;
      topIndex--;
    }
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    T topOfStack = null;
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      topOfStack = elements[topIndex];
    return topOfStack;
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (topIndex == -1); 
  }

  public boolean isFull()
  // Returns true if this stack is full, otherwise returns false.
  {              
    return (topIndex == (elements.length - 1));
  }


  //NEW METHODS

  @Override
  public String toString(){
    String output = "Current Top of Stack: " + elements[topIndex].toString() + "\n";
    output += "Current Amount of Elements: " + this.size() + "/" + this.elements.length;
    return output;
  }

  public int size(){
    int count = 0;
    for(T object : elements){
      if(object != null){
        count++;
      }
    }
    return count;
  }

  public T get(int index){
    try{
      return elements[index];
    }catch(IndexOutOfBoundsException e){
      e.printStackTrace();
    }
    return null;
  }

  public void popSome(int count){
    if(topIndex - count > -1){
      for(int i = 0; i < count; i++){
        elements[topIndex] = null;
        topIndex--;
      }
    }else{
      throw new StackUnderflowException("Not enough elements in stack to pop.");
    }
  }

  public T popTop(){

    T topOfStack = null;

    //If empty, throw error
    if(topIndex == -1){
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    //Else, remove and return the current top
    }else{
      topOfStack = elements[topIndex];
      elements[topIndex] = null;
      topIndex--;
    }

    return topOfStack;
  }

  //Swap the top two elements in the stack
  public boolean swapStart(){
    if(this.size() < 2){
      return false;
    }else{
      T temp = elements[topIndex];
      elements[topIndex] = elements[topIndex-1];
      elements[topIndex-1] = temp;
      return true;
    }
  }
}