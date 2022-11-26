public class Circle implements RoundFigure {
    private double r;

    public Circle(double r){
        this.r = r;
    }

    public Circle(){
        this.r = 0;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getArea(){
        return pi * (r * r);
    }

    @Override
    public double getPerimeter() {
        return 2 * pi * r;
    }

    public double getRadius(){
        return this.r;
    }

}
