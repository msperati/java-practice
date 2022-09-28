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

    public Object get(int x) {
        checkIndex(x);
        return array[x];
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
            size -= rimosso ? 1 : 0;
        }
        return rimosso;
    }

    public int size() {
        return size;
    }

    /**
     * Ok, ma è molto più semplice scrivere direttamente return size == 0
     */
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

    public boolean contains(Object obj) {
        for (int i = 0; i < array.length; i++) {
            Object input = array[i];
            if (input == obj || input.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ok, ma questo metodo restituisce sempre true, quindi la variabile ris non serve.
     * Basta mettere return true come ultima istruzione del metodo.
     */
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

    public Object remove(int x) {
        checkIndex(x);
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
        checkIndex(x);
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

    /**
     * OCCHIO, TI SEI DIMENTICATO DI FARE size++ L'HO AGGIUNTA IO PER TE
     */
    public void add(int x, Object obj) {
        /**
         * Qua niente checkIndex, perchè quello va in eccezione con >= size
         * mentre qua un indice == size va bene
         */
        if (x < 0 || x > size) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + size);
        }
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
            size++;
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

    private void checkIndex(int x) {
        if (x < 0 || x >= array.length) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + array.length);
        }
    }

}
