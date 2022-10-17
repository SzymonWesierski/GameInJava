import java.util.Scanner;

public class zad2 {
    public static void main(String[] args) {
        int p;
        float a, n;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wiek w sekundach :");
        n = scanner.nextLong();

        float[] tablica = {0.2408467f, 0.61519726f, 1, 1.8808158f, 11.862615f, 29.447498f, 84.016846f, 164.79132f};

        System.out.println("Wybierz planete: \n 1 - Merkury \n 2 - Wensu \n 3 - Ziemia \n 4 - Mars \n 5 - Jowisz \n 6 - Saturn \n 7 - Uran \n 8 - Neptun");
        p = scanner.nextInt();

        a = n / 31557600f * tablica[p-1];

        System.out.printf("Wiek: %.2f lat ", a);






    }
}
