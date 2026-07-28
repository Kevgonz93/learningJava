package d01_Shoppy.product.enums;

public enum CostDelivery {
    LIGERO(1.0, 2.0),
    MEDIANO(5.0, 5.50),
    PESADO(Double.MAX_VALUE, 10);

    private final double weight;
    private final double cost;

    CostDelivery(double weightMax, double cost){
        this.weight = weightMax;
        this.cost = cost;
    }

    public double getCost(){return cost;}
    public double getWeightMax() {return weight;}

    public static CostDelivery getCostByWeight(double weight){
        for (CostDelivery cost : CostDelivery.values()){
            if (weight < cost.getWeightMax()){
                return cost;
            }
        }
        return PESADO;
    }
}
