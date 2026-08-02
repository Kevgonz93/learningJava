package d01_Shoppy.product;

import d01_Shoppy.product.enums.TypeLicence;

public class DigitalProduct extends Product implements Discount {
    private double sizeMB;
    private TypeLicence typeLicence;

    public DigitalProduct (int id, String name, double priceInit, double sizeMB, TypeLicence typeLicence, int quantity){
        super(id, name, priceInit, quantity);
        this.sizeMB = sizeMB;
        this.typeLicence = typeLicence;
    }

    @Override
    public double getFinalPrice(){return getPriceInit() + this.typeLicence.getCostLicence();}

    public double getSizeMB(){return sizeMB;}

    public void setSizeMB(double sizeMB){this.sizeMB = sizeMB;}

    public TypeLicence getTypeLicence(){return typeLicence;}

    public void setTypeLicence(TypeLicence typeLicence){this.typeLicence = typeLicence;}
}
