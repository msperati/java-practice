package esercizi.simone.custom_list;

import lombok.Getter;
import teoria.custom_list.CustomList;

@Getter
public class ArrayListSimone implements CustomList {

    private Object[] array;
    private int size;

    public ArrayListSimone() {
        this.array = new Object[0];
        this.size = 0;
    }

    public static void main(String[] args) {
        ArrayListSimone list = new ArrayListSimone();
        System.out.println(list);
        list.add("cane");
        list.add("gatto");
        System.out.println(list);
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
        if (obj instanceof ArrayListSimone && obj != null) {
            ArrayListSimone casted = (ArrayListSimone) obj;
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
