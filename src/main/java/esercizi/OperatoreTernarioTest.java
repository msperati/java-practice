package esercizi;

import static esercizi.Palindromo.isPalindromo3;

/**
 * Creare una classe OperatoreTernarioTest (+ il vostro nome) con i seguenti metodi statici:
 * <p>
 * - getAbsoluteValue, che prende in input un int e restituisce il valore assoluto di quel numero
 * <p>
 * - palindromo, prende in input una stringa e chiama il metodo statico isPalindromo3(String s) della classe Palindromo.
 * Il metodo deve stampare "La parola (parola in input) è/non è palindroma" a seconda del risultato della chiamata a isPalindromo3.
 * <p>
 * - maggioreMinoreUguale, che prende in input intero e stampa "maggiore di/minore di/uguale a zero" a seconda dell'input fornito.
 * Per questo metodo dovrete usare due operatori ternari concatenati.
 * <p>
 * - metodo main con due chiamate per ciascun metodo (diversi input ovviamente), così da poter testare i diversi output.
 * <p>
 * Tutti i metodi devono essere monoriga**, scritti sfruttando la compattezza dell'operatore ternario
 */

public class OperatoreTernarioTest {

    public static void palindromo(String s) {
        System.out.println("La parola " + s + (isPalindromo3(s) ? " non è " : " è ") + "palindroma");
    }

    public static int valoreAssoluto(int x) {
        return x >= 0 ? x : x * -1;
    }

    public static void maggioreMinoreUguale(int x) {
        System.out.println(x + " " + (x > 0 ? "Maggiore di " : x < 0 ? "Minore di " : "Uguale a ") + "zero");
    }

    public static void maggioreMinoreUgualeTradizionale(int x) {
        String s = x + " ";
        if (x > 0) {
            s += "Maggiore di ";
        } else {
            if (x < 0) {
                s += "Minore di ";
            } else {
                s += "Uguale a ";
            }
        }
        s += "zero";
        System.out.println(s);
    }

    public static void main(String[] args) {
        maggioreMinoreUguale(0);
        maggioreMinoreUguale(1);
        maggioreMinoreUguale(-1);

        maggioreMinoreUgualeTradizionale(0);
        maggioreMinoreUgualeTradizionale(1);
        maggioreMinoreUgualeTradizionale(-1);

        System.out.println(valoreAssoluto(2));
        System.out.println(valoreAssoluto(-2));

        palindromo("otto");
        palindromo("cane");
    }
}
