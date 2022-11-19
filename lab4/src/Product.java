public abstract class Product {
    private String name = "Unknown";
    private double weight = 0;
    private double price = 0;

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(){
        this.name = getName();
        this.weight = getWeight();
        this.price = getPrice();
    }

    public Product(String product_name, double product_weight, double product_price){
        this.name = product_name;
        this.price = product_price;
        this.weight = product_weight;
    }
}
