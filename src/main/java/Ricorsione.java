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

    public static int fattorialeWithPrint(int x) {
        if (x > 1) {
            int y = x * fattorialeWithPrint(x - 1);
            System.out.println(x + " X " + (x - 1) + " fattoriale = " + y);
            return y;
        }
        return 1;
    }

    public static int fattorialeWithPrint(String stringa, int x) {
        if (x > 1) {
            stringa += (stringa.isEmpty() ? x : "") + "x" + (x - 1);
            return x * fattorialeWithPrint(stringa, x - 1);
        }
        System.out.println(stringa);
        return 1;
    }

    public static void main(String[] args) {
        countdown(10);
        contaFinoA10("CONTA:", 1);
        System.out.println(fattoriale(5));
        fattorialeWithPrint(5);
    }
}
