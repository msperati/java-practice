public class OverloadClass {

    private static class Superclasse {

        @Override
        public String toString() {
            return "SuperclasseObject";
        }
    }

    private static class Sottoclasse extends Superclasse {

        @Override
        public String toString() {
            return "SottoclasseObject";
        }
    }

    public static void print(Object o) {
        System.out.println("OBJECT " + o);
    }

    public static void print(String s) {
        System.out.println("STRING " + s);
    }

    public static void print(Integer integer) {
        System.out.println("INTEGER " + integer);
    }

    public static void print(int i) {
        System.out.println("INT " + i);
    }

    public static void print(Superclasse s) {
        System.out.println("SUPERCLASSE " + s);
    }

    public static void print(Sottoclasse s) {
        System.out.println("SOTTOCLASSE " + s);
    }

    public static void main(String[] args) {
        Object o = "abc";
        String s = "abc";
        Object os = s;

        Integer integer = new Integer(1);
        Integer integer2 = 1;
        int i = 1;

        Superclasse superclasse = new Superclasse();
        Sottoclasse sottoclasse = new Sottoclasse();
        Superclasse castata = sottoclasse;

        print(o);
        print(s);
        print(os);

        print(integer);
        print(integer2);
        print(i);
        print(1);

        print(superclasse);
        print(sottoclasse);
        print(castata);
    }
}
