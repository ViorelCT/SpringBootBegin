package com.springboot.tutorial;
import java.util.Scanner;

public class Calculator {

    private final Scanner scanner;

    public Calculator(){
        scanner = new Scanner(System.in);
    }

    public int inputNumber(String message){
        System.out.print(message);
        return scanner.nextInt();
    }

    public int sum(){
        System.out.print("How many numbers do you want to add: ");
        int n =  scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++){
            int number = inputNumber("Please enter a number " + i + ": ");
            sum += number;
        }
        return sum;
    }

    public int subtract() {
        System.out.print("How many numbers do you want to subtract: ");
        int n = scanner.nextInt();
        int subtract = 0;
        for (int i = 1; i <= n; i++) {
            int number = inputNumber("Please enter a number " + i + ": ");
            if (i == 1) {
                subtract = number;
            } else {
                subtract -= number;
            }
        }
        return subtract;
    }

    public int multiply(){
        System.out.print("How many numbers do you want to multiply: ");
        int n =  scanner.nextInt();
        int multiply = 0;
        for (int i = 1; i <= n; i++){
            int number = inputNumber("Please enter a number " + i + ": ");
            if (i == 1) {
                multiply = number;
            } else {
                multiply *= number;
            }
        }
        return multiply;
    }

    public int divide(){
        System.out.print("How many numbers do you want to divide: ");
        int n =  scanner.nextInt();
        int result = 0;
        for (int i = 1; i <= n; i++) {
            boolean isValid = false;

            while(!isValid) {
                int number = inputNumber("Please enter a number " + i + ": ");
                try {
                    if (i == 1) {
                        result = number;
                    } else {
                        result = result / number;
                    }
                    isValid = true;
                } catch (ArithmeticException e) {
                    System.out.println("Error: You can't divide by 0. Try again.");
                }
            }
        }
        return result;
    }

    public void closeScanner(){
        scanner.close();
    }

}
