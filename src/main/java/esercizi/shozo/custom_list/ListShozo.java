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
    //Object remove(int x);

}
