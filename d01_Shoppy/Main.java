package d01_Shoppy;

import d01_Shoppy.login.*;
import static d01_Shoppy.login.LoginService.*;
import static d01_Shoppy.login.LoginResult.*;
import d01_Shoppy.customer.Customer;
import d01_Shoppy.customer.CustomersData;
import d01_Shoppy.product.*;
import d01_Shoppy.product.productsData.*;
import d01_Shoppy.product.productsData.ProductsData;

import java.util.Scanner;

public class Main{

    public static boolean editProfile(Scanner scanner, Customer loggedCustomer){
        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ProductsData productsData = new ProductsData();
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
        System.out.println("This is the menu, write the option that you want: ");
        boolean menuOpen = true;
        while (menuOpen){
            System.out.println("\t1.\tBuy a product.");
            System.out.println("\t2.\tEdit my profile");
            System.out.println("\t3.\tExit");
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            int option;
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Wrong option selected. Please enter a valid number.");
                continue;
            }
            if (option > 3 || option < 0){
                continue;
            }
            if (option == 1)
                menuOpen = productsData.makingABuy(scanner, loggedCustomer);
            else if (option == 2)
                menuOpen = editProfile(scanner, loggedCustomer);
            else if (option == 3) {
                System.out.println("Logging out. Thanks for your visit");
                scanner.close();
                return;
            }
        }

        scanner.close();
    }
}
