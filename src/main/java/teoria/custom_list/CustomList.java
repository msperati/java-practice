package teoria.custom_list;

public interface CustomList {

    Object get(int x);

    boolean add(Object a);

    boolean remove(Object a);

    int size();

    /**
     * Questo metodo restituisce true se la lista è vuota, false se contiene uno o più elementi al suo interno
     */
    //boolean isEmpty();

    /**
     * Questo metodo deve svuotare completamente la lista
     */
    //void clear();

    /**
     * Questo metodo restituisce true se la lista contiene l'elemento passato in input, false se non lo contiene
     */
    //bolean contains(Object obj);

    /**
     * Questo metodo prende in input un'altra CustomList e deve aggiungere tutti i suoi elementi alla lista corrente
     */
    //boolean addAll(CustomList list);

    /**
     * Questo metodo, dato un indice in input, deve modificare la lista rimuovendo l'oggetto all'indice x.
     * Restituisce true se l'oggetto era presente ed è stato rimosso, false se non era presente.
     */
    //boolean remove(int x);
}
