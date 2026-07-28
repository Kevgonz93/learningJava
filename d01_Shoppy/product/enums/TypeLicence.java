package d01_Shoppy.product.enums;

public enum TypeLicence {
    MENSUAL(5.0),
    ANUAL(50.0),
    PERPETUA(200.0);

    private final double costLicence;

    TypeLicence(double costLicence){this.costLicence = costLicence;}

    public double getCostLicence(){return costLicence;}
}
