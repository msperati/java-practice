package teoria;

public class OperatoreTernario {

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
    }
}
