package com.assignment_1.Part4;

public abstract class NodeMethods{
    
    public static <T> int size(LLNode<T> node){
        int count = 0;
        while(node != null){
            count++;
            node = node.getLink();
        }
        return count;
    }

    public static <T> void displayElements(LLNode<T> node){
        int count = 1;
        while(node != null){
            System.out.println(count + ". " + node.info);
            count++;
            node = node.getLink();
        }
    }

    public static <T> void displayElementsReverse(LLNode<T> node){
        if(node.getLink() != null){
            displayElementsReverse(node.getLink());
        }
        System.out.println(size(node) + ". " + node.info);
    }

    public static int sumList(LLNode<Integer> node){
        int sum = 0;
        while(node != null){
            sum += node.getInfo();
            node = node.getLink();
        }
        return sum;
    }

    public static int posCount(LLNode<Integer> node){
        int count = 0;
        while(node != null){
            if(node.getInfo() >= 0){count++;}
            node = node.getLink();
        }
        return count;
    }

}
