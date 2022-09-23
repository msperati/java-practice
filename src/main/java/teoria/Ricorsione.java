package teoria;

public class Ricorsione {

    public static void countdown(int x) {
        if (x > 0) {
            System.out.println("-" + x + "...");
            countdown(x - 1);
        } else {
            System.out.println("PARTENZA !!!!");
        }
    }

    public static int contaFinoA10(String stringa, int x) {
        stringa += x + ";";
        if (x < 10) {
            return contaFinoA10(stringa, x + 1);
        } else {
            System.out.println(stringa);
            return x;
        }
    }

    public static int fattoriale(int x) {
        if (x > 1) {
            return x * fattoriale(x - 1);
        }
        return 1;
    }

    public static Object[] fattorialePrint(int inizio, int x, String s) {
        if (x > 1) {
            Object[] result = fattorialePrint(inizio, x - 1, s);
            String stringaRicorsioneSuccessiva = (String) result[0];
            int intRicorsioneSuccessiva = (int) result[1];
            s += x + "*" + stringaRicorsioneSuccessiva;
            int moltiplicazione = x * intRicorsioneSuccessiva;
            if (inizio == x) {
                System.out.println(s + moltiplicazione);
            }
            return new Object[]{s, moltiplicazione};
        }
        s += "1=";
        return new Object[]{s, 1};
    }

    public static void main(String[] args) {
        countdown(10);
        contaFinoA10("CONTA:", 1);
        System.out.println(fattoriale(5));
        fattorialePrint(5, 5, "");
    }
}

