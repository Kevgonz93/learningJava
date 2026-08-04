package d01_Shoppy.product.productsData;

import d01_Shoppy.product.Product;
import d01_Shoppy.product.PhysicalProduct;
import d01_Shoppy.product.DigitalProduct;
import d01_Shoppy.product.enums.TypeLicence;

import static d01_Shoppy.product.productsData.Create.*;
import static d01_Shoppy.product.productsData.Search.*;
import static d01_Shoppy.product.productsData.InputUtils.*;

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
        stock.add(new PhysicalProduct(nextId++, "iPhone 15", 800.00, 800, 45));
        stock.add(new PhysicalProduct(nextId++, "iPad Air", 700.00, 1200, 72));
        stock.add(new DigitalProduct(nextId++, "Final Cut Pro", 320.00, 0, TypeLicence.PERPETUA, 1));
        stock.add(new PhysicalProduct(nextId++, "Mac Book Pro 14\'\' M5", 2300.00, 1550, 151));
        stock.add(new PhysicalProduct(nextId++, "Mac Book Air 13\'\' M5", 1430.00, 1230, 52));
    }

    public Product addProduct(Scanner scanner){
        System.out.println("\n===== NEW PRODUCT REGISTRATION =====");

        String inputType = readInput(scanner,"Please, write 0 if the new product is a Physical Product. Or write 1 if it is Digital Product");
        Product newProduct;
        if (inputType.equalsIgnoreCase("0"))
            newProduct = addPhysicalProduct(scanner, nextId++);
        else
            newProduct = addDigitalProduct(scanner, nextId++);
        if (newProduct != null)
            stock.add(newProduct);
        return newProduct;
    }

    public List<Product> sByPrices(Scanner scanner){
        System.out.println("\n===== SEARCHING PRODUCTS BY PRICE =====");
        System.out.println("If you wanna cancel, write exit or quit.");
        boolean isFounded = false;
        int valuesInputs = 0;
        List<Product> toFound = new ArrayList<>();

        while (!isFounded){
            double minPrice = 0.00;
            double maxPrice = 0.00;
            if (valuesInputs == 0){
                String minInput = readInput(scanner, "Please, write the min price");
                if (isCancellation(minInput))
                    return cancelSearch();
                minPrice = Double.parseDouble(minInput);
                if (minPrice < 0){
                    System.out.println("Invalid price. Please, try again.");
                    continue;}
                valuesInputs++;
            }
            String maxInput = readInput(scanner, "Please, write now the max price");
            if (isCancellation(maxInput))
                return cancelSearch();
            maxPrice = Double.parseDouble(maxInput);
            if (maxPrice < 0){
                System.out.println("Invalid price. Please, try again.");
                continue;}
            toFound = getProductsByFinalPrice(minPrice, maxPrice, stock);
            isFounded = true;
        }
        return toFound;
    }

    public Product sById(Scanner scanner, int productId){
        System.out.println("\n===== SEARCHING PRODUCTS BY ID =====");
        System.out.println("If you wanna cancel, write exit or quit.");
        boolean isFounded = false;
        Product toFound = null;

        while (!isFounded){
            try {
                String input = readInput(scanner, "Please, write the id product.");
                if (isCancellation(input))
                    return cancelSearch();
                toFound = getProductById(Integer.parseInt(input), stock);
                if (toFound != null)
                    isFounded = true;
                else
                    System.out.println("Product not found. Try again.");
            } catch (NumberFormatException e){
                System.out.println("Format invalid. Please, try again");
            }
        }
        return toFound;
    }

    public Product sByName(Scanner scanner, String productName){
        System.out.println("\n===== SEARCHING PRODUCTS BY NAME =====");
        System.out.println("If you wanna cancel, write exit or quit.");
        boolean isFounded = false;
        Product toFound = null;

        while (!isFounded){
            String nameInput = readInput(scanner, "Please, write the name for search");
            if (isCancellation(nameInput))
                return cancelSearch();
            toFound = getProductByName(nameInput, stock);
            if (toFound != null)
                isFounded = true;
            else
                System.out.println("Product not found. Try again.");
        }
        return toFound;
    }

    public void buyOneProduct (Product product){
        int quantity = product.getQuantity();
        product.setQuantity(quantity - 1);
    }
}
