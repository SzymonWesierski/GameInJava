public class Rectangle implements Figure {
    private double a;
    private double b;

    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }

    public Rectangle(){
        this.a = 0;
        this.b = 0;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getArea(){
        return this.a * this.b;
    }
    public double getPerimeter(){
        return 2*this.a + 2*this.b;
    }


}
