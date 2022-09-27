package teoria.custom_list;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class CustomLinkedList implements CustomList {

    private int size;
    private Nodo ultimo;
    private Nodo primo;

    public CustomLinkedList() {
        this.size = 0;
        this.primo = null;
        this.ultimo = null;
    }

    public static void main(String[] args) {
        CustomList linked = new CustomLinkedList();
        System.out.println("" + linked + " SIZE " + linked.size());
        linked.add("cane");
        System.out.println("" + linked + " SIZE " + linked.size());
        linked.add("gatto");
        System.out.println("" + linked + " SIZE " + linked.size());
        linked.add("topo");
        System.out.println("" + linked + " SIZE " + linked.size());
        CustomList empty = new CustomLinkedList();
        System.out.println("EMPTY: " + empty + " SIZE " + empty.size());
        empty.addAll(linked);
        System.out.println("EMPTY: " + empty + " SIZE " + empty.size());
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
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        primo = null;
        ultimo = null;
    }

    @Override
    public boolean contains(Object obj) {
        int count = 0;
        Nodo esaminato = primo;
        while (count < size) {
            if (esaminato.getValore() == obj || esaminato.getValore().equals(obj)) {
                return true;
            }
            count++;
            esaminato = esaminato.successivo;
        }
        return false;
    }

    @Override
    public boolean addAll(CustomList list) {
        if (list instanceof CustomLinkedList) {
            if (this.isEmpty()) {
                primo = ((CustomLinkedList) list).primo;
            } else {
                ultimo.setSuccessivo(((CustomLinkedList) list).primo);
            }
            ((CustomLinkedList) list).primo.setPrecedente(ultimo);
            ultimo = ((CustomLinkedList) list).ultimo;
            size += ((CustomLinkedList) list).size;
        } else {
            for (int i = 0; i < list.size(); i++) {
                this.add(list.get(i));
            }
        }
        return list.size() > 0;
    }

    @Override
    public Object remove(int x) {
        if (x < 0 || x >= size) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + size);
        }
        Nodo esaminato = null;
        // se l'indice è minore o uguale della dimensione della lista-i
        // ovvero, se ci conviene scorrere la lista dall'inizio
        if (x <= size - x) {
            esaminato = primo;
            int count = 0;
            while (count < x) {
                esaminato = esaminato.successivo;
                count++;
            }
            // se l'oggetto esaminato ha un precedente (dunque non era il primo della lista)
            if (esaminato.precedente != null) {
                esaminato.precedente.setSuccessivo(esaminato.successivo);
            }
            // altrimenti imposta come primo il suo successivo
            else {
                primo = esaminato.successivo;
            }
            // se l'oggetto esaminato ha un successivo (dunque non era l'ultimo della lista)
            if (esaminato.successivo != null) {
                esaminato.successivo.setPrecedente(esaminato.precedente);
            }
            // altrimenti imposta come ultimo il suo precedente
            else {
                ultimo = esaminato.precedente;
            }
        }
        // se invece l'indice è più vicino alla fine della lista
        // ovvero, se ci conviene scorrere la lista dalla fine
        else {
            esaminato = ultimo;
            int count = size - 1;
            while (count > x) {
                esaminato = esaminato.precedente;
                count--;
            }
            if (esaminato.precedente != null) {
                esaminato.precedente.setSuccessivo(esaminato.successivo);
            } else {
                primo = esaminato.successivo;
            }
            if (esaminato.successivo != null) {
                esaminato.successivo.setPrecedente(esaminato.precedente);
            } else {
                ultimo = esaminato.precedente;
            }
        }
        size--;
        return esaminato.getValore();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CustomLinkedList && obj != null) {
            CustomLinkedList casted = (CustomLinkedList) obj;
            if (casted.size == this.size) {
                int count = 0;
                Nodo esaminatoAltraLista = casted.ultimo;
                Nodo esaminatoQuestaLista = this.ultimo;
                while (count < this.size) {
                    if (!Objects.equals(esaminatoAltraLista, esaminatoQuestaLista)) {
                        return false;
                    }
                    esaminatoAltraLista = esaminatoAltraLista.precedente;
                    esaminatoQuestaLista = esaminatoQuestaLista.precedente;
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
            String prec = precedente != null ? precedente.getValore().toString().toLowerCase() : null;
            String succ = successivo != null ? successivo.getValore().toString().toLowerCase() : null;
            String val = valore != null ? valore.toString().toUpperCase() : null;
            return "{" + prec + "," + val + "," + succ + "}-->";
        }
    }
}
