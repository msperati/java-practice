package esercizi.shozo.custom_list;

public interface ListShozo {

    Object get(int x);

    boolean add(Object a);

    boolean remove(Object a);

    int size();

    /**
     * Questo metodo restituisce true se la lista è vuota, false se contiene uno o più elementi al suo interno
     * TEMPO STIMATO PER LinkedList e ArrayList: 10 minuti;
     */
    boolean isEmpty();

    /**
     * Questo metodo deve svuotare completamente la lista
     * TEMPO STIMATO PER LinkedList e ArrayList: 10 minuti;
     */
    void clear();

    /**
     * Questo metodo restituisce true se la lista contiene l'elemento passato in input, false se non lo contiene
     * TEMPO STIMATO PER LinkedList e ArrayList: 20 minuti;
     */
    boolean contains(Object obj);

    /**
     * Questo metodo prende in input un'altra ListShozo e deve aggiungere tutti i suoi elementi alla lista corrente
     * TEMPO STIMATO PER LinkedList e ArrayList: 20 minuti;
     */
    boolean addAll(ListShozo list);

    /**
     * Questo metodo, dato un indice in input, deve modificare la lista rimuovendo l'oggetto all'indice x.
     * Infine, restituisce l'oggetto così rimosso
     * TEMPO STIMATO PER LinkedList e ArrayList: 2 ore;
     */
    Object remove(int x);

    /** TODO
     * Questo metodo cambia il valore dell'i-esimo oggetto della lista con il valore passato in input.
     * Restituisce il vecchio valore dell'oggetto modificato.
     * ES: lista = [a,b,c] set(1,"D") cambia la lista in [a,D,c] e restituisce b
     * Lancia una IndexOutOfBoundsException se l'indice non è conforme.
     */
    //Object set(int x, Object obj);

    /** TODO
     * Questo metodo restituisce il valore della prima occorrenza dell'oggetto passato in input.
     * Se l'oggetto non è presente restituisce -1.
     * ES: lista = [a,b,c,a] indexOf(a) restituisce 0, indexOf(d) restituisce -1
     */
    //int indexOf(Object obj);

    /** TODO
     * Questo metodo restituisce il valore dell'ultima occorrenza dell'oggetto passato in input.
     * Se l'oggetto non è presente restituisce -1.
     * ES: lista = [a,b,c,a] indexOf(a) restituisce 3, indexOf(d) restituisce -1
     */
    //int lastIndexOf(Object obj);

    /** TODO
     * Questo metodo aggiunge l'oggetto passato in input alla posizione i-esima.
     * ES: lista = [a,b,c] add(1, D) modifica la lista in [a,D,b,c]
     * Lancia una IndexOutOfBoundsException se l'indice non è conforme.
     */
    //void add(int x, Object obj);

    /** TODO
     * Questo metodo restituisce una lista con gli elementi compresi tra gli indici di inizio e fine.
     * ES: lista = [a,b,c,d,e] sublist(1,3) restituisce [b,c,d]
     * Lancia una IndexOutOfBoundsException se gli indici non sono conformi.
     */
    //ListShozo sublist(int inizio, int fine);

}
