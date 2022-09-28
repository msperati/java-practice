package esercizi.simone.custom_list;

import lombok.Getter;

import java.util.Objects;

@Getter
public class ArrayListSimone implements ListSimone {

    private Object[] array;
    private int size;

    public ArrayListSimone() {
        this.array = new Object[0];
        this.size = 0;
    }


    public static void main(String[] args) {
//        ArrayListSimone list = new ArrayListSimone();
//        System.out.println(list);
//        list.add("cane");
//        list.add("gatto");
//        System.out.println(list);
//        ArrayListSimone list2 = new ArrayListSimone();
//        System.out.println(list2);
//        list2.add("A");
//        list2.add("B");
//        list2.add("C");
//        System.out.println(list2);

        ArrayListSimone objSimone = new ArrayListSimone();

        objSimone.array = new Object[3];
        objSimone.array[0] = "A";
        objSimone.array[1] = "B";
        objSimone.array[2] = "C";
        System.out.println(objSimone.sublist(1, 2));
//        objSimone.add(1, "d");
//        System.out.println(objSimone.indexOf("B"));
//        System.out.println(objSimone.lastIndexOf("A"));


    }

    public Object get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(
                    "Indice " + i + " non valido. Dimensione lista: " + size);
        }
        return array[i];
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
                    if (!Objects.equals(casted.array[i], this.array[i])) {
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

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        array = new Object[0];
        size = 0;
    }

    public boolean addAll(ListSimone list) {
        Object[] arr = new Object[this.size + list.size()];
        boolean ris = false;
        for (int i = 0; i < size; i++) {
            arr[i] = array[i];
        }
        for (int i = 0; i < size; i++) {
            arr[size + i] = list.get(i);
            ris = true;
        }
        size += list.size();
        array = arr;
        return ris;
    }

    public boolean contains(Object obj) {

        for (int i = 0; i < array.length; i++) {
            Object input = array[i];

            if (input == obj || input.equals(obj)) {

                return true;
            }

        }
        return false;
    }

    public Object remove(int x) {
        if (x < 0 || x > size - 1) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + size);
        }
        boolean rimosso = false;
        Object[] newArr = new Object[size - 1];
        Object result = null;
        for (int i = 0; i < array.length; i++) {
            Object elementoScansionato = array[i];
            if (i == x) {
                result = elementoScansionato;
                rimosso = true;
            } else {
                if (rimosso) {
                    newArr[i - 1] = array[i];
                } else {
                    newArr[i] = array[i];
                }
            }
        }
        size -= 1;
        return result;
    }

    public Object set(int x, Object obj) {
        if (x < 0 || x >= array.length) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + array.length);
        }
        Object oldValue = array[x];
        array[x] = obj;
        return oldValue;

//        Object oldValue = new Object();
//        for (int i = 0; i < array.length; i++) {
//            if (i == x) {
//                oldValue = array[i];
//                array[i] = obj;
//            }
//        }
//        return oldValue;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(obj, array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (Objects.equals(obj, array[i])) {
                return i;
            }
        }
        return -1;
    }

    private void checkIndex(int x) {
        if (x < 0 || x >= array.length) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + array.length);
        }
    }

    public void add(int x, Object obj) {
        checkIndex(x);
        Object[] newArr = new Object[array.length + 1];
        boolean aggiunto = false;
        for (int i = 0; i <= array.length; i++) {
            if (i != x) {
                if (aggiunto) {
                    newArr[i] = array[i - 1];

                } else {
                    newArr[i] = array[i];
                }

            } else {
                newArr[i] = obj;
                aggiunto = true;
            }
            System.out.println(newArr[i]);
        }
    }

    public ListSimone sublist(int inizio, int fine) {
        checkIndex(inizio);
        checkIndex(fine);
        ListSimone newArr = new ArrayListSimone();
        for (int i = 0; i <= array.length; i++) {
            if (i >= inizio && i <= fine) {
                newArr.add(array[i]);
            }
        }
        return newArr;
    }

}
