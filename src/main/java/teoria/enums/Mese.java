package teoria.enums;

import lombok.Getter;

@Getter
// gli enum sono SEMPRE implicitamente public (non avrebbe senso fare un enum private)
// tuttavia sono "visibili" solo all'interno del package d'origine (in questo caso enums).
// Se spostate TestEnum dalla cartella enums a java, segnalerà errore, dicendovi di rendere
// Mese public
enum Mese {
    // gli elementi dell'enum per convenzione si scrivono maiuscoli (sono costanti dopotutto) separati da virgole.
    GENNAIO(1),
    FEBBRAIO(2),
    MARZO(3),
    APRILE(4),
    MAGGIO(5),
    GIUGNO(6),
    LUGLIO(7),
    AGOSTO(8),
    SETTEMBRE(9),
    OTTOBRE(10),
    NOVEMBRE(11),
    DICEMBRE(12);

    private int numeroMese;

    // i costruttori degli enum sono SEMPRE implicitamente privati
    // (non dev'essere possibile istanziare un enum al di fuori della classe)
    Mese(int numeroMese) {
        this.numeroMese = numeroMese;
    }
}
