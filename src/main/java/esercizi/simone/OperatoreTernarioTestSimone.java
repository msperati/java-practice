package esercizi.simone;

import esercizi.Palindromo;

import java.util.Scanner;

public class OperatoreTernarioTestSimone {

    public static int getAbsoluteValue() {
        Scanner input = new Scanner(System.in);
        String y = input.nextLine();
        System.out.println("valore assoluto : " + Math.abs(Integer.parseInt(y)));  // Output user input
        return Integer.parseInt(y);
    }

    public static void palindromo() {
        System.out.println("Inserisci una parola : ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        if (Palindromo.isPalindromo3(s) == true) {
            System.out.println(s);

            System.out.println("il numero è palindromo");
        } else {
            System.out.println(s);
            System.out.println("il numero NON è palindromo");
        }

    }

    public static int maggMinUg(int x) {
        System.out.println(x > 0 ? " Maggiore di " : x < 0 ? "Minore di " : "Uguale a zero");
        return x;
    }

    public static void main(String[] args) {
        System.out.println(maggMinUg(0));
        System.out.println(maggMinUg(-5));
        System.out.println(maggMinUg(5));

       /* palindromo();
        getAbsoluteValue();*/
    }
}
