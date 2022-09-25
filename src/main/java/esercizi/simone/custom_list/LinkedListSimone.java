package esercizi.simone.custom_list;

import lombok.Getter;
import lombok.Setter;

public class LinkedListSimone implements ListSimone {

    private int size;
    private Nodo ultimo;
    private Nodo primo;

    public LinkedListSimone() {
        this.size = 0;
        this.primo = null;
        this.ultimo = null;
    }

    public static void main(String[] args) {
        ListSimone linked = new LinkedListSimone();
        System.out.println("" + linked + " SIZE " + linked.size());
        linked.add("cane");
        System.out.println("" + linked + " SIZE " + linked.size());
        linked.add("gatto");
        System.out.println("" + linked + " SIZE " + linked.size());
        linked.add("cane");
        System.out.println("" + linked + " SIZE " + linked.size());
        System.out.println(linked.get(1));
        linked.remove("gatto");
        System.out.println("" + linked + " SIZE " + linked.size());
        System.out.println(linked.get(1));
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(
                    "Indice " + i + " non valido. Dimensione lista: " + size);
        }
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkedListSimone && obj != null) {
            LinkedListSimone casted = (LinkedListSimone) obj;
            if (casted.size == this.size) {
                int count = 0;
                Nodo ultimo = casted.ultimo;
                Nodo thisUltimo = this.ultimo;
                while (count < this.size) {
                    if (!ultimo.equals(thisUltimo)) {
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
            result += count == size - 1 ? nodo.getValore() : nodo.getValore() + ",";
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

        private Nodo(Nodo precedente, Nodo successivo, Object valore) {
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

        @Override
        public String toString() {
            return "{Nodo: " + valore + "}";
        }
    }
}
