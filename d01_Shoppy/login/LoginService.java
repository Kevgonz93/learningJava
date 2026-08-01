package d01_Shoppy.login;

import d01_Shoppy.customer.Customer;
import d01_Shoppy.customer.CustomersData;

import java.util.Scanner;

import static java.lang.Thread.sleep;
import static d01_Shoppy.customer.Customer.*;
import static d01_Shoppy.customer.CustomersData.*;

public class LoginService {
    public static LoginResult loginProcess(String input, CustomersData allCustomers, Scanner scanner){
        try {
            int customerId = Integer.parseInt(input);
            if (customerId < 0) {
                System.out.println("Invalid input. Please enter a valid ID.");
                return new LoginResult(false, null);}
            if (customerId == 0){
                Customer newCustomer = allCustomers.addCustomer(scanner);
                return new LoginResult(true, newCustomer);
            }
            Customer foundCustomer = allCustomers.getCustomerById(customerId);
            if (foundCustomer != null){
                return new LoginResult(true, foundCustomer);
            }
            else{
                System.out.println("Customer with id \"" + customerId + "\" not founded");
                return new LoginResult(false, null);
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a numerical ID, '0', or type 'exit'/'quit'.");
            return new LoginResult(false, null);}
    }

    public static boolean verificationCID(int id)
    {
        System.out.print("Searching customer ID");
        for (int i = 0; i < 3; i++)
        {
            try {
                System.out.print(".");
                sleep(1000);
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

    public static boolean initialsInstructions(boolean started){
        if (!started){
            System.out.println("====================================");
            System.out.println("     WELCOME TO SHOPPY SYSTEM       ");
            System.out.println("====================================");
        }
        System.out.println("Please, enter your Customer ID.");
        System.out.println("If you dont have one, please write '0' for create a new customer.");
        System.out.println("Remember, if you want quit just write 'exit' o 'quit'.");
        return true;
    }

    public static boolean isExit(String input){
        if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")){
            System.out.println("Exiting Shoppy System. Goodbye!");
            return true;}
        return false;
    }

}
