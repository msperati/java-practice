package esercizi;

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

    public static List<String> getParolePalindrome4(List<String> parole) {
        return parole.stream().filter(parola -> isPalindromoRicorsivo(parola)).collect(Collectors.toList());
    }

    // Approccio 1:
    // -controllo se la parola in input è null o stringa vuota (in tal caso restituisco subito false)
    // -stabilisco qual è il carattere centrale della parola.
    // (se la stringa ha lunghezza dispari il carattere sarà dato da (parola.length / 2) altrimenti da (parola.length / 2)
    // -scorro la stringa in input fino ad arrivare a metà:
    // -confronto il primo carattere con l'ultimo, il secondo col penultimo, il terzo col terzultimo etc...
    // -se uno di questi confronti restituisce false, tutto il metodo restituisco subito false
    // (non ha senso continuare a scorrere tutta una stringa potenzialmente lunghissima se ho già trovato una discrepanza)
    // -diversamente, se arriva a metà parola indenne, vuol dire che è palindroma e restituisco true
    public static boolean isPalindromo1(String parola) {
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

    // Approccio 2:
    // -controllo se la parola in input è null o stringa vuota (in tal caso restituisco subito false)
    // -creo una nuova variabile di tipo String denominata parolaInversa
    // -inizio a scorrere la parola in input dalla fine all'inizio, aggiungendo di volta in volta i caratteri a parolaInversa
    // -se parolaInversa è uguale a parola (senza tener conto di maiuscole o minuscole), allora è palindroma
    public static boolean isPalindromo2(String parola) {
        if (parola == null || parola.isEmpty()) {
            return false;
        }
        int lunghezzaParola = parola.length();
        String parolaInversa = "";
        for (int i = lunghezzaParola - 1; i >= 0; i--) {
            parolaInversa += String.valueOf(parola.charAt(i));
        }
        return parolaInversa.equalsIgnoreCase(parola);
    }

    // Approccio 3:
    // identico al metodo di sopra, ma più elegantemente abbiamo ottenuto la stringa parolaInversa
    // tramite il metodo reverse() dell'oggetto StringBuilder(parola)
    // (a sua volta riconvertita poi in stringa con toString()
    public static boolean isPalindromo3(String parola) {
        if (parola == null || parola.isEmpty()) {
            return false;
        }
        String parolaInversa = new StringBuilder(parola).reverse().toString();
        return parolaInversa.equalsIgnoreCase(parola);
    }

    // Approccio 4:
    // -usiamo la ricorsione (un metodo che chiama sè stesso)
    // -solito controllo se la parola in input è null o stringa vuota (in tal caso restituisco subito false)
    // -confrontiamo il primo carattere con l'ultimo
    // -se sono diversi restituiamo subito false, se sono uguali, continuiamo a invocare il metodo isPalindromoRicorsivo
    // su parola, stavolta privata del primo e dell'ultimo carattere
    // (ad esempio, se la parola in input era ANNA, ora continuerò a fare lo stesso con la sottostringa "NN")
    // - se a furia di rimpicciolire la stringa otteniamo una stringa di due caratteri (parola originaria di lunghezza pari)
    // o una stringa di un solo carattere (parola originaria di lunghezza dispari)
    // interrompiamo la ricorsione e determiniamo che la parola originaria è palindroma
    public static boolean isPalindromoRicorsivo(String parola) {
        if (parola == null || parola.isEmpty()) {
            return false;
        }
        if (parola.toUpperCase().charAt(0) == parola.toUpperCase().charAt(parola.length() - 1)) {
            return parola.length() == 2 || parola.length() == 1 ? true : isPalindromoRicorsivo(parola.substring(1, parola.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {

        List<String> palindromi = getParolePalindrome(WORDS);
        System.out.println(palindromi);

        List<String> palindromi2 = getParolePalindrome2(WORDS);
        System.out.println(palindromi2);

        List<String> palindromi3 = getParolePalindrome3(WORDS);
        System.out.println(palindromi3);

        List<String> palindromi4 = getParolePalindrome4(WORDS);
        System.out.println(palindromi4);
    }

}
