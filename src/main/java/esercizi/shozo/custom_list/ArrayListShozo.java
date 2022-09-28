package esercizi.shozo.custom_list;

import lombok.Getter;
import teoria.custom_list.CustomArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class ArrayListShozo implements ListShozo {

    private Object[] array;
    private int size;

    public ArrayListShozo() {
        this.array = new Object[0];
        this.size = 0;
    }

    public ArrayListShozo(List javaLst) {
      this.array=new Object[javaLst.size()];
      this.size= javaLst.size();

      int count=0;
      for(Object elemento: javaLst){
          this.array[count]=elemento;
          count++;
      }
    }


    public static void main(String[] args) {

        ArrayListShozo obj=  new ArrayListShozo();
        obj.array = new Object[3];
        obj.array[0]="a";
        obj.array[1]="b";
        obj.array[2]="c";


        CustomArrayList list = new CustomArrayList();
        System.out.println(list);
//        list.add("cane");
//        list.add("gatto");
//        System.out.println(list);

//        ArrayListShozo list2 = new ArrayListShozo();
//        list2.add("1");
//        list2.add("2");
//        list2.add("3");
//        ArrayListShozo obj=  new ArrayListShozo();
//        Boolean ris= obj.addAll(list2);
        //System.out.println(list2.get(2));



        //System.out.println(obj.set(1, "B"));
        //System.out.println(obj.indexOf("b"));
//        System.out.println(obj.lastIndexOf("b"));


        obj.add(2,"d");
    }

   public void add(int x, Object obj){
       checkIndex(x);

       Object [] arrOk= new Object[array.length + 1];

       Boolean aggiunto=false;
       for(int i=0; i <= array.length;i++)
       {
           if(i!=x){
               if(aggiunto){
                   arrOk[i]=array[i-1];
               }
               else{
                   arrOk[i]=array[i];
               }
           }
           else{
               arrOk[i]=obj;
               aggiunto=true;
           }
           System.out.println(arrOk[i]);
       }
    }

    public ListShozo sublist(int inizio, int fine){
        checkIndex(inizio);
        checkIndex(fine);

        ListShozo newLista = new ArrayListShozo();

        for(int i=0; i < array.length;i++)
        {
            if(i>=inizio && i<=fine){
                newLista.add(array[i]);
            }
        }

        return newLista;
    }

    private void checkIndex(int x){
        if (x < 0 || x >= array.length) {
            throw new IndexOutOfBoundsException(
                    "Indice " + x + " non valido. Dimensione lista: " + array.length);
        }
    }
    //ListShozo sublist(int inizio, int fine);


    public Object set(int x, Object obj){
        checkIndex(x);

        Object oldValue= array[x];

        array[x]=obj;

        return oldValue;
    }

    public int indexOf(Object obj){
        for(int i=0; i < array.length;i++)
        {
             if(Objects.equals(array[i],obj)){
                 return  i;
             }
        }
        return -1;
    }

    public  int lastIndexOf(Object obj){
        for(int i=array.length-1; i>=0;i--)
        {
            if(Objects.equals(array[i],obj)){
                return  i;
            }
        }
        return -1;
    }



    public boolean isEmpty() {

        return this.array.length == 0;
    }

    public void clear(){
        this.array = new Object[0];
        this.size = 0;
    }

    public boolean contains(Object obj){
        Boolean ris=false;
            for (int i = 0; i < array.length; i++) {
                Object elementoScansionato = array[i];
                // se l'elemento scansionato corrisponde all'oggetto in input
                if (elementoScansionato == obj || elementoScansionato.equals(obj)) {
                    ris= true;
                }
                else{
                    ris= false;
                }
            }
     return ris;
    }



    public boolean addAll(ListShozo list){
        Object [] arrOk= new Object[this.size + list.size()];

        for(int i=0; i < array.length;i++)
        {
            arrOk[i]=array[i];
        }

        Boolean aggiunto=false;
        for(int i=0; i < list.size();i++)
        {
           arrOk[array.length+i]=list.get(i);

            aggiunto=true;
        }

        size=arrOk.length;

        array=arrOk;
        return aggiunto;
    }

    public Object remove(int x){

        checkIndex(x);

        Object elementEliminato=null;
        Object [] arrOk= new Object[ array.length-1];
        for (int i = 0; i < array.length; i++) {
            // se l'elemento scansionato corrisponde all'oggetto in input
           if(i!=x){
               arrOk[i]=array[i];
           }
           else {
               elementEliminato=array[i];
           }
        }
        size-=1;
        return elementEliminato;
    }

    public Object get(int i) {
        checkIndex(i);
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
    public boolean equals(Object obj) {
        if (obj instanceof ArrayListShozo && obj != null) {
            ArrayListShozo casted = (ArrayListShozo) obj;
            if (casted.size == this.size) {
                for (int i = 0; i < this.size; i++) {
                    if (!Objects.equals(casted.array[i], this.array[i])) {
                        return false;
                    }
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
        for (int i = 0; i < size; i++) {
            result += i == size - 1 ? array[i] : array[i] + ",";
        }
        result += "]";
        return result;
    }
}
