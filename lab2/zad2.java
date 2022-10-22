public class zad2 {

    public static boolean palindrome(String str) {
        int h = str.length();

        int kk = 0;
        int k = (h - 1);
        for (int i = 0; i < h; i++) {

            if (str.charAt(i) != str.charAt(k)) {
                kk = 1;
                break;
            }
            k--;
        }

        if (kk == 1)
            return false;
        else {
            return true;
        }
    }
}
