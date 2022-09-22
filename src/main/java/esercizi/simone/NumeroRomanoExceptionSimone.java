package esercizi.simone;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static esercizi.NumeroRomanoTest.convertiNumeroRomanoAdvanced;

@Getter
public class NumeroRomanoExceptionSimone extends RuntimeException {
    private static List<String> numeriRomani = Arrays.asList(new String[]{"M", "D", "C", "L", "X", "V", "I"});
    private String message;

    public NumeroRomanoExceptionSimone(String s) {
        if (s == null) {
            this.message = "Il campo non può essere null";
        } else if (s == "") {
            this.message = "Il campo non può essere una stringa vuota";
        } else {
            // OCCHIO !
            // questa parte qua l'avevi scritta fuori dall'else e quindi veniva eseguita SEMPRE.
            // Il codice compilerebbe, ma in caso di s = null, avanzerebbe comunque fino a questa parte
            // andando poi in nullPointerException quando prova ad eseguire s.split("")
            String[] lettereSingole = s.split("");
            for (int i = 0; i < lettereSingole.length; i++) {
                String l = lettereSingole[i];
                if (!numeriRomani.contains(l)) {
                    this.message = "la stringa : " + s + " Non è un numero romano";
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("ABC = " + convertiNumeroRomanoAdvanced("ABC"));
        } catch (RuntimeException e) {
            NumeroRomanoExceptionSimone simoneEcc = new NumeroRomanoExceptionSimone(e.getMessage());
            System.out.println(simoneEcc.getMessage());
        }

        try {
            System.out.println("Stringa vuota = " + convertiNumeroRomanoAdvanced(""));
        } catch (RuntimeException e) {
            NumeroRomanoExceptionSimone simoneEcc = new NumeroRomanoExceptionSimone(e.getMessage());
            System.out.println(simoneEcc.getMessage());
        }

        try {
            System.out.println("Stringa null = " + convertiNumeroRomanoAdvanced(null));
        } catch (RuntimeException e) {
            NumeroRomanoExceptionSimone simoneEcc = new NumeroRomanoExceptionSimone(e.getMessage());
            System.out.println(simoneEcc.getMessage());
        }
    }
}
