package esercizi.shozo;

public class PiramideShozo {

    public static String repeat(String s, int x) {
        String newString = "";
        int repetition = 0;
        while (repetition < x) {
            newString += s;
            repetition++;
        }
        return newString;
    }


    public static void printPiramide(int x) {
        int lunghezzaBase = (x * 2) - 1;
        int meta = (lunghezzaBase / 2) + 1;
        System.out.println("PIRAMIDE DI " + x);
        for (int i = 1; i <= x; i++) {

            String carattereCentrale = (i % 2 == 0 ? "-" : "*");

            String asterischiIniziali = repeat("*-", (i / 2));

            asterischiIniziali = asterischiIniziali.endsWith(carattereCentrale) ? asterischiIniziali.substring(0, asterischiIniziali.length() - 1) : asterischiIniziali;

            String spazi = repeat("-", meta - (asterischiIniziali.length() + 1));


            String asterischiFinali = repeat("-*", (i / 2));

            asterischiFinali = asterischiFinali.startsWith(carattereCentrale) ? asterischiFinali.substring(1) : asterischiFinali;

            System.out.println(
                    spazi +
                            asterischiIniziali +
                            carattereCentrale +
                            asterischiFinali +
                            spazi);
        }
    }

    public static void printPiramide(int x, char s1, char s2) {
        int lunghezzaBase = (x * 2) - 1;
        int meta = (lunghezzaBase / 2) + 1;
        System.out.println("PIRAMIDE DI " + x);
        for (int i = 1; i <= x; i++) {

            String carattereCentrale = (i % 2 == 0 ? String.valueOf(s2) : String.valueOf(s1));

            String asterischiIniziali = repeat(String.valueOf(s1) + String.valueOf(s2), (i / 2));

            asterischiIniziali = asterischiIniziali.endsWith(carattereCentrale) ? asterischiIniziali.substring(0, asterischiIniziali.length() - 1) : asterischiIniziali;

            String spazi = repeat(String.valueOf(s2), meta - (asterischiIniziali.length() + 1));


            String asterischiFinali = repeat(String.valueOf(s2) + String.valueOf(s1), (i / 2));

            asterischiFinali = asterischiFinali.startsWith(carattereCentrale) ? asterischiFinali.substring(1) : asterischiFinali;

            System.out.println(
                    spazi +
                            asterischiIniziali +
                            carattereCentrale +
                            asterischiFinali +
                            spazi);
        }
    }


    public static void main(String[] args) {

        //printPiramide(2);

        //printPiramide(3);

        //printPiramide(10);
        printPiramide(3, '#', ' ');
        printPiramide(3, '*', '-');
        printPiramide(3, 'A', '_');

    }
}
