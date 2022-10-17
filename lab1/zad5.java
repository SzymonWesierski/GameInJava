import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zad5 {
    public static List<Integer> pierwsze(int n)
    {
        List<Integer> numbers = new ArrayList<Integer>();
        boolean test = true;

        for( int i = 2; i < n; i++) {
            test = true;
            if (i > 2) {
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        test = false;
                        break;
                    }
                }

                if(test == true){
                numbers.add(i);
                }
            }
        }
        return numbers;

    }

    public static void main(String[] args) {
        
        int n;
        List<Integer> numbers = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbe:");
        n = scanner.nextInt();



        numbers = pierwsze(n);

        System.out.println(numbers);

        for (int i = 8 ; i <= n; i+=2) {
            for (int number1: numbers) {
                for (int number2: numbers) {
                    if(number1+number2 == i){
                        System.out.println("liczba"+i+"\nLiczba jest suma: "+number1+"+"+number2+"="+i);
                    }

                }

            }

        }
    }
}
