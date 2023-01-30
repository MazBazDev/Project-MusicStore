import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ExecutionException;

public class Main {
    private static Storage storage = new Storage();

    public static void main(String[] args) {
        Integer selected = displayMenu();

        switch (selected) {
            case 0:
                System.exit(0);
            case 1:
                addInstrument();
                break;
            case 3:
                displayEditOptions(displayEditMenu("instrument id"));
                break;

        }
        if (!storage.instruments.isEmpty()) {
            switch (selected) {
                case 2:
                    storage.sellInstrument(displayEditMenu("instrument id"));
                    break;
                case 4:
                    storage.displayAllStocked();
                    break;
                case 5:
                    storage.displayAllExhibited();
                    break;
                case 6:
                    storage.displayAllWithIndexes();
                    break;
            }
        }
        main(args);
    }

    public static int displayMenu() {
        System.out.println(
                "\033[0;96m███╗   ███╗██╗   ██╗███████╗██╗ ██████╗    ███████╗████████╗ ██████╗ ██████╗ ███████╗\n" +
                "████╗ ████║██║   ██║██╔════╝██║██╔════╝    ██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗██╔════╝\n" +
                "██╔████╔██║██║   ██║███████╗██║██║         ███████╗   ██║   ██║   ██║██████╔╝█████╗  \n" +
                "██║╚██╔╝██║██║   ██║╚════██║██║██║         ╚════██║   ██║   ██║   ██║██╔══██╗██╔══╝  \n" +
                "██║ ╚═╝ ██║╚██████╔╝███████║██║╚██████╗    ███████║   ██║   ╚██████╔╝██║  ██║███████╗\n" +
                "╚═╝     ╚═╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝    ╚══════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝\n");
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mBuy an instrument");
        if (!storage.instruments.isEmpty()) {
            System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;97mSell an instrument");
            System.out.println("\033[0;92m|\033[0;93m 3 \033[0;92m· \033[0;97mManage instrument");
            System.out.println("\033[0;92m|\033[0;93m 4 \033[0;92m· \033[0;97mList all in stock");
            System.out.println("\033[0;92m|\033[0;93m 5 \033[0;92m· \033[0;97mList all exhibited");
            System.out.println("\033[0;92m|\033[0;93m 6 \033[0;92m· \033[0;97mList all with indexes");
        }
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mExit");
        System.out.println("\033[0;92m+===================================================================================+");
        Scanner scan = new Scanner(System.in);

        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            return displayMenu();
        }
    }

    public static void addInstrument() {
        System.out.println("\033[0;92m+===============================[ Select a category ]==============================+");
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mStrings instrument");
        System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;97mKeyboard instrument");
        System.out.println("\033[0;92m|\033[0;93m 3 \033[0;92m· \033[0;97mPercussion");
        System.out.println("\033[0;92m|\033[0;93m 4 \033[0;92m· \033[0;97mDrumKit");
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mGo back");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            switch (Integer.parseInt(scan.nextLine())) {
                case 0:
                    break;
                case 1:
                    addStringsInstrument();
                    break;
                case 2:
                    addKeyboardsInstrument();
                    break;
                case 3:
                    addPercussionInstrument();
                    break;
                case 4:
                    manageDrumKit();
                    break;
            }
        } catch (NumberFormatException e) {}
    }


    public static void manageDrumKit() {
        System.out.println("\033[0;92m+================================[ Select an option ]===============================+");
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mCreate new drum kit");

        if (storage.instruments.contains(DrumKit.class)) {
            System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;97mAdd percussion to an existing drum kit\033[0;92m");
        }

        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mGo back");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            switch (Integer.parseInt(scan.nextLine())) {
                case 0:
                    break;
                case 1:
                    createDrumKit();
                    break;
                case 2:
                    if (storage.instruments.contains(DrumKit.class)) {
                        editDrumKit(selectDrumKit());
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            manageDrumKit();
        }
    }

    public static void createDrumKit() {
        System.out.println("\033[0;92m+================================[ Select an option ]===============================+");
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mAcoustic drum kit\033[0;92m");
        System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;97mElectronic drum kit\033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mGo back");
        System.out.println("\033[0;92m+===================================================================================+");
        Scanner scan = new Scanner(System.in);

        try {
            switch (Integer.parseInt(scan.nextLine())) {
                case 0:
                    break;
                case 1:
                    storage.addAcousticDrumKit();
                    break;
                case 2:
                    storage.addElectronicDrumKit();
                    break;
            }
        } catch (NumberFormatException e) {
            addInstrument();
        }
    }

    public static Instruments selectDrumKit() {
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("\033[0;92m| \033[0;97mEnter a drum kit id: \033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            Instruments selected = storage.instruments.get(Integer.parseInt(scan.nextLine()));
            if (selected instanceof DrumKit) {
                return selected;
            } else {
                selectDrumKit();
            }
        } catch (NumberFormatException e) {
            return selectDrumKit();
        }
        return null;
    }

    public static void editDrumKit(Instruments drumkit) {
        try {
            if (drumkit instanceof AcousticDrumKit){
                ((AcousticDrumKit) drumkit).addPercussion(selectAcousticPercussion());
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        editDrumKit(drumkit);
    }

    public static void addPercussionInstrument() {
        System.out.println("\033[0;92m+==============================[ Select an instrument ]=============================+");
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mAcoustic percussion\033[0;92m");
        System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;97mElectronic percussion\033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mGo back");
        System.out.println("\033[0;92m+===================================================================================+");
        Scanner scan = new Scanner(System.in);

        try {
            switch (Integer.parseInt(scan.nextLine())) {
                case 0:
                    break;
                case 1:
                    storage.instruments.add(selectAcousticPercussion());
                    break;
                case 2:
                    storage.instruments.add(selectElectronicPercussion());
                    break;
            }
        } catch (NumberFormatException e) {
            addInstrument();
        }
    }

    public static AcousticPercussions selectAcousticPercussion() {
        System.out.println("\033[0;92m+==============================[ Select an instrument ]=============================+");
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mBass drum");
        System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;97mSnare drum");
        System.out.println("\033[0;92m|\033[0;93m 3 \033[0;92m· \033[0;97mCymbal");
        System.out.println("\033[0;92m|\033[0;93m 4 \033[0;92m· \033[0;97mCharleston");
        System.out.println("\033[0;92m|\033[0;93m 5 \033[0;92m· \033[0;97mTom");
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mGo back");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            switch (Integer.parseInt(scan.nextLine())) {
                case 0:
                    break;
                case 1:
                    return storage.createBassDrum();
                case 2:
                    return storage.createSnareDrum();
                case 3:
                    return storage.createCymbal();
                case 4:
                    return storage.createCharleston();
                case 5:
                    return storage.createTom();
            }
        } catch (NumberFormatException e) {
            selectAcousticPercussion();
        }

        return null;
    }

    public static ElectronicPercussion selectElectronicPercussion() {
        System.out.println("\033[0;92m+==============================[ Select an instrument ]=============================+");
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mBass pad\033[0;92m");
        System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;Tom pad\033[0;92m");
        System.out.println("\033[0;92m|\033[0;93m 3 \033[0;92m· \033[0;Cymbal pad\033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mGo back\033[0;92m");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mGo back\033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            switch (Integer.parseInt(scan.nextLine())) {
                case 0:
                    break;
                case 1:
                    return storage.createBassPad();
                case 2:
                    return storage.createTomPad();
                case 3:
                    return storage.createCymbalPad();
            }
        } catch (NumberFormatException e) {
            selectElectronicPercussion();
        }

        return null;
    }

    public static void addStringsInstrument() {
        System.out.println("\033[0;92m+==============================[ Select an instrument ]=============================+");
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mElectric guitar\033[0;92m");
        System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;97mViolin\033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mGo back");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            switch (Integer.parseInt(scan.nextLine())) {
                case 0:
                    break;
                case 1:
                    storage.addElectricGuitar();
                    break;
                case 2:
                    storage.addViolin();
                    break;
            }
        } catch (NumberFormatException e) {
            addInstrument();
        }
    }

    public static void addKeyboardsInstrument() {
        System.out.println("\033[0;92m+==============================[ Select an instrument ]=============================+");
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mUpright piano\033[0;92m");
        System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;97mArranger keyboard\033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("|\033[0;93m 0 \033[0;92m· \033[0;91mGo back");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            switch (Integer.parseInt(scan.nextLine())) {
                case 0:
                    break;
                case 1:
                    storage.addUprightPiano();
                    break;
                case 2:
                    storage.addArrangerKeyboard();
                    break;
            }
        } catch (NumberFormatException e) {
            addInstrument();
        }
    }

    public static Instruments displayEditMenu(String title) {
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("\033[0;92m| \033[0;97mEnter " + title +": \033[0;92m");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            int selected = Integer.parseInt(scan.nextLine());
            if (selected < storage.instruments.size()) {
                return storage.instruments.get(selected);
            } else {
                System.out.println("\033[0;92m+===================================================================================+");
                System.out.println("\033[0;92m| \033[0;91mThis instrument doesn't exist \033[0;92m");
                System.out.println("\033[0;92m+===================================================================================+");
            }
        } catch (NumberFormatException e) {
            return displayEditMenu(title);
        }
        return displayEditMenu(title);
    }

    public static void displayEditOptions(Instruments instrument) {
        System.out.println("\033[0;92m+================================[ Select an option ]===============================+");
        System.out.println("\033[0;92m|\033[0;93m" + instrument.toString());
        System.out.println("\033[0;92m|\033[0;93m 1 \033[0;92m· \033[0;97mChange price");

        if (instrument.getState() == Instruments.Status.stock) {
            System.out.println("\033[0;92m|\033[0;93m 2 \033[0;92m· \033[0;97mExhibit");

        } else {
            System.out.println("\033[0;92m|\033[0;93m 3 \033[0;92m· \033[0;97mPut in stock");

        }


        if (instrument instanceof ElectricGuitar) {
            System.out.println("\033[0;92m|\033[0;93m 4 \033[0;92m· \033[0;97mTune");
            System.out.println("\033[0;92m|\033[0;93m 5 \033[0;92m· \033[0;97mChange tune type");
            System.out.println("\033[0;92m|\033[0;93m 6 \033[0;92m· \033[0;97mChange micro type");

        } else if (instrument instanceof Violin) {
            System.out.println("\033[0;92m|\033[0;93m 4 \033[0;92m· \033[0;97mTune");
            System.out.println("\033[0;92m|\033[0;93m 5 \033[0;92m· \033[0;97mChange bow wood type");

        } else if (instrument instanceof  UprightPiano) {
            System.out.println("\033[0;92m|\033[0;93m 4 \033[0;92m· \033[0;97mTune");
            System.out.println("\033[0;92m|\033[0;93m 5 \033[0;92m· \033[0;97mChange tune price");
            System.out.println("\033[0;92m|\033[0;93m 6 \033[0;92m· \033[0;97mChange hammer wood type");

        } else if (instrument instanceof Percussions) {
            System.out.println("\033[0;92m|\033[0;93m 4 \033[0;92m· \033[0;97mPlay sound");

        } else if (instrument instanceof AcousticDrumKit || instrument instanceof  ElectronicDrumKit) {
            System.out.println("\033[0;92m|\033[0;93m 4 \033[0;92m· \033[0;97mPlay all sounds");
            System.out.println("\033[0;92m|\033[0;93m 5 \033[0;92m· \033[0;97mAdd percussion");
        }
        System.out.println("\033[0;92m+===================================================================================+");
        System.out.println("\033[0;92m|\033[0;93m 0 \033[0;92m· \033[0;91mGo back");
        System.out.println("\033[0;92m+===================================================================================+");

        Scanner scan = new Scanner(System.in);

        try {
            int selected = Integer.parseInt(scan.nextLine());

            if (selected != 0) {
                storage.editInstrument(instrument, selected);
            }

        } catch (NumberFormatException e) {
            displayEditOptions(instrument);
        }
    }
}
