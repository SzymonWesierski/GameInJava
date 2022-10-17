import java.util.Scanner;

public class zad4 {
    public static void main(String[] args) {
        int n;
        String st1, st2, result = "", longer;
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Podaj slowo: ");
        st1 = scanner.next();
        System.out.println(" Podaj drugie slowo: ");
        st2 = scanner.next();


        if (st1.length() > st2.length()){
            n = st2.length();
            longer = st1.substring(n, st1.length());
        }
        else {n = st1.length();
            longer = st2.substring(n, st2.length());}

        for(int i =0 ; i<n; i++){
            result += st1.charAt(i);
            result += st2.charAt(i);
        }

        result += longer;

        System.out.println("Wynik to :" + result);


    }
}
