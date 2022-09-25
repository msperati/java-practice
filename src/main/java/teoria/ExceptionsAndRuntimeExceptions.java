package teoria;

import lombok.Getter;

public class ExceptionsAndRuntimeExceptions {

    /**
     * Questo metodo ha il solo scopo di lanciare un'eccezione.
     * Pertanto la sua firma deve dichiarare che lancia un'eccezione.
     */
    public static void throwException() throws Exception {
        throw new Exception("ECCEZIONE DEL METODO throwException");
    }

    /**
     * Questo metodo ha il solo scopo di lanciare una RuntimeException.
     * Essendo una RuntimeException la firma del metodo non deve dichiarare che la lancia
     */
    public static void throwRuntimeException() {
        throw new RuntimeException("ECCEZIONE DEL METODO throwRuntimeException");
    }

    public static int dividiPerZero(int x) {
        try {
            return x / 0;
        } catch (Exception e) {
            System.out.println("Questa è l'eccezione originale che otteniamo quando dividiamo per 0");
            System.out.println(e.getClass() + " MESSAGGIO: " + e.getMessage());
            System.out.println("Potremmo concludere qua e gestire l'eccezione con un print del messaggio.");
            System.out.println("Invece decidiamo di testare la nostra eccezione customizzata, ovvero:");
            throw new DivisionePerZeroException();
        }
    }

    public static void main(String[] args) {

        try {
            throwException();
        } catch (Exception e) {
            System.out.println("Essendo trowException un metodo che lancia un'eccezione, quando lo chiamiamo siamo obbligati a gestirla con un try catch");
            System.out.println("Ecco l'eccezione lanciata e il suo messaggio");
            System.out.println(e.getMessage());
            System.out.println("*********************************************************");
        }

        try {
            throwRuntimeException();
        } catch (RuntimeException r) {
            System.out.println("Con trowRuntimeException non siamo obbligati a gestire l'eccezione che lancia in quanto è una RuntimeException");
            System.out.println("Poichè però arresterebbe l'esecuzione del metodo main, la catturiamo comunque");
            System.out.println("Ecco l'eccezione lanciata e il suo messaggio");
            System.out.println(r.getMessage());
            System.out.println("*********************************************************");
        }

        dividiPerZero(5);
    }

    @Getter
    private static class DivisionePerZeroException extends RuntimeException {

        private String message;

        public DivisionePerZeroException() {
            this.message = "Ma sei impazzito? Non si può dividere per zero!";
        }
    }
}
