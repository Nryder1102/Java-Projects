package com.assignment_1;

import java.util.Scanner;

import com.assignment_1.Part1.*;
import com.assignment_1.Part2.*;
import com.assignment_1.Part3.*;
import com.assignment_1.Part4.*;


public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        boolean mainLoop = true;

        while(mainLoop){
            System.out.println("Welcome to Assignment 1!\nPlease choose a part to run: \n1) Shapes & FigureInterface\n2) PairInterface\n3) ArrayBoundedStack\n4) LinkedList\n5) Exit");
            int choice = Console.getInt("> ");
            switch(choice){
                case 1:{
                    Console.clear();
                    part1();
                    break;
                }
                case 2:{
                    Console.clear();
                    part2();
                    break;
                }
                case 3:{
                    Console.clear();
                    part3();
                    break;
                }
                case 4:{
                    Console.clear();
                    part4();
                    break;
                }
                case 5:{
                    mainLoop = false;
                    break;
                }
            }
        }
        
        
        
    }

    //Shapes that implement FigureInterface (Driver?) - Done
    public static void part1(){

        boolean shapeLoop = true;
        System.out.println("Welcome to the Shapes ITD!");

        while(shapeLoop){
            int choice = Console.getIntEqual("Please select a shape: \n1) Square\n2) Right Triangle\n3) Isosceles Triangle\n4) Paralellogram\n5) Exit\n> ", 1, 5);
            switch(choice){
                case 1:{
                    double length = Console.getDouble("Please enter the length of the sides: ");
                    Square square = new Square(length);
                    System.out.printf("Perimeter of the Square: %.2f", square.perimeter());
                    System.out.printf("\nArea of the Square: %.2f", square.area());
                    System.out.println();
                    Console.wait(2);
                    break;
                }
                case 2:{
                    double leg1 = Console.getDouble("Please enter the length of the first leg: ");
                    double leg2 = Console.getDouble("Please enter the length of the second leg: ");
                    RightTriangle rTriangle = new RightTriangle(leg1, leg2);
                    System.out.printf("Perimeter of the Right Triangle: %.2f", rTriangle.perimeter());
                    System.out.printf("\nArea of the Right Triangle: %.2f", rTriangle.area());
                    System.out.println();
                    Console.wait(2);
                    break;
                }
                case 3:{
                    double height = Console.getDouble("Please enter the height of the triangle: ");
                    double base = Console.getDouble("Please enter the base length of the triangle: ");
                    IsoscelesTriangle iTriangle = new IsoscelesTriangle(height, base);
                    System.out.printf("Perimeter of the Isosceles Triangle: %.2f", iTriangle.perimeter());
                    System.out.printf("\nArea of the Isosceles Triangle: %.2f", iTriangle.area());
                    System.out.println();
                    Console.wait(2);
                    break;
                }
                case 4:{
                    double height = Console.getDouble("Please enter the height of the paralellogram: ");
                    double base = Console.getDouble("Please enter the base length of the paralellogram: ");
                    double angle = Console.getDouble("Please enter the angle of the paralellogram: ");
                    Paralellogram paraGram = new Paralellogram(height, base, angle);
                    System.out.printf("Perimeter of the Paralellogram: " + paraGram.perimeter());
                    System.out.printf("\nArea of the Paralellogram: " + paraGram.area());
                    System.out.println();
                    Console.wait(2);
                    break;
                }
                case 5:{
                    shapeLoop = false;
                    break;
                }
            }
            System.out.println();
        }
        Console.clear();
    }

    //PairInterface Driver - Done
    public static void part2(){
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the PairInterface ITD!\n(Note: I'm not quite sure how to really show this off in the console, if I'm being honest)\n");
        
        PairInterface<String> bPair = new BasicPair<String>("Wizard", "Rogue");
        PairInterface<String> aPair = new ArrayPair<String>("Fighter","Paladin");

        System.out.println("Default BasicPair Data: " + bPair.getFirstObject() + " & " + bPair.getSecondObject());
        System.out.println("Default ArrayPair Data: " + aPair.getFirstObject() + " & " + aPair.getSecondObject());

        Console.wait(2);

        String bObject1 = Console.getNonEmptyString("\nPlease enter new data for BasicPair Object 1: ");
        String bObject2 = Console.getNonEmptyString("Please enter new data for BasicPair Object 2: ");
        String aObject1 = Console.getNonEmptyString("Please enter new data for ArrayPair Object 1: ");
        String aObject2 = Console.getNonEmptyString("Please enter new data for ArrayPair Object 2: ");

        bPair.setFirstObject(bObject1);
        bPair.setSecondObject(bObject2);
        aPair.setFirstObject(aObject1);
        aPair.setSecondObject(aObject2);

        System.out.println("\nNew BasicPair Data: " + bPair.getFirstObject() + " & " + bPair.getSecondObject());
        System.out.println("New ArrayPair Data: " + aPair.getFirstObject() + " & " + aPair.getSecondObject());

        Console.wait(3);

        Console.clear();
    }

    //ArrayBoundedStack Driver - Done
    public static void part3(){

        Scanner s = new Scanner(System.in);

        int stackAmount = 0;
        System.out.println("Welcome to the ArrayBoundedStack ITD!");
        
        stackAmount = Console.getInt("Please enter the size of the ArrayBoundedStack: ");

        ArrayBoundedStack<String> stack = new ArrayBoundedStack<>(stackAmount);
        
        boolean stackLoop = true;
        boolean displayMenu = true;
        String menu = "Please select an operation to perform: \n1) Push new element on to the Stack\n2) Pop the top element off of the Stack\n3) Pop a certain amount of elements off the top of the Stack\n4) Swap the top two elements of the Stack\n5) Print information about the Stack\n6) Exit";

        while(stackLoop){
            if(displayMenu){
                Console.clear();
                System.out.println(menu);
                displayMenu = false;
            }
            int choice = Console.getIntEqual("> ", 1, 6);
            switch(choice){
                case 1:{
                    String element;
                    System.out.print("Please enter element to push: ");
                    element = s.next();
                    stack.push(element);
                    System.out.println("Element pushed!");
                    Console.wait(1);
                    displayMenu = true;
                    if(stack.isFull()){stackLoop = false;}
                    break;
                }
                case 2:{
                    try{
                        stack.pop();
                        System.out.println("Element popped!");
                        Console.wait(1);
                        displayMenu = true;
                    }catch(StackUnderflowException e){
                        System.out.println("Unable to pop, not enough elements!");
                    }
                    break;
                }
                case 3:{
                    try{
                        int popAmount;
                        System.out.print("Please enter amount of elements to pop: ");
                        popAmount = s.nextInt();
                        stack.popSome(popAmount);
                        System.out.println("Elements popped!");
                        Console.wait(1);
                        displayMenu = true;
                    }catch(StackUnderflowException e){
                        System.out.println("Unable to pop, not enough elements!");
                    }
                    break;
                }
                case 4:{
                    if(stack.size() >= 2){
                        stack.swapStart();
                        System.out.println("Elements swapped!");
                        Console.wait(1);
                        displayMenu = true;
                    }else{
                        System.out.println("Not enough elements to swap!");
                    }
                    break;
                }
                case 5:{
                    if(!stack.isEmpty()){
                        System.out.println(stack);
                    }else{
                        System.out.println("The Stack is currently empty!");
                    }
                    break;        
                }
                case 6:{
                    stackLoop = false;
                    break;
                }
            }
        }
        
        
        System.out.println("Here is your final stack: ");
        int size = stack.size();
        for(int i = 0; i < size; i++){
            System.out.print(i+1 + ". " + stack.popTop() + "\n");
        }

        Console.wait(10);
        Console.clear();
    }

    //LinkedList Driver - Done
    public static void part4(){

        
        boolean linkLoop = true;

        System.out.println("Welcome to the LinkedList ITD!");

        LLNode<Integer> numbers = null;
        
        while(linkLoop){
            
            System.out.println("Please select an operation to run: \n1) Add Node to the beginning of the List\n2) Output sum of the numbers in the List\n3) Output count of elements in the List\n4) Output number of positive integers in the List\n5) Output enumerated list of elements\n6) Output reversed enumerated list of elements\n7) Exit");
            int choice = Console.getIntEqual("> ", 1, 7);
            switch(choice){
                case 1:{
                    LLNode<Integer> temp = new LLNode<Integer>(Console.getInt("Please enter an Integer for the new Node: "));
                    temp.setLink(numbers);
                    numbers = temp;
                    System.out.println("Node added!");
                    Console.wait(1);
                    Console.clear();
                    break;
                }
                case 2:{
                    if(numbers != null){
                        System.out.println("\nSum of all numbers in List: " + NodeMethods.sumList(numbers) + "\n");
                    }else{
                        System.out.println("List is empty!");
                    }
                    break;
                }
                case 3:{
                    if(numbers != null){
                        System.out.println("\nCount of all nodes in List: " + NodeMethods.size(numbers) + "\n");
                    }else{
                        System.out.println("List is empty!");
                    }
                    break;
                }
                case 4:{
                    if(numbers != null){
                        System.out.println("\nCount of all  positive numbers in List: " + NodeMethods.posCount(numbers) + "\n");
                    }else{
                        System.out.println("List is empty!");
                    }
                    break;
                }
                case 5:{
                    if(numbers != null){
                        System.out.println("\nList of elements: ");
                        NodeMethods.displayElements(numbers);
                        System.out.println();
                    }else{
                        System.out.println("List is empty!");
                    }
                    break;
                }
                case 6:{
                    if(numbers != null){
                        System.out.println("\nList of elements (In Reverse Order): ");
                        NodeMethods.displayElementsReverse(numbers);
                        System.out.println();
                    }else{
                        System.out.println("List is empty!");
                    }
                    break;
                }
                case 7:{
                    linkLoop = false;
                    break;
                }
            }
        }
        Console.clear();
    }
}