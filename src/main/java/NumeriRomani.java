public class NumeriRomani {

    private enum RomanNumber {
        M(1000),
        D(500),
        C(100),
        L(50),
        X(10),
        V(5),
        I(1);

        private int valore;

        private RomanNumber(int valore) {
            this.valore = valore;
        }

        public int getValore() {
            return this.valore;
        }
    }

    public static int getIntValue(String numeroRomano) {
        int count = 0;
        for (String c : numeroRomano.split("")) {
            count += RomanNumber.valueOf(c).getValore();
        }
        return count;
    }

    public static void main (String[] args) {
        /*for (RomanNumber rn : RomanNumber.values()) {
            System.out.println(rn.name() + " " + rn.getValore());
        }*/

        System.out.println(getIntValue("MDC"));
    }
}
