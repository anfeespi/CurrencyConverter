package com.alura.view;

import java.util.Scanner;

public class Console {
    private final Scanner scanner;

    public Console(){
        scanner = new Scanner(System.in);
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public int readInt(){
        try{
            return Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public double readDouble(){
        try{
            return Double.parseDouble(scanner.nextLine());
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public String readString(){
        return scanner.nextLine();
    }
}
