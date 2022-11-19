public class Monitor extends Product {
    private double screen_size = 0;
    private String resolution = "0x0";

    public double getScreen_size() {
        return screen_size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setScreen_size(double screen_size) {
        this.screen_size = screen_size;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Monitor(String name, double weight, double price, double screen_size, String resolution){
        super.setName(name);
        super.setPrice(price);
        super.setWeight(weight);
        this.screen_size = screen_size;
        this.resolution = resolution;
    }

    public Monitor(){
        super.setName(getName());
        super.setPrice(getPrice());
        super.setWeight(getWeight());
        this.screen_size = getScreen_size();
        this.resolution = getResolution();
    }
}
