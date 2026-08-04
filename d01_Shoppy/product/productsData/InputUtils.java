package d01_Shoppy.product.productsData;

import d01_Shoppy.product.Product;

import java.util.Scanner;

public class InputUtils {
    public static String readInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    public static boolean isCancellation(String input){
        return input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit");
    }

    public static <T> T cancelCreation(){
        System.out.println("Creation cancelled...");
        return null;
    }

    public static <T> T  cancelSearch(){
        System.out.println("Search cancelled...");
        return null;
    }
}
