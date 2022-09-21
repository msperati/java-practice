package enums;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestEnum {

    private Mese mese;
    private PuntoCardinale puntoCardinale;

    public static void main(String[] args) {

        System.out.println("Creo un nuovo oggetto TestEnum");
        TestEnum test = new TestEnum();
        System.out.println("Gli setto mese OTTOBRE, puntoCardinale NORD e li stampo");
        test.setMese(Mese.OTTOBRE);
        test.setPuntoCardinale(PuntoCardinale.NORD);
        test.printMese();
        test.printPuntoCardinale();
        System.out.println("Ora gli setto mese AGOSTO, puntoCardinale OVEST e li stampo");
        test.setMese(Mese.AGOSTO);
        test.setPuntoCardinale(PuntoCardinale.OVEST);
        test.printMese();
        test.printPuntoCardinale();
    }

    public void printPuntoCardinale() {
        switch (puntoCardinale) {
            case NORD:
                System.out.println("NORD ^^^");
                break;
            case SUD:
                System.out.println("SUD vvv");
                break;
            case OVEST:
                System.out.println("OVEST <<<");
                break;
            case EST:
                System.out.println("EST >>>");
                break;
        }
    }

    public void printMese() {
        System.out.println(this.getMese().name() + " è il mese numero " + this.getMese().getNumeroMese());
    }
}
