package cz.czechitas.ukol3.model;

public class Pocitac {
    private boolean jeZapnuty; // toto bude pouze field bez getteru a setteru
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    public Pocitac(Procesor cpu, Pamet ram, Disk pevnyDisk) {
        this.cpu = cpu;
        this.ram = ram;
        this.pevnyDisk = pevnyDisk;
    }

    public void vytvorSouborOVelikosti(long velikost) {
        long vyuziteMisto = pevnyDisk.getVyuziteMisto();
        long vyuziteMistoVysledek = vyuziteMisto + velikost;
        if (vyuziteMistoVysledek > pevnyDisk.getKapacitaDisk()) {
            System.err.println("Nelze vytvořit nový soubor, není dostatečná kapacita disku");
        } else {
            pevnyDisk.setVyuziteMisto(vyuziteMistoVysledek);
        }
    }

    public void vymazSouboryOVelikosti(long velikost) {

    }

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    public void zapniSe() {
        if (ram == null || cpu == null || pevnyDisk == null) {
            System.err.println("Chybí některý z komponentů (ram, cpu, pevný disk), počítač nelze zapnout");
        } else {
            if (jeZapnuty == true) {
                System.err.println("Počítač je již zapnutý");
            } else {
                this.jeZapnuty = true;
                System.out.println("Počítač je zapnutý");
            }
        }
    }

    public void vypniSe() {
        if (jeZapnuty == true) {
            this.jeZapnuty = false;
            System.out.println("Počítač je vypnutý");
        }
    }

    @Override
    public String toString() {
        return "Dráži počítač " +
                "je zapnutý, " + jeZapnuty + ". " +
                "Procesor je " + cpu +
                " Ram je" + ram +
                " Pevný disk " + pevnyDisk;
    }
}
