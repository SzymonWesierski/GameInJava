public class Juice extends Product{
    private double capacity = 0;
    private String flavour = "Unknown";

    public double getCapacity() {
        return capacity;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public Juice(String name, double weight, double price, double capacity, String flavour){
        super.setName(name);
        super.setPrice(price);
        super.setWeight(weight);
        this.capacity = capacity;
        this.flavour = flavour;
    }

    public Juice(){
        super.setName(getName());
        super.setPrice(getPrice());
        super.setWeight(getWeight());
        this.capacity = getCapacity();
        this.flavour = getFlavour();
    }
}
