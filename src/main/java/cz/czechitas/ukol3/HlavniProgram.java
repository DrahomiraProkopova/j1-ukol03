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

        Procesor mujProcesor = new Procesor();
        Pamet mojePamet = new Pamet();
        Disk mujDisk = new Disk();

        Pocitac draziPocitac = new Pocitac(mujProcesor, mojePamet, mujDisk);

        Procesor draziProcesor = new Procesor();
        draziProcesor.setRychlost(430_330L);
        draziProcesor.setVyrobce("Intel");

        Pamet draziPamet = new Pamet();
        draziPamet.setKapacitaPamet(500_100L);

        Disk draziDisk = new Disk();
        draziDisk.setKapacitaDisk(800_900L);

        draziPocitac.setCpu(draziProcesor);
        draziPocitac.setPevnyDisk(draziDisk);
        draziPocitac.setRam(draziPamet);

        draziPocitac.zapniSe();
        draziPocitac.vypniSe();
        draziPocitac.vytvorSouborOVelikosti(980L);
        draziPocitac.vymazSouboryOVelikosti(1_900L);

        System.out.println(draziPocitac.toString());
    }

}
