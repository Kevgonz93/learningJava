package d01_Shoppy.product;

import d01_Shoppy.product.enums.TypeLicence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsData {
    private final List<Product> stock;
    private int nextId;

    public ProductsData(){
        this.stock = new ArrayList<>();
        this.nextId = 1000;
        seedProductsData();
    }

    private void seedProductsData(){
        stock.add(new PhysicalProduct(nextId++, "iPhone 15", 800.00, 800));
        stock.add(new PhysicalProduct(nextId++, "iPad Air", 700.00, 1200));
        stock.add(new DigitalProduct(nextId++, "Final Cut Pro", 320.00, 0, TypeLicence.PERPETUA));
        stock.add(new PhysicalProduct(nextId++, "Mac Book Pro 14\'\' M5", 2300.00, 1550));
        stock.add(new PhysicalProduct(nextId++, "Mac Book Air 13\'\' M5", 1430.00, 1230));
    }

    public Product getProductoById(int productId){
        for(Product p : stock){
            if (p.getId() == productId)
                return p;
        }
        return  null;
    }

    private String readInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    private boolean isCancellation(String input){
        return input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit");
    }

    private <T> T cancelCreation(){
        System.out.println("Creation cancelled...");
        return null;
    }

    public PhysicalProduct addPhysicalProduct(Scanner scanner){
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

        System.out.println("Physical product successfully added!");
        return new PhysicalProduct(nextId++, name, initalPrice,weight);
    }

    public DigitalProduct addDigitalProduct(Scanner scanner){
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
        return new DigitalProduct(nextId++, name,initialPrice, sizeMB, typeLicence);
    }

    public Product addProduct(Scanner scanner){
        System.out.println("\n===== NEW PRODUCT REGISTRATION =====");
        String inputType = readInput(scanner,"Please, write 0 if the new product is a Physical Product. Or write 1 if it is Digital Product");
        Product newProduct;
        if (inputType.equalsIgnoreCase("0"))
            newProduct = addPhysicalProduct(scanner);
        else
            newProduct = addDigitalProduct(scanner);
        if (newProduct != null)
            stock.add(newProduct);
        return newProduct;
    }
}
