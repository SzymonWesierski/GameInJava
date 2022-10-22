public class zad3 {
    public static boolean checkBin(String bin) {
        int h = bin.length();

        for (int i = 0; i < h; i++) {
            if (bin.charAt(i) != '0' && bin.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }

    public static int numberZero(String bin){
        int h = bin.length();
        int number=0;

        for (int i = 0; i < h; i++) {
            if (bin.charAt(i) == '0') {
                number++;
            }
        }
        return number;
    }

    public static int numberOne(String bin){
        int h = bin.length();
        int number=0;

        for (int i = 0; i < h; i++) {
            if (bin.charAt(i) == '1') {
                number++;
            }
        }
        return number;
    }

    public static boolean theSameNumberBin(String bin){
        if (checkBin(bin)){
            if(numberZero(bin) == numberOne(bin)){
                return true;
            }
        }
        return false;
    }
}

