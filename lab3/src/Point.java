public class Point {
    private double x;
    private double y;

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x1){
        this.x = x1;
    }

    public void setY(double y1){
        this.y = y1;
    }

    public Point(double x1, double y1){
        this.x = x1;
        this.y = y1;
    }

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(Point pkt){
        x = pkt.x;
        y = pkt.y;
    }

    public void shift(Point pkt){
        this.x += pkt.x;
        this.y += pkt.y;
    }

    public void shift(double wx, double wy){
        this.x += wx;
        this.y += wy;
    }


}