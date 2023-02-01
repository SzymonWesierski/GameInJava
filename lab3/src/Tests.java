import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    public Point pointObject(){
        Point point = new Point();
        return point;
    }

    public Segment segmentObject(){
        Segment odcinek  = new Segment();
        return odcinek;
    }

    @Test
    public void getSetXTest() {
        int x = 5;
        Point point = pointObject();
        point.setX(x);

        assertEquals(x,point.getX(),0.1);
    }

    @Test
    public void getSetYTest() {
        int y = 6;
        Point point = pointObject();
        point.setY(y);

        assertEquals(y,point.getY(),0.1);
    }

    @Test
    public void getSetATest() {
        Segment odcinek = segmentObject();
        Point point1 = pointObject();
        odcinek.setA(point1);

        assertEquals(point1,odcinek.getA());
    }

    @Test
    public void getSetBTest() {
        Segment odcinek = segmentObject();
        Point point1 = pointObject();
        odcinek.setB(point1);

        assertEquals(point1,odcinek.getB());
    }

    @Test
    public void lenghtTest() {
        Point point1 = new Point(2,5);
        Point point2 = new Point(4,5);
        Segment odcinek = new Segment(point1,point2);


        assertEquals(2, odcinek.lenght(),0.1);
    }

    @Test
    public void segmentXYShiftTest() {
        Point point1 = new Point(2,5);
        Point point2 = new Point(4,5);
        Segment odcinek = new Segment(point1,point2);
        odcinek.shift(2,2);

        assertEquals(4,odcinek.getA().getX(),0.1);
        assertEquals(7,odcinek.getA().getY(),0.1);
        assertEquals(6,odcinek.getB().getX(),0.1);
        assertEquals(7,odcinek.getB().getY(),0.1);
    }

    @Test
    public void segmentPointShiftTest() {
        Point point1 = new Point(2,5);
        Point point2 = new Point(4,5);
        Point point3 = new Point(2,2);
        Segment odcinek = new Segment(point1,point2);
        odcinek.shift(point3);

        assertEquals(4,odcinek.getA().getX(),0.1);
        assertEquals(7,odcinek.getA().getY(),0.1);
        assertEquals(6,odcinek.getB().getX(),0.1);
        assertEquals(7,odcinek.getB().getY(),0.1);
    }

    @Test
    public void pointPointShiftTest() {
        Point point1 = new Point(2,5);
        Point point2 = new Point(2,2);
        point1.shift(point2);

        assertEquals(4,point1.getX(),0.1);
        assertEquals(7,point1.getY(),0.1);
    }

    @Test
    public void pointXYShiftTest() {
        Point point1 = new Point(2,5);
        point1.shift(2,2);

        assertEquals(4,point1.getX(),0.1);
        assertEquals(7,point1.getY(),0.1);
    }

    @Test
    public void toStringtTest() {
        Point a = new Point(3,5);
        Point b = new Point(4,6);
        Segment segment = new Segment(a, b);

        assertEquals("(3,5)",a.toString());
        assertEquals("(4,6)",b.toString());
        assertEquals("(3,5)-(4,6)",segment.toString());
    }

    @Test
    public void numberPointsTest() {
        Point a = new Point();
        Point b = new Point(4,6);

        assertEquals(2, Point.numberPoints());
    }

    @Test
    public void maxMinSegmentTest() {
        assertEquals(2, Segment.maxSegment(),0.1);
        assertEquals(0, Segment.minSegment(),0.1);
    }

    @Test
    public void centerDistanceTest() {
        Point a = new Point(4,6);
        double dist = a.centerDistance();

        assertEquals(7.21,dist,0.01);
    }







}
