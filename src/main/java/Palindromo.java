import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Palindromo {

    public static List<String> WORDS = Arrays.asList(new String[]{"anna", "cane", "gatto", "Otto", "", null, "12321"});

    public static List<String> getParolePalindrome(List<String> parole) {
        return parole.stream().filter(parola -> isPalindromo1(parola)).collect(Collectors.toList());
    }

    public static List<String> getParolePalindrome2(List<String> parole) {
        return parole.stream().filter(parola -> isPalindromo2(parola)).collect(Collectors.toList());
    }

    public static List<String> getParolePalindrome3(List<String> parole) {
        return parole.stream().filter(parola -> isPalindromo3(parola)).collect(Collectors.toList());
    }

    private static boolean isPalindromo1(String parola) {
        if (parola == null || parola.isEmpty()) {
            return false;
        }
        int metaParola = parola.length() % 2 == 0 ? parola.length() / 2 : (parola.length() / 2) + 1;
        for (int i = 0; i < metaParola; i++) {
            if (parola.toUpperCase().charAt(i) != parola.toUpperCase().charAt(parola.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromo2(String parola) {
        if (parola == null || parola.isEmpty()) {
            return false;
        }
        int lunghezzaParola = parola.length();
        String parolaInversa = "";
        for (int i = lunghezzaParola -1; i >=0; i--) {
            parolaInversa += String.valueOf(parola.charAt(i));
        }
        return parolaInversa.equalsIgnoreCase(parola);
    }

    private static boolean isPalindromo3(String parola) {
        if (parola == null || parola.isEmpty()) {
            return false;
        }
        String reverse = new StringBuilder(parola).reverse().toString();
        return reverse.equalsIgnoreCase(parola);
    }

    private static boolean isPalindromoRicorsivo(String parola) {
        if (parola == null) {
            return false;
        }
        if (parola.length() == 1 || parola.isEmpty()) {
            return true;
        }
        if (parola.toUpperCase().charAt(0) == parola.toUpperCase().charAt(parola.length() - 1)) {
            return isPalindromoRicorsivo(parola.substring(1, parola.length() - 1));
        }
        return false;
    }



    public static void main (String[] args) {

        /*List<String> palindromi = getParolePalindrome(WORDS);
        System.out.println(palindromi);

        List<String> palindromi2 = getParolePalindrome2(WORDS);
        System.out.println(palindromi2);

        List<String> palindromi3 = getParolePalindrome3(WORDS);
        System.out.println(palindromi3);*/

        for (String parola : WORDS) {
            System.out.println("PAROLA: " + parola + " E' PALINDOMA " + isPalindromoRicorsivo(parola));
        }

    }

}
