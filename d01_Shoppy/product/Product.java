package d01_Shoppy.product;

public abstract class Product implements Discount{
    private int id;
    private String name;
    private int quantity;
    private double priceInit;

    public Product (int id, String name, double priceInit, int quantity)
    {
        this.id = id;
        this.name = name;
        this.priceInit = priceInit;
        this.quantity = quantity;
    }

    public abstract double getFinalPrice();

    public int getId(){
        return id;
    }

    public void setId(int newId){
        this.id = newId;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public double getPriceInit(){
        return priceInit;
    }

    public void setPriceInit(double newPriceInit){
        this.priceInit = newPriceInit;
    }

    @Override
    public void makeDiscount(double percentage){
        double result = this.getPriceInit() * ((100.00 - percentage)/100);
        this.setPriceInit(result);}

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
