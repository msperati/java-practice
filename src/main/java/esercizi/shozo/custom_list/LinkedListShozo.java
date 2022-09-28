package esercizi.shozo.custom_list;

import lombok.Getter;
import lombok.Setter;
import lombok.val;
import teoria.custom_list.CustomArrayList;

import java.util.Arrays;
import java.util.List;

import java.util.Objects;

public class LinkedListShozo implements ListShozo {

    private int size;
    private Nodo ultimo;
    private Nodo primo;

    public LinkedListShozo() {
        this.size = 0;
        this.primo = null;
        this.ultimo = null;
    }

    public static void main(String[] args) {
        ListShozo linked = new LinkedListShozo();
//        System.out.println("" + linked + " SIZE " + linked.size());
//        linked.add("cane");
//        System.out.println("" + linked + " SIZE " + linked.size());
//        linked.add("gatto");
//        System.out.println("" + linked + " SIZE " + linked.size());
//        linked.add("cane");
//        System.out.println("" + linked + " SIZE " + linked.size());
//        System.out.println(linked.get(1));
//        linked.remove("gatto");
//        System.out.println("" + linked + " SIZE " + linked.size());
//        System.out.println(linked.get(1));


        LinkedListShozo objClasse = new LinkedListShozo();
        objClasse.add("a");
        objClasse.add("b");
        objClasse.add("c");


//        linkedEmpty.addAll(linked2);
//        System.out.println("" + linkedEmpty + " SIZE " + linkedEmpty.size());
//
//        System.out.println(objClasse.set(1,"d"));
//        System.out.println(objClasse.indexOf("b"));
//        System.out.println(objClasse.lastIndexOf("d"));

        //objClasse.add(1,"d");


        ListShozo listShozo2=objClasse.sublist(1,2);
        for(int i=0;i<listShozo2.size();i++){
            System.out.print(listShozo2.get(i));
        }
    }

