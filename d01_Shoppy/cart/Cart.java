package d01_Shoppy.cart;

import d01_Shoppy.product.Product;
import d01_Shoppy.customer.Customer;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    private Customer customer;
    private List<Product> productList;

    public Cart(Customer customer){
        this.customer = customer;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product){this.productList.add(product);}

    public void deleteProduct(Product product){this.productList.remove(product);}

    public double getTotalPrice(){
        double total = 0.0;
        for (Product product : this.productList){
            total += product.getFinalPrice();
        }
        return total;
    }

    public void applyDiscount(double discount){
        for (Product product : this.productList){
            product.makeDiscount(discount);
        }
    }

    public Customer getCustomer(){return customer;}

    public void setCustomer(Customer customer){this.customer = customer;}

    public List<Product> getProductList(){return productList;}
}
