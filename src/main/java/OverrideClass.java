import java.util.Arrays;
import java.util.List;

public class OverrideClass {

    private interface Interfaccia {
        void print();
    }

    private static class ImplementazioneA implements Interfaccia {

        @Override
        public void print() {
            System.out.println("Implementazione A");
        }
    }

    private static class ImplementazioneB implements Interfaccia {

        @Override
        public void print() {
            System.out.println("Implementazione B");
        }
    }

    private static class ImplementazioneC implements Interfaccia {

        @Override
        public void print() {
            System.out.println("Implementazione C");
        }
    }

    public static void main (String[] args) {

        ImplementazioneA a = new ImplementazioneA();
        ImplementazioneB b = new ImplementazioneB();
        ImplementazioneC c = new ImplementazioneC();

        List<Interfaccia> implementazioni = Arrays.asList(new Interfaccia[]{a, b, c});
        for (Interfaccia i : implementazioni) {
            i.print();
        }
    }
}
