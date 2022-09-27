package teoria.custom_list;

import lombok.Getter;

import java.util.Objects;

@Getter
public class CustomArrayList implements CustomList {

    private Object[] array;
    private int size;

    public CustomArrayList() {
        this.array = new Object[0];
        this.size = 0;
    }


    public static void main(String[] args) {
        CustomList list = new CustomArrayList();
        System.out.println(list);
        list.add("cane");
        System.out.println(list);
        list.add("gatto");
        System.out.println(list);
        list.add("topo");
        System.out.println(list);

        CustomList list2 = new CustomArrayList();
        System.out.println("LIST 2 = " + list + " SIZE: " + list2.size());
        list2.addAll(list);
        System.out.println("LIST 2 = " + list + " SIZE: " + list2.size());
//        list.remove("topo");
//        System.out.println(list);
//        list.remove("cane");
//        System.out.println(list);
//        list.remove("gatto");
//        System.out.println(list);
//        list.remove(null);
//        System.out.println(list);
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

    public Object get(int x) {
        if (x < 0 || x >= size) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + size);
        }
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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        array = new Object[0];
    }

    @Override
    public boolean contains(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj == array[i] || obj.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(CustomList list) {
        if (list.size() == 0) {
            return false;
        }
        Object[] newArray = new Object[size + list.size()];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        for (int i = 0; i < list.size(); i++) {
            newArray[size + i] = list.get(i);
        }
        array = newArray;
        size += list.size();
        return true;
    }

    @Override
    public Object remove(int x) {
        if (x < 0 || x >= size) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + size);
        }
        Object[] newArray = new Object[size - 1];
        boolean rimosso = false;
        Object result = null;
        for (int i = 0; i < size - 1; i++) {
            if (i != x) {
                newArray[i] = rimosso ? array[i + 1] : array[i];
            } else {
                result = array[i];
                rimosso = true;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CustomArrayList && obj != null) {
            CustomArrayList casted = (CustomArrayList) obj;
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
}
