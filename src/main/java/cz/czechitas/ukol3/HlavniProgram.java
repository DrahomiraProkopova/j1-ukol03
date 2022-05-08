package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Disk;
import cz.czechitas.ukol3.model.Pamet;
import cz.czechitas.ukol3.model.Pocitac;
import cz.czechitas.ukol3.model.Procesor;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        //TODO tady bude váš kód - vytvoření instance třídy Pocitac, zapnutí, vpynutí, výpis hodnot.
        System.out.println("Program spuštěn.");

        Procesor draziProcesor = new Procesor();
        Pamet draziPamet = new Pamet();
        Disk draziDisk = new Disk();
        Disk druhyDisk = new Disk();

        Pocitac draziPocitac = new Pocitac(draziProcesor, draziPamet, draziDisk, druhyDisk);

        draziProcesor.setRychlost(430_330L);
        draziProcesor.setVyrobce("Intel");
        draziPamet.setKapacitaPamet(500_100L);
        draziDisk.setKapacitaDisk(800_900L);
        druhyDisk.setKapacitaDisk(1_000_100L);

        draziPocitac.zapniSe();
        draziPocitac.vytvorSouborOVelikosti(1_000_000L);
        draziPocitac.vymazSouboryOVelikosti(1_000_000L);
        System.out.println(draziPocitac.toString());
    }

}
