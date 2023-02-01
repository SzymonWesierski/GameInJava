public class Segment {
    private Point a;
    private Point b;
    private static double maxSeg = Integer.MIN_VALUE ;
    private static double minSeg = Integer.MAX_VALUE;

    public Segment(){
        Point a =new Point();
        this.a = a;
        Point b =new Point();
        this.b = b;

        double distance = Point.distance(a,b);

        if (distance > maxSeg)
            maxSeg = distance;
        if (distance < minSeg)
            minSeg = distance;
    }

    public Segment(Point a,Point b){
        this.a = a;
        this.b = b;

        double distance = Point.distance(a,b);

        if (distance > maxSeg)
            maxSeg = distance;
        if (distance < minSeg)
            minSeg = distance;
    }

    public Segment(double x1,double y1,double x2,double y2){
        Point a =new Point(x1,y1);
        this.a = a;
        Point b =new Point(x2,y2);
        this.b = b;
    }

    public Segment(double x,double y, Point b){
        Point a =new Point(x,y);
        this.a = a;
        this.b = b;
    }

    public void shift(Point pkt1, double x, double y){
        double pktx = pkt1.getX();
        double pkty = pkt1.getY();
        pkt1.setX(pktx + x);
        pkt1.setY(pkty + y);
    };

    public void shift(double x, double y){
        double ax = a.getX();
        double ay = a.getY();
        this.a.setX(ax + x);
        this.a.setY(ay + y);

        double bx = b.getX();
        double by = b.getY();
        this.b.setX(bx + x);
        this.b.setY(by + y);
    }

    public void shift(Point pkt){
        double pktx = pkt.getX();
        double pkty = pkt.getY();

        double ax = a.getX();
        double ay = a.getY();
        this.a.setX(ax + pktx);
        this.a.setY(ay + pkty);

        double bx = b.getX();
        double by = b.getY();
        this.b.setX(bx + pktx);
        this.b.setY(by + pkty);
    }

    public double lenght(){
        double dist = Math.sqrt((this.getB().getX() - this.getA().getX())*(this.getB().getX() - this.getA().getX())+(this.getB().getY() - this.getA().getY())*(this.getB().getY() - this.getA().getY()));
        return dist;
    }

    public static double maxSegment(){
        return maxSeg;
    }

    public static double minSegment(){
        return minSeg;
    }

    public String toString(){
        return a.toString()+"-"+ b.toString();
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setB(Point b) {
        this.b = b;
    }
}
