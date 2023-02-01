public class zad5 {

    public static String fixingKey(String text, String key)
    {
        String zdanieBezSpacji = fixingText(text);

        char[] tablicaKlucza = key.toCharArray();
        StringBuilder koncowyKlucz = new StringBuilder();

        int j = 0;
        int maks = tablicaKlucza.length;

        for (int i = 0; i < zdanieBezSpacji.length(); i++)
        {
            if(j<maks)
            {
                koncowyKlucz.append(tablicaKlucza[j]);
                j++;
            }
            else
            {
                j = 0;
                koncowyKlucz.append(tablicaKlucza[j]);
                j++;
            }
        }
        return koncowyKlucz.toString();
    }
    public static String fixingText(String text)
    {
        String[] words = text.split(" ");
        StringBuilder zdanieBezSpacji = new StringBuilder();
        for (String word : words) {
            zdanieBezSpacji.append(word);
        }
        return zdanieBezSpacji.toString();
    }
    public static String encrypt(String text, String key)
    {
        StringBuilder encryptedText = new StringBuilder();
        String readyKey = fixingKey(text,key);
        String readyText = fixingText(text);
        char[] textArray = readyText.toCharArray();
        char[] keyArray = readyKey.toCharArray();
        for(int i=0;i<readyText.length();i++)
        {
            encryptedText.append(array(textArray[i], keyArray[i]));
        }
        return encryptedText.toString();
    }

    public static char array(char wiersz, char kolumna)
    {
        int startPos = (int)wiersz - (int)'A';
        int offSet = (int)kolumna - (int)'A';

        char encrypted = (char)(startPos + offSet + 'A');
        if(encrypted > 'Z')
        {
            encrypted -= 26;
        }
        return  encrypted;
    }


}
