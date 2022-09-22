package esercizi.shozo;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static esercizi.NumeroRomanoTest.convertiNumeroRomanoAdvanced;

@Getter
public class NumeroRomanoExceptionShozo extends RuntimeException {

    private static List<String> NUMERI_ROMANI = Arrays.asList(new String[]{"M", "D", "C", "L", "X", "V", "I"});
    private String message;

    public NumeroRomanoExceptionShozo(String input) {
        if (input == null) {
            this.message = "Messaggio null. Inserire una stringa";
        } else if (input == "") {
            this.message = "Messaggio stringa vuota. Inserire una stringa";
        } else {
            String[] arrInput = input.split("");
            for (String elem : arrInput) {
                if (!NUMERI_ROMANI.contains(elem)) {
                    this.message = "Input non valido:" + input + " Solo caratteri romani please";
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("ABC = " + convertiNumeroRomanoAdvanced("ABC"));
        } catch (RuntimeException e) {
            NumeroRomanoExceptionShozo shozoEcc = new NumeroRomanoExceptionShozo(e.getMessage());
            System.out.println(shozoEcc.getMessage());
        }

        try {
            System.out.println("Stringa vuota = " + convertiNumeroRomanoAdvanced(""));
        } catch (RuntimeException e) {
            NumeroRomanoExceptionShozo shozoEcc = new NumeroRomanoExceptionShozo(e.getMessage());
            System.out.println(shozoEcc.getMessage());
        }

        try {
            System.out.println("Stringa null = " + convertiNumeroRomanoAdvanced(null));
        } catch (RuntimeException e) {
            NumeroRomanoExceptionShozo shozoEcc = new NumeroRomanoExceptionShozo(e.getMessage());
            System.out.println(shozoEcc.getMessage());
        }
    }
}
