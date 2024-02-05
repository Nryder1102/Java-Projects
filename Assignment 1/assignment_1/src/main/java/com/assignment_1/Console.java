package com.assignment_1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.*;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Console {

    /**
    *This Class is a repository of helpful methods I've made for myself
    */

    private static Scanner sc = new Scanner(System.in);

    /**
     * Clears the screen
     */
    public static void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    /**
     * Pauses the program for the specified amount of seconds
     * @param count Represents the amount of time to wait, in seconds
     */
    public static void wait(int count){
        try{
            java.util.concurrent.TimeUnit.SECONDS.sleep(count);
        }catch(InterruptedException e){
            e.printStackTrace();
        }    
    }


    /**
     * Base getString, gives a prompt, and returns user input as a String
     * @param prompt Prints a prompt such as "Continue? (y/n)"
     * @return Returns a String
     */
    public static String getString(String prompt) {

        System.out.print (prompt); 
        return sc.nextLine();

    }

    /**
     * Comparative getString, if user input doesn't match either of the two provided Strings, will loop until one does
     * @param prompt Prints a prompt such as "Continue? (y/n)"
     * @param one First term to check against
     * @param two Second term to check against
     * @return Returns a String
     */
    public static String getString(String prompt, String one, String two) {

        while(true){

            String value = getString(prompt);

            if(value.equalsIgnoreCase(one) || value.equalsIgnoreCase(two)){

                return value;

            }else{
               
                System.out.println("Sorry, not an option!");

            }
        }
    }

    /**
     * Version of getString that won't accept whitespace as an input
     * @param prompt Prints a prompt such as "Continue? (y/n)"
     * @return Returns a String
     */
    public static String getNonEmptyString(String prompt) {

        while(true){

            String value = getString(prompt);

            if(value.isEmpty() == false){

                return value;

            }else{
               
                System.out.println("String cannot be empty!");

            }
        }
    }

    /**
     * Comparative version of getString, if user input doesn't match either of the two provided Strings, or is only whitespace, will loop until an acceptable term is input
     * @param prompt Prints a prompt such as "Continue? (y/n)"
     * @param one First term to check against
     * @param two Second term to check against
     * @return Returns a String
     */
    public static String getNonEmptyString(String prompt, String one, String two) {

        while(true){

            String value = getString(prompt);

            if(value.equalsIgnoreCase(one) || value.equalsIgnoreCase(two) && value.isEmpty() == false){

                return value;

            }else {
               
                System.out.println("Sorry, not an option!");

            }
            
        }
    }

    /**
     * Base version of getInt, if the user inputs an int, return it, otherwise ask again
     * @param prompt Prints a prompt such as "Continue? (y/n)"
     * @return Returns an Int
     */
    public static int getInt(String prompt) {

        while(true) {
            
            System.out.print(prompt);

            try { 

                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) { 

                System.out.println("Error! Invalid integer value.");

            }
        }
    }

    /**
     * Version of getInt that will not quit until an integer between min and max is entered (Not Inclusive)
     * @param prompt Prints a prompt such as "Continue? (y/n)"
     * @param min Minimum number
     * @param max Maximum number
     * @return Returns an Int
     */
    public static int getInt(String prompt, int min, int max) {

        while(true) {

            int value = getInt(prompt);

            if(value > min && value < max) {

                return value;

            } else {
                
                System.out.println("Error! Number must be greater than " + min + " and less than " + max + ".");

            }
        }
    }

    /**
     * Version of getInt that will not quit until an integer between min and max is entered (Inclusive)
     * @param prompt Prints a prompt such as "Continue? (y/n)"
     * @param min Minimum number
     * @param max Maximum number
     * @return Returns an Int
     */
    public static int getIntEqual(String prompt, int min, int max) {

        while(true) {

            int value = getInt(prompt);

            if(value >= min && value <= max) {

                return value;

            } else {
                
                System.out.println("Error! Number must be greater than or equal to " + min + ", and less than or equal to " + max + ".");

            }
        }
    }

    /**
     * Base version of getDouble, will continue until a valid double is entered
     * @param prompt Prints a prompt such as "Continue? (y/n)"
     * @return Returns a Double
     */
    public static double getDouble(String prompt) {

        while(true) {

            System.out.print(prompt);

            try {

                return Double.parseDouble(sc.nextLine()); 

            } catch (NumberFormatException e) {

                System.out.println("Error! Invalid double value.");

            }
        }
    }

    /**
     * Version of getDouble that will not quit until a double between min and max is entered (Not Inclusive)
     * @param prompt Prints a prompt such as "Continue? (y/n)"
     * @param min Minimum number
     * @param max Maximum number
     * @return Returns a Double
     */
    public static double getDouble(String prompt, double min, double max) {

        while(true) { 
            double value = getDouble(prompt);

            if (value > min && value < max) {

                return value;

            } else {

                System.out.println("Error! Number must be greater than " + min + " and less than " + max + ".");

            }
        }
    }

    /**
     * Version of getDouble that will not quit until a double between min and max is entered (Inclusive)
     * @param prompt Prints a prompt such as "Continue? (y/n)"
     * @param min Minimum number
     * @param max Maximum number
     * @return Returns a Double
     */
    public static double getDoubleEqual(String prompt, double min, double max) {

        while(true) { 
            double value = getDouble(prompt);

            if (value >= min && value <= max) {

                return value;

            } else {

                System.out.println("Error! Number must be greater than or equal to " + min + ", and less than or equal to " + max + ".");

            }
        }
    }

    /**
     * This method will read a specified file into an array, and if the user wishes and the file is not found, will create the target file
     * @param fileName String, The name/path of the target file
     * @param createNew Boolean, if true, create target file if not already found
     * @return Returns the contents of a file with each line being a term in an ArrayList
     * @throws FileNotFoundException
     */
    public static ArrayList<String> getFileData(String fileName, boolean createNew) throws FileNotFoundException{

        ArrayList<String> fileContents = new ArrayList<String>();

        try{

            BufferedReader in = new BufferedReader(new FileReader(fileName));

            String curLine = in.readLine();
            fileContents.add(curLine);

            while(curLine != null) {
                curLine = in.readLine();
                fileContents.add(curLine);
            }

            
            fileContents.remove(null);
            fileContents.remove("");

            in.close();

            

        }catch (FileNotFoundException e) {
            if(createNew == true){
                //Create a new file if not found
                File newFile = new File(fileName);
                
                try {
                    newFile.createNewFile();
                    System.out.println("File '"+ fileName +"'' wasn't found, and so it was created!");
                } catch (IOException e1) {
    
                    e1.printStackTrace();
                    
                }
            }else{
                throw e;
            }
            
        }catch (IOException e1) {
            e1.printStackTrace();
        }
        return fileContents;
    }

    /**
     * Appends the given input string to a specified file
     * @param fileName String, Name/path of the target file
     * @param input String, Text to append to target file
     * @throws IOException
     */
    public static void writeToFile(String fileName, String input) throws IOException {
        
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName,true)));
            out.println(input);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
    }

    /**
     * Overwrites the contents of a specified file with the given input
     * @param fileName String, The name/path of the target file
     * @param input String, The text to replace the contents of the file with
     * @throws IOException
     */
    public static void overwriteToFile(String fileName, String input) throws IOException {

        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            out.println(input);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
    }

    /**
     * Checks if a given file exists
     * @param fileName String, Name/Path of the target file
     * @return Returns True/False if file exists or not
     */
    public static boolean doesFileExist(String fileName){
        File file = new File(fileName);
        return file.exists() && !file.isDirectory();
    }



    //textField validation shenanigans go down here

    public static class Validation{
    
        public Validation() { 
             
        }
        
        
        public boolean isPresent(String value) {
            if (value.isEmpty()) {
                return false;
            }else{
                return true;
            }
        }

        public boolean isDouble(String value) {
            try {
                Double.parseDouble(value);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
        
        public boolean isInteger(String value) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    } 
    
    /**
     * This method validates the information in a TextField
     * @param textField The TextField Object
     * @return Returns true or false
     */
    /* 
    public static Boolean validateField(TextField textField){
        Validation v = new Validation();
        if(v.isPresent(textField.getText())){
            return true;
        }else{
            return false;
        }
    }

    public static Boolean validateFieldInt(TextField textField){
        Validation v = new Validation();
        if(validateField(textField)){
            if(v.isInteger(textField.getText())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static Boolean validateFieldDouble(TextField textField){
        Validation v = new Validation();
        if(validateField(textField)){
            if(v.isDouble(textField.getText())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    */

}