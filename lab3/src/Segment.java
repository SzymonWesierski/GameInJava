public class Segment {
    private Point a;
    private Point b;

    public Point getA(){
        return a;
    }

    public Point getB(){
        return b;
    }

    public void setA(Point a1){
        a = a1;
    }

    public void setY(Point b1){
        b = b1;
    }

    public Segment(){
        this.a = new Point( 0, 0);
        this.b = new Point( 0, 0);
    }

    public Segment(Point pkt1, Point pkt2){
        this.a = new Point(pkt1.getX(), pkt1.getY());
        this.b = new Point(pkt2.getX(), pkt2.getY());
    }

    public Segment(double wspX1, double wspY1, double wspX2, double wspY2){
        this.a = new Point( wspX1, wspY1);
        this.b = new Point( wspX2, wspY2);
    }

    public Segment(Point a, double x2, double y2){
        this.a = new Point(a);
        this.b = new Point(x2, y2);
    }

}
