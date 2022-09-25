package teoria;

public class StraniEventiConChar {

    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        System.out.println(a);
        System.out.println(b);

        int aPlusBint = 'a' + 'b';
        char aPlusBchar = 'a' + 'b';
        System.out.println(aPlusBint); //195
        System.out.println(aPlusBchar); //Ã -> somma i due valori ASCII e restituisce il carattere ASCII corrispondente a tale numero
        System.out.println(a + b); //195
        System.out.println(a - b); //-1
        System.out.println(a * b); //9506
        System.out.println(a / b); //0
        System.out.println(a + "" + b); //"ab"
        System.out.println("" + a + b); //"ab"
        System.out.println(a + 0); //97
        System.out.println('A' + 0); //65;

        /**
         Questi strani fenomeni si spiegano col fatto che i char hanno associato un
         valore numerico, corrispondente al loro codice ASCII
         (American Standard Code for Information Interchange);
         Pertanto, se vi trovate a sommarli aspettandovi di trovare una stringa concatenata
         come output, ricordatevi SEMPRE di anteporre "" + alla sequenza di concatenazioni

         char x = charA + charB  -> char con codice ASCII pari alla somma dei codici ASCII di a e b
         char + char             -> int
         char + String           -> stringa con valore ASCII del char seguito dalla stringa
         String + char           -> stringa seguita dal valore alfabetico del char
         */

    }
}
