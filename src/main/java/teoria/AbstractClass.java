package teoria;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractClass {

    /**
     * Da questo metodo si può notare che:
     * <p>
     * 1) una classe astratta, a differenza di un'interfaccia, può avere un'implementazione concreta dei metodi
     * infatti ClasseConcretaC non ci obbliga a fare l'override del metodo print().
     * <p>
     * 2) nonostante a e b siano dichiarati come AbstractClass, quando chiamiamo il metodo print()
     * non chiama quello della superclasse AbstractClass, ma quello overridato di ClasseConcretaA eClasseConcretaB
     */
    public static void main(String[] args) {

        AbstractClass a = new ClasseConcretaA();
        AbstractClass b = new ClasseConcretaB();
        AbstractClass c = new ClasseConcretaC();

        List<AbstractClass> list = Arrays.asList(new AbstractClass[]{a, b, c});
        for (AbstractClass classe : list) {
            classe.print();
        }
    }

    public void print() {
        System.out.println("AbstractClass");
    }

    private static class ClasseConcretaA extends AbstractClass {
        @Override
        public void print() {
            System.out.println("ClasseConcretaA");
        }
    }

    private static class ClasseConcretaB extends AbstractClass {
        @Override
        public void print() {
            System.out.println("ClasseConcretaB");
        }
    }

    private static class ClasseConcretaC extends AbstractClass {

    }
}
