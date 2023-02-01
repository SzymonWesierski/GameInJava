import static java.lang.Math.*;

public class zad4 {
    public static int[] generator(int number, int min, int max)
    {
        int[] tab = new int[number];
        for(int i=0;i<number;i++)
        {

            tab[i]=(int)(Math.random()*(max-min+1)+min);
        }
        return tab;
    }
}
