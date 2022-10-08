import java.util.Scanner;

public class zad1 {
    public static void right(int n){
        int i, j;

        for(i = 0; i<n ; i++){
            for(j = 0; j<=i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    System.out.println();
    }

    public static void upsidedownright(int n){
        int i, j;

        for(i = n; i>0 ; i--){
            for(j = 0; j<i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    System.out.println();
    }

    public static void left(int n){
        int i, j;

        for(i = n; i>0 ; i--){
            for(j = 0; j<n ; j++){
                if(j>=i-1){
                    System.out.print("*");
                }
                else if(j<i-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void upsidedownleft(int n){
        int i, j;

        for(i = n; i>0 ; i--){
            for(j = n; j>0 ; j--){
                if(j<=i){
                    System.out.print("*");
                }
                else if(j>i) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }



    public static void main(String[] args) {
        int n;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        right(n);
        upsidedownright(n);
        left(n);
        upsidedownleft(n);

    }
}