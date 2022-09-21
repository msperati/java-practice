package esercizi;

import teoria.enums.NumeroRomano;

public class NumeroRomanoTest {

    public static int convertiNumeroRomanoSemplice(String numeroRomano) {
        int count = 0;
        for (String c : numeroRomano.split("")) {
            count += NumeroRomano.valueOf(c).getValore();
        }
        return count;
    }

    public static int convertiNumeroRomanoAdvanced(String numeroRomano) {
        // inizializzo il contatore a 0
        int count = 0;

        // splitto la stringa in un array di Stringhe (le singole lettere)
        String[] lettereSingole = numeroRomano.split("");

        // per ogni lettera dell'array
        for (int i = 0; i < lettereSingole.length; i++) {

            // lettera sarà la lettera corrispondente all'indice i attuale
            String lettera = lettereSingole[i];

            // letteraSuccessiva sarà quella corrispondente a indice i+1
            // o (qualora lettera sia l'ultimo elemento dell'array) sarà null
            String letteraSuccessiva = i == lettereSingole.length - 1 ?
                    null : lettereSingole[i + 1];

            // ricavo il valore numerico di lettera e letteraSuccessiva (se questa è null il valore sarà 0)
            int valoreLettera = NumeroRomano.valueOf(lettera).getValore();
            int valoreLetteraSuccessiva = letteraSuccessiva != null ?
                    NumeroRomano.valueOf(letteraSuccessiva).getValore() : 0;

            // se il valore numerico di lettera è minore di quello di letteraSuccessiva (ES: IX, XL, CD)
            if (valoreLettera < valoreLetteraSuccessiva) {

                // se è minore, devo sottrarre al valore di letteraSuccessiva il valore di lettera
                // e aumentare il valore dell'indice i di 1, in quanto ho preso in esame 2 lettere
                count += valoreLetteraSuccessiva - valoreLettera;
                i++;
            } else {

                // se è maggiore, procedo normalmente a sommare il valore di lettera al conteggio finale
                count += valoreLettera;
            }
        }
        // restituisco la somma dei valori ottenuti
        return count;
    }

    // Soluzione di Shozo che NON tiene conto delle stringhe come IV, IX, XL, XC, CD, CM
    public static int convertiNrRomano(String nrRoman) {
        String[] nrRomanSplittato = nrRoman.split("");
        Integer sommaVal = 0;
        for (String elem : nrRomanSplittato) {
            NumeroRomano pizzaStatusEnum = NumeroRomano.valueOf(elem);
            sommaVal += pizzaStatusEnum.getValore();
        }

        return sommaVal;
    }

    // Soluzione di Shozo che tiene conto delle stringhe come IV, IX, XL, XC, CD, CM
    // Curiosa la scelta di scorrere la stringa dalla fine verso l'inizio, tuttavia funzionante
    public static int convertinNrRomanoAdvanced(String nrRoman) {
        String[] nrRomanSplittato = nrRoman.split("");
        int valorePos = 0;
        int valorePosPrecedente = 0;
        Integer sommaVal = 0;
        for (int i = nrRomanSplittato.length - 1; i >= 0; i--) {
            String s = nrRomanSplittato[i];
            String precedenteS = i == 0 ? null : nrRomanSplittato[i - 1];
            valorePos = NumeroRomano.valueOf(s).getValore();
            if (i > 0) {
                valorePosPrecedente = NumeroRomano.valueOf(precedenteS).getValore();
            } else {
                valorePosPrecedente = 0;
            }
            if (valorePos > valorePosPrecedente) {
                sommaVal += valorePos - valorePosPrecedente;
                i--;
            } else {
                sommaVal += valorePos;
            }
        }
        return sommaVal;
    }

    public static void main(String[] args) {
        System.out.println("MDC = " + convertiNumeroRomanoSemplice("MDC"));
        System.out.println("LXV = " + convertiNumeroRomanoSemplice("LXV"));
        System.out.println("VI = " + convertiNumeroRomanoSemplice("VI"));

        System.out.println("MCM = " + convertiNumeroRomanoAdvanced("MCM"));
        System.out.println("XL = " + convertiNumeroRomanoAdvanced("XL"));
        System.out.println("IV = " + convertiNumeroRomanoAdvanced("IV"));
    }
}
