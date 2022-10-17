import java.util.Scanner;

public class zad3 {
    public static void main(String[] args) {
        int n;
        float min =1, max =0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbe:");
        n = scanner.nextInt();

        float[] tab = new float[n];

        for(int i = 0 ; i<n ; i++){
            tab[i] = (float) Math.random();
        }

        System.out.println("Wylosowane liczby: ");

        for (float pom: tab) {
            System.out.println(pom);
            if(pom >= max)
                max = pom;
            if(pom <= min)
                min = pom;
        }
        System.out.println("\nNajmniejsza liczba: "+min+", najwieksza: "+max);
    }
}
