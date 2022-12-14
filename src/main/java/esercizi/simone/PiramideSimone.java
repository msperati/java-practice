package esercizi.simone;

public class PiramideSimone {

    public static String repeat(String s, int x) {
        String newStringA = "";
        int repetition = 0;
        while (repetition < x) {
            newStringA += s;

            repetition++;
        }
        return newStringA;

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

    public static void printPiramide(int x, char c, char s) {
        int lunghezzaBase = (x * 2) - 1;
        int meta = (lunghezzaBase / 2) + 1;
        System.out.println("PIRAMIDE DI " + x);
        for (int i = 1; i <= x; i++) {

            String carattereCentrale = (i % 2 == 0 ? String.valueOf(s) : String.valueOf(c));

            String asterischiIniziali = repeat(String.valueOf(c) + String.valueOf(s), (i / 2));

            asterischiIniziali = asterischiIniziali.endsWith(carattereCentrale) ? asterischiIniziali.substring(0, asterischiIniziali.length() - 1) : asterischiIniziali;

            String spazi = repeat(String.valueOf(s), meta - (asterischiIniziali.length() + 1));

            String asterischiFinali = repeat(String.valueOf(s) + String.valueOf(c), (i / 2));
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

        printPiramide(3, ' ', ' ');

        printPiramide(3, '#', '_');

        printPiramide(3, 'A', '-');

        //printPiramide(3);

        //printPiramide(10);

    }
}
