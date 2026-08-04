package d01_Shoppy.product.productsData;

import d01_Shoppy.product.DigitalProduct;
import d01_Shoppy.product.PhysicalProduct;
import d01_Shoppy.product.Product;
import d01_Shoppy.product.enums.TypeLicence;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

public class Search {
    public static Product getProductById(int productId, List<Product> stock){
        for(Product p : stock){
            if (p.getId() == productId)
                return p;
        }
        return  null;
    }

    public static Product getProductByName(String productName, List<Product> stock){
        for (Product p : stock){
            if (p.getName().equalsIgnoreCase(productName))
                return p;
        }
        return null;
    }

    public static List<Product> getProductsByFinalPrice(double min, double max, List<Product> stock){
        List<Product> result = new ArrayList<>();
        for (Product p : stock){
            if ((p.getFinalPrice() >= min) && (p.getFinalPrice() <= max))
                result.add(p);
        }
        return result;
    }

    public static List<PhysicalProduct> getPhysicalProducts(List<Product> stock){
        List<PhysicalProduct> result = new ArrayList<>();
        for (Product p : stock){
            if (p instanceof PhysicalProduct)
                result.add((PhysicalProduct) p);
        }
        return result;
    }

    public static List<DigitalProduct> getDigitalProducts(List<Product> stock){
        List<DigitalProduct> result = new ArrayList<>();
        for (Product p : stock){
            if (p instanceof DigitalProduct)
                result.add((DigitalProduct) p);
        }
        return result;
    }

    public static List<DigitalProduct> getDigitalsProductsByLicence(List<DigitalProduct> dpstock, TypeLicence licenceToSearch){
        List<DigitalProduct> result = new ArrayList<>();
        for (DigitalProduct p : dpstock){
            if (p.getTypeLicence() == licenceToSearch)
                result.add(p);
        }
        return result;
    }

    public int getStockOfOneById(int productId, List<Product> stock){
        Product product = getProductById(productId, stock);
        if (product != null)
            return product.getQuantity();
        return 0;
    }

    public int getStockOfOneByName(String nameProduct, List<Product> stock){
        Product product = getProductByName(nameProduct, stock);
        if (product != null)
            return product.getQuantity();
        return 0;
    }

}
