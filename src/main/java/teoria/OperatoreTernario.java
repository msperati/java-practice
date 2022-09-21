package teoria;

public class OperatoreTernario {

    public static void main(String[] args) {

        boolean staPiovendo = true;

        // L'operatore ternario è un modo più compatto ed elegante per scrivere gli if/else
        // La riga di sotto è esattamente equivalente alle 5 righe dopo il primo print
        String tempo = staPiovendo ? "brutto" : "bello";
        System.out.println("Il tempo è " + tempo);

        if (staPiovendo) {
            tempo = "brutto";
        } else {
            tempo = "bello";
        }
        System.out.println("Il tempo è " + tempo);

        // La sintassi dell'operatore ternario è
        // booleano    + punto di domanda + istruzioneA + duepunti + istruzioneB
        // staPiovendo         ?              "brutto"        :       "bello"

        //E' possibile anche concatenare più operatori ternari esattamente allo stesso modo
        boolean ilSoleSplende = true;
        boolean ciSono35Gradi = true;
        tempo = ilSoleSplende ? ciSono35Gradi ? "bellissimo" : "bello" : "brutto";
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
