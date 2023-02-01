public class Main {
    public static void main(String[] args) {
        Point a = new Point(3,5);
        Point b = new Point(4,6);
        Segment segment = new Segment(a, b);

        System.out.println(a);
        System.out.println(b);
        System.out.println(segment);
    }
}