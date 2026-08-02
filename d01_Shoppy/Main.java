package d01_Shoppy;

import d01_Shoppy.customer.Customer;
import d01_Shoppy.customer.CustomersData;
import d01_Shoppy.login.*;
import static d01_Shoppy.login.LoginService.*;
import static d01_Shoppy.login.LoginResult.*;
import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CustomersData customersData = new CustomersData();
        Customer loggedCustomer = null;
        boolean started = false;
        boolean isLogged = false;
        while (!isLogged){
            started = initialsInstructions(started);
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (isExit(input)){
                scanner.close();
                return ;}
            LoginResult login = loginProcess(input, customersData, scanner);
            isLogged = login.success();
            if (isLogged)
            {
                loggedCustomer = login.customer();
                System.out.println("Welcome, " + loggedCustomer.getFirstName() + "!");
            }
        }

        System.out.println("Login successful! Lets go!");
        scanner.close();
    }
}
