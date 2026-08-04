package d01_Shoppy.product.productsData;

import d01_Shoppy.product.DigitalProduct;
import d01_Shoppy.product.PhysicalProduct;
import d01_Shoppy.product.enums.TypeLicence;

import java.util.Scanner;

import static d01_Shoppy.product.productsData.InputUtils.*;

public class Create {
    public static PhysicalProduct addPhysicalProduct(Scanner scanner, int nextId){
        System.out.println("== You are adding a new PHYSICAL PRODUCT. ==");
        System.out.println("If you wanna cancel, write exit or quit.");
        String name = readInput(scanner, "Enter product's name: ");
        if (isCancellation(name))
            return cancelCreation();

        String inputPrice = readInput(scanner, "Enter initial price: ");
        if (isCancellation(inputPrice))
            return cancelCreation();
        double initalPrice;
        try {initalPrice = Double.parseDouble(inputPrice);}
        catch (NumberFormatException e){
            System.out.println("Invalid price format. Creation cancelled.");
            return null;
        }

        String inputWeight = readInput(scanner, "Enter weight in gr ");
        if (isCancellation(inputWeight))
            return cancelCreation();
        double weight;
        try{weight = Double.parseDouble(inputWeight);}
        catch (NumberFormatException e) {
            System.out.println("Invalid weight format. Creation cancelled.");
            return null;
        }

        String inputQuantity = readInput(scanner, "Enter quantity: ");
        if (isCancellation(inputQuantity))
            return cancelCreation();
        int quantity;
        try{ quantity = Integer.parseInt(inputQuantity);}
        catch (NumberFormatException e){
            System.out.println("Invalid weight format. Creation cancelled.");
            return null;
        }

        System.out.println("Physical product successfully added!");
        return new PhysicalProduct(nextId, name, initalPrice,weight, quantity);
    }

    public static DigitalProduct addDigitalProduct(Scanner scanner, int nextId){
        System.out.println("== You are adding a new DIGITAL PRODUCT. ==");
        System.out.println("If you wanna cancel, write exit or quit.");
        String name = readInput(scanner, "Enter product's name: ");
        if (isCancellation(name))
            return cancelCreation();

        String inputPrice = readInput(scanner, "Enter initial price: ");
        if (isCancellation(inputPrice))
            return cancelCreation();

        double initialPrice;
        try{initialPrice = Double.parseDouble(inputPrice);}
        catch (NumberFormatException e){
            System.out.println("Invalid price format. Creation cancelled.");
            return null;
        }

        String inputSize = readInput(scanner, "Enter size in MB: ");
        if (isCancellation(inputSize))
            return cancelCreation();
        double sizeMB;
        try{sizeMB = Double.parseDouble(inputSize);}
        catch (NumberFormatException e){
            System.out.println("Invalid size format. Creation cancelled.");
            return null;
        }

        String inputLicence = readInput(scanner, "Enter type of licence: ");
        if (isCancellation(inputLicence))
            return cancelCreation();
        TypeLicence typeLicence;
        try{ typeLicence = TypeLicence.valueOf(inputLicence.toUpperCase());}
        catch (IllegalArgumentException e){
            System.out.println("Invalid Type of Licence. Creation cancelled.");
            return null;
        }
        System.out.println("Digital product successfully added!");
        return new DigitalProduct(nextId, name,initialPrice, sizeMB, typeLicence, 1);
    }
}