    private void checkIndex(int x) {
        if (x < 0 || x >= size) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + size);
        }
    }

    @Override
    public Object get(int i) {
        checkIndex(i);
        //return getNodo(i).getValore(); //QUESTA RIGA OPPURE IL CODICE SOTTO.

        // se l'indice è minore o uguale della dimensione della lista-i
        // ovvero, se ci conviene scorrere la lista dall'inizio
        if (i <= size - i) {
            Nodo esaminato = primo;
            int count = 0;
            while (count < i) {
                esaminato = esaminato.successivo;
                count++;
            }
            return esaminato.getValore();
        }
        // se invece l'indice è più vicino alla fine della lista
        // ovvero, se ci conviene scorrere la lista dalla fine
        else {
            Nodo esaminato = ultimo;
            int count = size - 1;
            while (count > i) {
                esaminato = esaminato.precedente;
                count--;
            }
            return esaminato.getValore();
        }
    }

    @Override
    public boolean add(Object obj) {
        Nodo newNodo = new Nodo(ultimo, obj);
        if (size == 0) {
            primo = newNodo;
        } else {
            ultimo.setSuccessivo(newNodo);
        }
        ultimo = newNodo;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        int count = 0;
        Nodo esaminato = primo;
        boolean rimosso = false;
        while (count < size && !rimosso) {
            if (obj == esaminato.getValore() || obj.equals(esaminato.getValore())) {

                // se non è il primo elemento (e quindi se ha un precedente)
                if (esaminato.precedente != null) {
                    //se non è l'ultimo elemento (e quindi se ha un successivo)
                    if (esaminato.successivo != null) {
                        /**
                         * Il nodo esaminato in precedenza avrà come successivo il successivo dell'esaminato corrente
                         * ES: se dalla lista [a,b,c] rimuoviamo b, il successivo di a diventa c,
                         * e (reciprocamente), il precedente di c diventa a
                         */
                        esaminato.successivo.setPrecedente(esaminato.precedente);
                        esaminato.precedente.setSuccessivo(esaminato.successivo);
                    }
                    // se invece è l'ultimo elemento (dunque non ha successivo)
                    else {
                        ultimo = esaminato.precedente;
                        ultimo.setSuccessivo(null);
                    }
                }
                // se invece l'elemento da rimuovere ha precedente null (dunque è il primo della lista)
                else {
                    primo = esaminato.successivo != null ? esaminato.successivo : null;
                    // se il successivo dell'elemento esaminato è null (dunque è anche l'ultimo della lista, l'unico)
                    if (esaminato.successivo == null) {
                        ultimo = null;
                    }
                }
                rimosso = true;
            }
            esaminato = esaminato.successivo;
            count++;
        }
        size -= rimosso ? 1 : 0;
        return rimosso;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        primo = null;
        ultimo = null;
        size = 0;
    }

    public boolean contains(Object obj) {
        int count = 0;
        Nodo esaminato = primo;
        while (count < size) {
            if (obj == esaminato.getValore() || obj.equals(esaminato.getValore())) {
                return true;
            }
            esaminato = esaminato.successivo;
            count++;
        }
        return false;
    }


    public boolean addAll(ListShozo list) {
        int sizeOld = size;
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }

        //size+=list.size(); //NON SERVE, LO AUMENTA IN AUTOMATICO QUANDO FA add(list.get(i))

        return sizeOld != size;
    }


    public Object remove(int x) {

        checkIndex(x);

        Nodo elementEliminato = null;
        int count = 0;
        Nodo esaminato = primo;
        while (count < size) {

            if (count == x) {
                elementEliminato = esaminato;
                esaminato.precedente.setSuccessivo(esaminato.getSuccessivo());
                esaminato.successivo.setPrecedente(esaminato.getPrecedente());
            }
            esaminato = esaminato.successivo;

            count++;
        }
        primo = x == 0 ? elementEliminato.successivo : primo;
        ultimo = x == size - 1 ? elementEliminato.precedente : ultimo;

        size -= 1;
        return elementEliminato;
    }

    public Object set(int x, Object obj) {
        checkIndex(x);

        Nodo nodo = getNodo(x);
        Object valOld = nodo.getValore();
        nodo.setValore(obj);
        return valOld;

        //OPPURE:

//        int count = 0;
//        Object valOld= new Object();
//        Nodo esaminato = primo;
//        while (count < size ) {
//            if (count==x) {
//
//                valOld= esaminato.getValore();
//
//                esaminato.setValore(obj);
//                break;
//            }
//
//            esaminato = esaminato.successivo;
//            count++;
//        }
//
//      return valOld;
    }

    public int indexOf(Object obj) {
        int indiceRecuperato = 0;
        int count = 0;
        Object valOld = new Object();
        Nodo esaminato = primo;
        while (count < size) {
            if (esaminato.getValore() == obj) {
                indiceRecuperato = count;
                return indiceRecuperato;
            }

            esaminato = esaminato.successivo;
            count++;
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        int indiceRecuperato = 0;
        int count = size - 1;
        Nodo esaminato = ultimo;
        while (count >= 0) {
            if (esaminato.getValore() == obj) {
                indiceRecuperato = count;
                return indiceRecuperato;
            }

            esaminato = esaminato.precedente;
            count--;
        }
        return -1;
    }

    @Override
    public void add(int x, Object obj) {

        /**
         * Qua niente checkIndex, perchè quello va in eccezione con >= size
         * mentre qua un indice == size va bene
         */
        if (x < 0 || x > size) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + size);
        }

        Nodo nodo = isEmpty() ? null : getNodo(x);
        Nodo nodoNew = new Nodo(
                nodo != null ? nodo.precedente : null, //eventuale precedente del nuovo nodo
                obj,                                   //valore del nuovo nodo
                nodo != null ? nodo.successivo : null);//eventuale successivo del nuovo nodo

        if (nodo != null) {
            Nodo nodoPrecedente = nodo.precedente;
            nodoPrecedente.successivo = nodoNew;
            nodo.precedente = nodoNew;
        }

        if (x == 0) {
            primo = nodoNew;
        } else if (x + 1 == size) {
            ultimo = nodoNew;
        }
        size++;
    }

    public ListShozo sublist(int inizio, int fine){

        ListShozo newLista = new LinkedListShozo();
        int count = 0;
        Nodo esaminato = primo;

        while (count < size ) {
            if (count>=inizio && count<=fine) {
                newLista.add(esaminato.getValore());
            }

            esaminato = esaminato.successivo;
            count++;
        }

        System.out.println(newLista);

        return  newLista;
    }

    private Nodo getNodo(int i) {
        // se l'indice è minore o uguale della dimensione della lista-i
        // ovvero, se ci conviene scorrere la lista dall'inizio
        if (i <= size - i) {
            Nodo esaminato = primo;
            int count = 0;
            while (count < i) {
                esaminato = esaminato.successivo;
                count++;
            }
            return esaminato;
        }
        // se invece l'indice è più vicino alla fine della lista
        // ovvero, se ci conviene scorrere la lista dalla fine
        else {
            Nodo esaminato = ultimo;
            int count = size - 1;
            while (count > i) {
                esaminato = esaminato.precedente;
                count--;
            }
            return esaminato;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkedListShozo && obj != null) {
            LinkedListShozo casted = (LinkedListShozo) obj;
            if (casted.size == this.size) {
                int count = 0;
                Nodo ultimo = casted.ultimo;
                Nodo thisUltimo = this.ultimo;
                while (count < this.size) {
                    if (!Objects.equals(ultimo, thisUltimo)) {
                        return false;
                    }
                    ultimo = ultimo.precedente;
                    thisUltimo = this.ultimo.precedente;
                    count++;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "[";
        int count = 0;
        Nodo nodo = primo;
        while (count < size) {
            result += count == size - 1 ? nodo : nodo + ",";
            nodo = nodo.successivo;
            count++;
        }
        result += "]";
        return result;
    }


    @Getter
    @Setter
    private class Nodo {

        private Nodo precedente;
        private Nodo successivo;
        private Object valore;

        private Nodo(Nodo precedente, Object valore) {
            this.precedente = precedente;
            this.valore = valore;
        }

        private Nodo(Nodo precedente, Object valore, Nodo successivo) {
            this.precedente = precedente;
            this.successivo = successivo;
            this.valore = valore;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Nodo && obj != null) {
                Nodo casted = (Nodo) obj;
                return casted.valore.equals(this.valore);
            }
            return false;
        }

//        @Override
//        public String toString() {
//            return "{Nodo: " + valore + "}";
//        }

        @Override
        public String toString() {
            String prec = precedente != null ? precedente.getValore().toString().toLowerCase() : null;
            String succ = successivo != null ? successivo.getValore().toString().toLowerCase() : null;
            String val = valore != null ? valore.toString().toUpperCase() : null;
            return "{" + prec + "," + val + "," + succ + "}-->";
        }
    }
}
