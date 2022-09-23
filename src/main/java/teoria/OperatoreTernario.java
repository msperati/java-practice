package teoria;

import static esercizi.Palindromo.isPalindromo3;

public class OperatoreTernario {

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

        boolean staPiovendo = true;

        // L'operatore ternario è un modo più compatto ed elegante per scrivere gli if/else
        // La riga di sotto è esattamente equivalente alle 5 righe dopo il primo print
        System.out.println("Il tempo è " + (staPiovendo ? "brutto" : "bello"));

        if (staPiovendo) {
            System.out.println("Il tempo è brutto");
        } else {
            System.out.println("Il tempo è bello");
        }

        // La sintassi dell'operatore ternario è
        // booleano    + punto di domanda + istruzioneA + duepunti + istruzioneB
        // staPiovendo         ?              "brutto"        :       "bello"

        //E' possibile anche concatenare più operatori ternari esattamente allo stesso modo
        boolean ilSoleSplende = true;
        boolean ciSono35Gradi = true;
        String tempo = ilSoleSplende ? ciSono35Gradi ? "bellissimo" : "bello" : "brutto";
        System.out.println("Il tempo è " + tempo);

        // Che equivale a scrivere
        if (ilSoleSplende) {
            tempo = "bello";
            if (ciSono35Gradi) {
                tempo = "bellissimo";
            }
        } else {
            tempo = "brutto";
        }
        System.out.println("Il tempo è " + tempo);

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
