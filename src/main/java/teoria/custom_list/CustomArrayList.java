package teoria.custom_list;

import lombok.Getter;

@Getter
public class CustomArrayList implements CustomList {

    private Object[] array;
    private int size;

    public CustomArrayList() {
        this.array = new Object[0];
        this.size = 0;
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        System.out.println(list);
        list.add("cane");
        System.out.println(list);
        list.add("gatto");
        System.out.println(list);
        list.add("topo");
        System.out.println(list);
//        System.out.println(list.get(1));
//        //System.out.println(list.get(4));
//        System.out.println(list.array[0].precedente);
//        System.out.println(list.array[1].precedente);
//        List<Object> test = new ArrayList<>(Arrays.asList(new Object[]{null}));
//        System.out.println("LISTA NORMALE: " + test);
//        System.out.println(test.remove(null));
//        System.out.println("LISTA NORMALE: " + test);
        list.remove("topo");
        System.out.println(list);
        list.remove("cane");
        System.out.println(list);
        list.remove("gatto");
        System.out.println(list);
        list.remove(null);
        System.out.println(list);
//        CustomList list2 = new CustomList();
//        list2.add("cane");
//        list2.add("gatto");
//        System.out.println("LISTA 1" + list);
//        System.out.println("LISTA 2" + list2);
//        System.out.println(list2.equals(list));
//        list2.add("topo");
//        System.out.println(list2.equals(list));
//        list2.remove("topo");
    }

    public Object get(int i) {
        if (i >= 0 && i < size - 1) {
            return array[i];
        }
        throw new IndexOutOfBoundsException(
                "Indice " + i + " non valido. Dimensione lista: " + size);
    }

    public boolean add(Object obj) {
        Object[] newArray = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        newArray[size] = obj;
        array = newArray;
        size++;
        return true;
    }

    public boolean remove(Object obj) {
        boolean rimosso = false;
        if (size > 0) {
            Object[] newArray = new Object[size - 1];
            for (int i = 0; i < array.length; i++) {
                Object elementoScansionato = array[i];
                // se l'elemento scansionato corrisponde all'oggetto in input
                if (elementoScansionato == obj || elementoScansionato.equals(obj)) {
                    /** se non è l'ultimo elemento, bisogna congiungere i nodi
                     * che stavano prima e dopo quello rimosso
                     * ES: se la lista è [a,b,c] e togliamo b
                     * dobbiamo settare a come precedente di c
                     */

                    /**if (!(i == size - 1)) {
                     Nodo successivoAlRimosso = array[i + 1];
                     successivoAlRimosso.precedente = i == 0 ? null : array[i - 1];
                     }*/
                    rimosso = true;
                }
                // se l'oggetto scansionato non è quello che vogliamo rimuovere, lo rimettiamo nell'array
                else {
                    if (rimosso) {
                        newArray[i - 1] = array[i];
                    } else {
                        newArray[i] = array[i];
                    }
                }
            }
            array = newArray;
            /**
             * ultimo = size == 1 ? null : array[array.length - 1];
             */
            size -= rimosso ? 1 : 0;
        }
        return rimosso;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CustomArrayList && obj != null) {
            CustomArrayList casted = (CustomArrayList) obj;
            if (casted.size == this.size) {
                for (int i = 0; i < this.size; i++) {
                    if (!casted.array[i].equals(this.array[i])) {
                        return false;
                    }
                    if (i == size - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += i == size - 1 ? array[i] : array[i] + ",";
        }
        result += "]";
        return result;
    }
}