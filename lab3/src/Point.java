
public class Point {
    private double x, y;
    private static int num = 0;
    private final int centerX = 0;
    private final int centerY = 0;

    public Point(){
        this.x = 0;
        this.y = 0;
        num++;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
        num++;
    }

    public void shift(double vx, double vy){
        this.x += vx;
        this.y += vy;
    }

    public void shift(Point point){
        this.x += point.x;
        this.y += point.y;
    }

    public static double distance(Point punkt1, Point punkt2){
        double dist = Math.sqrt((punkt2.getX() - punkt1.getX())*(punkt2.getX() - punkt1.getX())+(punkt2.getY() - punkt1.getY())*(punkt2.getY() - punkt1.getY()));
        return dist;
    }

    public static double distance(double x1,double y1,double x2,double y2){
        double dist = Math.sqrt((x2 - x1)*(x2 - x1)+(y2 - y1)*(y2 - y1));
        return dist;
    }

    public static int numberPoints(){
        return num;
    }

    public double centerDistance(){
        double dist = distance(this.x,this.y,centerX,centerY);
        return dist;
    }

    @Override
    public String toString() {
        return "("+Math.round(x)+","+Math.round(y)+")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


}
