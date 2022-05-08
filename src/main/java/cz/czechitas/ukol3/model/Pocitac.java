package cz.czechitas.ukol3.model;

public class Pocitac {
    private boolean jeZapnuty; // toto bude pouze field bez getteru a setteru
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;
    private Disk druhyDisk;

    public Pocitac(Procesor cpu, Pamet ram, Disk pevnyDisk, Disk druhyDisk) {
        this.cpu = cpu;
        this.ram = ram;
        this.pevnyDisk = pevnyDisk;
        this.druhyDisk = druhyDisk;
    }

    public Disk getDruhyDisk() {
        return druhyDisk;
    }

    public void setDruhyDisk(Disk druhyDisk) {
        this.druhyDisk = druhyDisk;
    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (jeZapnuty == true) {
            long vyuziteMisto = pevnyDisk.getVyuziteMisto();
            long vyuziteMistoVysledek = vyuziteMisto + velikost;
            if (vyuziteMistoVysledek > pevnyDisk.getKapacitaDisk()) {
                long vyuziteMistoDruhyDisk = druhyDisk.getVyuziteMisto();
                long vyuziteMistoVysledekDruhyDisk = vyuziteMistoDruhyDisk + velikost;
                if (vyuziteMistoVysledekDruhyDisk > druhyDisk.getKapacitaDisk()) {
                    System.err.println("Nelze vytvořit nový soubor, není dostatečná kapacita disku");
                } else {
                    druhyDisk.setVyuziteMisto(vyuziteMistoVysledekDruhyDisk);
                }
            } else {
                pevnyDisk.setVyuziteMisto(vyuziteMistoVysledek);
            }
        } else {
            System.err.println("Počítač je vypnutý, prosím zapněte jej.");
        }
    }

    public void vymazSouboryOVelikosti(long velikost) {
        if (jeZapnuty == true) {
            long vyuziteMisto = pevnyDisk.getVyuziteMisto();
            long vyuziteMistoZbytek = vyuziteMisto - velikost;
            if (vyuziteMistoZbytek < 0) {
                long vyuziteMistoDruhyDisk = druhyDisk.getVyuziteMisto();
                long vyuziteMistoDruhyDiskZbytek = vyuziteMistoDruhyDisk - velikost;
                if (vyuziteMistoDruhyDiskZbytek < 0) {
                    System.err.println("Nelze snížit využité místo, jelikož nemůže klesnout pod 0.");
                } else {
                    druhyDisk.setVyuziteMisto(vyuziteMistoDruhyDiskZbytek);
                }
            } else {
                pevnyDisk.setVyuziteMisto(vyuziteMistoZbytek);
            }
        } else {
            System.err.println("Počítač je vypnutý, prosím zapněte jej.");
        }
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
                " Pevný disk " + pevnyDisk+
                " Pevný druhý disk " + druhyDisk;
    }
}
