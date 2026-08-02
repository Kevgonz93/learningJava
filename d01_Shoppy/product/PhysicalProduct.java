package d01_Shoppy.product;

import d01_Shoppy.product.enums.CostDelivery;

public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct (int id, String name, double priceInit, double weight, int quantity){
        super(id, name, priceInit, quantity);
        this.weight = weight;
    }

    @Override
    public double getFinalPrice(){
        double costDelivery = CostDelivery.getCostByWeight(this.weight).getCost();
        return getPriceInit() + costDelivery;
    }

    public double getWeight(){
        return this.weight;
    }

    public void setWeight(double newWeight){
        this.weight = newWeight;
    }
}