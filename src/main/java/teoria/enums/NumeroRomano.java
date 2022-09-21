package teoria.enums;

public enum NumeroRomano {
    M(1000),
    D(500),
    C(100),
    L(50),
    X(10),
    V(5),
    I(1);

    private int valore;

    private NumeroRomano(int valore) {
        this.valore = valore;
    }

    public int getValore() {
        return this.valore;
    }
}