package esercizi;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class NumeroRomanoExceptionShozo  extends  RuntimeException{

    private static List<String> NUMERI_ROMANI = Arrays.asList(new String[]{"M", "D", "C", "L", "X", "V", "I"});
    private String message;

    public NumeroRomanoExceptionShozo(String input) {
        if (input==null){
            this.message = "Messaggio null. Inserire una stringa";
        }else if(input==""){
            this.message = "Messaggio stringa vuota. Inserire una stringa";
        }
        else{
            String[] arrInput=input.split("");
            for(String elem: arrInput){
                if(!NUMERI_ROMANI.contains(elem)){
                    this.message = "Input non valido:" + input + " Solo caratteri romani please";
                    break;
                }
            }
        }

    }
}
