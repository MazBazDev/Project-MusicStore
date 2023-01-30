import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Storage {
    public ArrayList<Instruments> instruments;

    Storage() {
        this.instruments = new ArrayList<Instruments>();
    }

    public void addElectricGuitar() {
        this.instruments.add(new ElectricGuitar(askDouble("price"), askStr("brand"), askStr("model"), askInt("number of strings"), askWoodType(), askMicroType(), askTuneType()));
    }

    public void addViolin() {
        this.instruments.add(new Violin(askDouble("price"), askStr("brand"), askStr("model"), askInt("number of strings"), askWoodType(), askBowWood()));
    }

    public void addUprightPiano() {
        this.instruments.add(new UprightPiano(askDouble("price"), askStr("brand"), askStr("model"), askInt("amount of keys"), askDouble("tuning price"), askHammerWood()));
    }

    public void addArrangerKeyboard() {
        this.instruments.add(new ArrangerKeyboards(askDouble("price"), askStr("brand"), askStr("model"), askInt("amount of keys"), askInt("amount of sounds")));
    }

    public AcousticPercussions createBassDrum() {
        return new BassDrum(askStr("brand"), askStr("model"), askDouble("price"), askDouble("diameter"), askMaterial(), askStr("sound produced by it"));

    }
    public AcousticPercussions createSnareDrum() {
        return new SnareDrum(askStr("brand"), askStr("model"), askDouble("price"), askDouble("diameter"), askMaterial(), askStr("sound produced by it"));
    }

    public AcousticPercussions createCymbal() {
        return new Cymbal(askStr("brand"), askStr("model"), askDouble("price"), askDouble("diameter"), askMaterial(), askStr("sound produced by it"));
    }

    public AcousticPercussions createCharleston() {
        return new Charleston(askStr("brand"), askStr("model"), askDouble("price"), askDouble("diameter"), askMaterial(), askStr("sound produced by it"));

    }

    public AcousticPercussions createTom() {
        return new Tom(askStr("brand"), askStr("model"), askDouble("price"), askDouble("diameter"), askMaterial(), askStr("sound produced by it"));
    }

    public ElectronicPercussion createBassPad() {
        return new BassPad(askStr("brand"), askStr("model"), askDouble("price"), askDouble("diameter"), askMaterial(), askStr("sound produced by it"));
    }

    public ElectronicPercussion createCymbalPad() {
        return new CymbalPad(askStr("brand"), askStr("model"), askDouble("price"), askDouble("diameter"), askMaterial(), askStr("sound produced by it"));
    }

    public ElectronicPercussion createTomPad() {
        return new TomPad(askStr("brand"), askStr("model"), askDouble("price"), askDouble("diameter"), askMaterial(), askStr("sound produced by it"));
    }

    public void addElectronicDrumKit() {
        instruments.add(new ElectronicDrumKit(askStr("brand"), askStr("model"), askDouble("price"), askDrumKitStatus(), askStr("decoration")));
    }

    public void addAcousticDrumKit() {
        instruments.add(new AcousticDrumKit(askStr("brand"), askStr("model"), askDouble("price"), askDrumKitStatus(), askStr("decoration")));
    }


    //public void add
    public void displayAllWithIndexes() {
        if (instruments.isEmpty()) {
            System.out.println("\033[0;92m+===================================================================================+");
            System.out.println("\033[0;92m| \033[0;91mEmpty storage \033[0;92m");
            System.out.println("\033[0;92m+===================================================================================+");
        } else {
            int counter = 0;

            Iterator<Instruments> iter = instruments.iterator();

            System.out.println("\033[0;92m+================================[ All with indexes ]================================+");
            while (iter.hasNext()) {
                System.out.println("\033[0;92m|\033[0;93m " + counter +" \033[0;92m· \033[0;97m" + iter.next().toString());
                counter++;
            }

            System.out.println("\033[0;92m| \033[0;97mAmount : \033[0;93m" + counter);
            System.out.println("\033[0;92m+===================================================================================+");

        }
    }

    public void displayAllExhibited() {
        int counter = 0;
        int amount = 0;

        Iterator<Instruments> iter = instruments.iterator();

        System.out.println("\033[0;92m+==============================[ All exhibited ]=============================+");

        for (Instruments i:instruments) {
            if (i.getState() == Instruments.Status.display) {
                System.out.println("\033[0;92m|\033[0;93m " + counter +" \033[0;92m· \033[0;97m" + i.toString());
                amount++;
            }
            counter++;
        }

        if (amount > 0) {
            System.out.println("\033[0;92m| \033[0;97mAmount : \033[0;93m" + counter);
        } else {
            System.out.println("\033[0;92m| \033[0;97mAny instruments displayed");
        }
        System.out.println("\033[0;92m+===================================================================================+");
    }
    public void displayAllStocked() {
        int counter = 0;
        int amount = 0;

        Iterator<Instruments> iter = instruments.iterator();

        System.out.println("\033[0;92m+==============================[ All stocked ]=============================+");

        for (Instruments i:instruments) {
            if (i.getState() == Instruments.Status.stock) {
                System.out.println("\033[0;92m|\033[0;93m " + counter +" \033[0;92m· \033[0;97m" + i.toString());
                amount++;
            }
            counter++;
        }

        if (amount > 0) {
            System.out.println("\033[0;92m| \033[0;97mAmount : \033[0;93m" + counter);
        } else {
            System.out.println("\033[0;92m| \033[0;97mAny instruments stocked");
        }
        System.out.println("\033[0;92m+===================================================================================+");
    }

    private int askInt(String title) {
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("\033[0;92m| \033[0;97mEnter "+ title +": \033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);
        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            return askInt(title);
        }
    }

    private double askDouble(String title) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("\033[0;92m| \033[0;97mEnter "+ title +": \033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");

        try {
            return Double.parseDouble(scan.nextLine());
        } catch (NumberFormatException e) {
            return askDouble(title);
        }
    }

    private String askStr(String title) {
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("\033[0;92m| \033[0;97mEnter "+ title +": \033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);
        return scan.nextLine().toString();
    }

    /* Electric Guitar */

    private static ElectricGuitar.WoodType askWoodType() {
        System.out.println("\033[0;92m+================================[ Select wood type ]===============================+");
        int counter = 1;
        for (ElectricGuitar.WoodType i : ElectricGuitar.WoodType.values()) {
            System.out.println("\033[0;92m|\033[0;93m " + counter +" \033[0;92m· \033[0;97m" + i.name());

            counter++;
        }
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            counter = 1;
            int selected = Integer.parseInt(scan.nextLine());
            for (ElectricGuitar.WoodType i : ElectricGuitar.WoodType.values()) {
                if(counter == selected) {
                    return i;
                }
                counter++;
            }
        } catch (NumberFormatException e) {}

        return askWoodType();
    }

    private ElectricGuitar.MicroType askMicroType() {
        System.out.println("\033[0;92m+================================[ Select micro type ]==============================+");

        int counter = 1;
        for (ElectricGuitar.MicroType i : ElectricGuitar.MicroType.values()) {
            System.out.println("\033[0;92m|\033[0;93m " + counter +" \033[0;92m· \033[0;97m" + i.name());

            counter++;
        }
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            counter = 1;
            int selected = Integer.parseInt(scan.nextLine());
            for (ElectricGuitar.MicroType i : ElectricGuitar.MicroType.values()) {
                if(counter == selected) {
                    return i;
                }
                counter++;
            }
        } catch (NumberFormatException e) {}

        return askMicroType();
    }

    private ElectricGuitar.TuneType askTuneType() {
        System.out.println("\033[0;92m+================================[ Select tune type ]===============================+");

        int counter = 1;
        for (ElectricGuitar.TuneType i : ElectricGuitar.TuneType.values()) {
            System.out.println("\033[0;92m|\033[0;93m " + counter +" \033[0;92m· \033[0;97m" + i.name());
            counter++;
        }
        System.out.println("\033[0;92m+===================================================================================+");


        Scanner scan = new Scanner(System.in);

        try {
            counter = 1;
            int selected = Integer.parseInt(scan.nextLine());
            for (ElectricGuitar.TuneType i : ElectricGuitar.TuneType.values()) {
                if(counter == selected) {
                    return i;
                }
                counter++;
            }
        } catch (NumberFormatException e) {}

        return askTuneType();
    }

    /* END Electric Guitar */



    /* Violin*/

    private Violin.BowWood askBowWood() {
        System.out.println("\033[0;92m+==============================[ Select bow wood type ]=============================+");

        int counter = 1;
        for (Violin.BowWood  i : Violin.BowWood .values()) {
            System.out.println("\033[0;92m|\033[0;93m " + counter +" \033[0;92m· \033[0;97m" + i.name());
            counter++;
        }

        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            counter = 1;
            int selected = Integer.parseInt(scan.nextLine());
            for (Violin.BowWood  i : Violin.BowWood .values()) {
                if(counter == selected) {
                    return i;
                }
                counter++;
            }
        } catch (NumberFormatException e) {}

        return askBowWood ();
    }
    /* END Violin */


    /* Upright Piano */
    private static UprightPiano.hammerWoods askHammerWood() {
        System.out.println("\033[0;92m+============================[ Select hammer wood type ]============================+");

        int counter = 1;
        for (UprightPiano.hammerWoods i : UprightPiano.hammerWoods.values()) {
            System.out.println("\033[0;92m|\033[0;93m " + counter +" \033[0;92m· \033[0;97m" + i.name());
            counter++;
        }
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            counter = 1;
            int selected = Integer.parseInt(scan.nextLine());
            for (UprightPiano.hammerWoods i : UprightPiano.hammerWoods.values()) {
                if(counter == selected) {
                    return i;
                }
                counter++;
            }
        } catch (NumberFormatException e) {}

        return askHammerWood();
    }

    /* END Upright Piano */

    private static Percussions.Material askMaterial() {
        System.out.println("\033[0;92m+=============================[ Select a material type ]============================+");

        int counter = 1;
        for (Percussions.Material i : Percussions.Material.values()) {
            System.out.println("\033[0;92m|\033[0;93m " + counter +" \033[0;92m· \033[0;97m" + i.name());
            counter++;
        }
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            counter = 1;
            int selected = Integer.parseInt(scan.nextLine());
            for (Percussions.Material i : Percussions.Material.values()) {
                if(counter == selected) {
                    return i;
                }
                counter++;
            }
        } catch (NumberFormatException e) {}

        return askMaterial();
    }

    private static DrumKit.Status askDrumKitStatus() {
        System.out.println("\033[0;92m+================================[ Select a status ]================================+");

        int counter = 1;
        for (DrumKit.Status i : DrumKit.Status.values()) {
            System.out.println("\033[0;92m|\033[0;93m " + counter +" \033[0;92m· \033[0;97m" + i.name());

            counter++;
        }
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            counter = 1;
            int selected = Integer.parseInt(scan.nextLine());
            for (DrumKit.Status i : DrumKit.Status.values()) {
                if(counter == selected) {
                    return i;
                }
                counter++;
            }
        } catch (NumberFormatException e) {}

        return askDrumKitStatus();
    }
    public void editInstrument(Instruments instrument, int option) {
        switch (option) {
            case 1:
                instrument.setPrice(askDouble("price"));
                break;
            case 2:
                instrument.exhibit();
                System.out.println("Instrument exhibited");
                break;
            case 3:
                instrument.putInStock();
                System.out.println("Instrument puts in stock");
                break;
        }

        if (instrument instanceof ElectricGuitar) {
            switch (option) {
                case 4:
                    ((ElectricGuitar) instrument).Tune();
                    break;
                case 5:
                    ((ElectricGuitar) instrument).setTuneType(askTuneType());
                    ((ElectricGuitar) instrument).Tune();
                    break;
                case 6:
                    ((ElectricGuitar) instrument).setMicroType(askMicroType());
                    break;
            }
            
        } else if (instrument instanceof Violin) {
            switch (option) {
                case 4:
                    ((Violin) instrument).Tune();
                    break;
                case 5:
                    ((Violin) instrument).setBowWood(askBowWood());
                    break;
            }
            
        } else if (instrument instanceof  UprightPiano) {
            switch (option) {
                case 4 -> ((UprightPiano) instrument).Tune();
                case 5 -> ((UprightPiano) instrument).setTuningPrice(askDouble("tuning price"));
                case 6 -> ((UprightPiano) instrument).setHammerWood(askHammerWood());
            }
        } else if (instrument instanceof AcousticPercussions || instrument instanceof ElectronicPercussion) {
            switch (option) {
                case 4:
                    System.out.println("Sound : " + ((HasSound) instrument).PlaySound());
                    break;
            }
            
        } else if (instrument instanceof AcousticDrumKit || instrument instanceof ElectronicDrumKit) {
            switch (option) {
                case 4:
                    System.out.println(((HasSound) instrument).PlaySound());
                case 5:
                    if (instrument instanceof AcousticDrumKit) {
                        ((AcousticDrumKit) instrument).addPercussion(Main.selectAcousticPercussion());
                    } else if (instrument instanceof  ElectronicPercussion) {
                        ((ElectronicDrumKit) instrument).addPercussion(Main.selectElectronicPercussion());

                    }
            }
        }

        System.out.println("\033[0;92m+============================[ Instrument updated ! ]============================+");
        System.out.println("\033[0;92m|\033[0;97m " + instrument.toString() + "\033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+\n");

        Scanner scan = new Scanner(System.in);
        System.out.println("\033[0;92m+============================[ Update something else ? ]============================+");
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mYes\033[0;92m");
        System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;97mNo and go back\033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");

        if (Integer.parseInt(scan.nextLine()) == 1) {
            Main.displayEditOptions(instrument);
        }

    }

    public void sellInstrument(Instruments instru) {
        instruments.remove(instru);
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mInstrument deleted");
        System.out.println("\033[0;92m+===================================================================================+");
    }

}
