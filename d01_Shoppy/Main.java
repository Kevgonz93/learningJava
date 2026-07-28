package d01_Shoppy;

import d01_Shoppy.cart.*;
import d01_Shoppy.customer.*;
import d01_Shoppy.customer.enums.*;
import d01_Shoppy.product.*;
import d01_Shoppy.product.enums.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    public static boolean verificationCID(int id)
    {
        String message;
        if (id == 0)
            message = "Preparing for create a new customer";
        else
            message = "Searching customer ID";
        System.out.print(message);
        for (int i = 0; i < 3; i++)
        {
            try {
                System.out.print(".");
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                if (id == 0)
                    System.out.println("We couldn't create a new user. Please, try again.");
                else
                    System.out.println("We couldnt find you ID. Please try again.");
                return false;
            }
        }
        System.out.print("\n");
        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean isLoggin = false;
        int customerId = -1;

        System.out.println("====================================");
        System.out.println("     WELCOME TO SHOPPY SYSTEM       ");
        System.out.println("====================================");

        while (!isLoggin){
            System.out.println("Please, enter your Customer ID.");
            System.out.println("If you dont have one, please write '0' for create a new customer.");
            System.out.println("Remember, if you want quit just write 'exit' o 'quit'.");
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")){
                System.out.println("Exiting Shoppy System. Goodbye!");
                scanner.close();
                return;
            }
            try {
                customerId = Integer.parseInt(input);
                if (customerId < 0) {
                    System.out.println("Invalid input. Please enter a valid ID.");
                    continue;}
                isLoggin = verificationCID(customerId);
                if (!isLoggin)
                    System.out.println("Something went wrong. Please try again.");}
            catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a numerical ID, '0', or type 'exit'/'quit'.");}
        }
        System.out.println("Login successful! Lets go!");
        scanner.close();
    }
}
