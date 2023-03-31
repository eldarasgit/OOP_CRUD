import java.util.ArrayList;
import java.util.Scanner;

public class Plant {
    public static ArrayList<Plant> plantList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static int idCount = 0;

    private final int id;
    private String name;
    private String latinName;
    private String continent;
    private int height;
    private boolean isAnnual;
    private boolean isEatable;

    public Plant() {
        this.id = idCount++;
    }

    public Plant(int id) {
        this.id = id;
    }

    public Plant(String name, String latinName, boolean isAnnual,
                 String continent, int height, boolean isEatable) {
        this.id = ++idCount;
        this.name = name;
        this.latinName = latinName;
        this.isAnnual = isAnnual;
        this.continent = continent;
        this.height = height;
        this.isEatable = isEatable;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatinName() {
        return this.latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getIsAnnual() {
        return this.isAnnual;
    }

    public void setIsAnnual(boolean isAnnual) {
        this.isAnnual = isAnnual;
    }

    public boolean getIsEatable() {
        return this.isEatable;
    }

    public void setIsEatable(boolean isEatable) {
        this.isEatable = isEatable;
    }

    @Override
    public String toString() {
        String annual = isAnnual ? "Annual" : "Not annual";
        String eatable = isEatable ? "Eatable" : "Not eatable";
        return "-----" + (this.id) + "-----" + "\n" +
                "Plant name: " + name + "\n" +
                "Latin Name: " + latinName + "\n" +
                "Continent: " + continent + "\n" +
                "Height: " + height + " m." + "\n" +
                annual + "\n" +
                eatable + "\n";
    }

    public static void info() {
        System.out.println("1. Pamatyti augalu sarasa");
        System.out.println("2. Filtruoti sarasa");
        System.out.println("3. Prideti augala");
        System.out.println("4. Redaguoti augala");
        System.out.println("5. Istrinti augala");
        System.out.println("6. Iseiti is saraso");
    }

    public static void printPlants() {
        for (int i = 0; i < Plant.plantList.size(); i++) {
            System.out.println(Plant.plantList.get(i));
        }
    }

    public static Plant createPlant(int id) {
        Plant pl;
        if (id == 0) {
            pl = new Plant();
        } else {
            pl = new Plant(id);
        }
        System.out.println("Iveskite augalo pavadinima: ");
        pl.setName(Validated.string(sc));
        System.out.println("Iveskite lotyniska pavadinima: ");
        pl.setLatinName(Validated.string(sc));
        System.out.println("Iveskite augalo paplityma: ");
        pl.setContinent(Validated.string(sc));
        System.out.println("Iveskita augalo auksti (m): ");
        pl.setHeight(Validated.heightMax(sc));
        System.out.println("Ar augalas vienmetis? (true/false)");
        pl.setIsAnnual(Validated.boolValid(sc));
        System.out.println("Ar augalas valgomas? (true/false)");
        pl.setIsEatable(Validated.boolValid(sc));
        sc.nextLine();
        return pl;
    }

    public static void filterPlants() {
        System.out.println("Pasirinkite lauka, pagal kuri norite filtruoti:");
        System.out.println("1. Pagal pavadinima:");
        System.out.println("2. Pagal lotyniska pavadinima:");
        System.out.println("3. Pagal augalo paplityma:");
        System.out.println("4. Pagal augalo auksti (m):");
        System.out.println("5. Pagal vienmecius/daugiamecius:");
        System.out.println("6. Pagal tinkamuma valgyti:");
        System.out.println("7. Nenoriu filtruoti!");
        int input = Validated.integer(sc);
        sc.nextLine();
        switch (input) {
            case 1:
                filterByName();
                break;
            case 2:
                filterByLatinName();
                break;
            case 3:
                filterByContinent();
                break;
            case 4:
                filterByHeight();
                break;
            case 5:
                filterByAnnual();
                break;
            case 6:
                filterByEatable();
                break;
            case 7:
                return;
            default:
                System.out.println("Pasirinkite kita varianta");
        }
    }

    public static void filterByName() {
        System.out.println("Iveskite pavadinima arba pavadinimo dali:");
        String input = sc.nextLine().toLowerCase().trim().replaceAll(" +", " ");
        int count = 0;
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).name.toLowerCase().contains(input)) {
                System.out.println(plantList.get(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Augalo su tokiu pavadinimu nera. Bandykit kita paieskos kriteriju.");
        }
    }

    public static void filterByLatinName() {
        System.out.println("Iveskite lotyniska pavadinima arba pavadinimo dali:");
        String input = sc.nextLine().toLowerCase().trim().replaceAll(" +", " ");
        int count = 0;
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).latinName.toLowerCase().contains(input)) {
                System.out.println(plantList.get(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Augalo su tokiu pavadinimu nera. Bandykit kita paieskos kriteriju.");
        }
    }

    public static void filterByContinent() {
        System.out.println("Iveskite kontinento pavadinima arba pavadinimo dali:");
        String input = sc.nextLine().toLowerCase().trim().replaceAll(" +", " ");
        int count = 0;
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).continent.toLowerCase().contains(input)) {
                System.out.println(plantList.get(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Jusu augalas cia ne auga. Bandykit kita paieskos kriteriju.");
        }
    }

    public static void filterByHeight() {
        System.out.println("Iveskite augalo auksti (m):");
        int input = Validated.heightMax(sc);
        int count = 0;
        sc.nextLine();
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).height == input) {
                System.out.println(plantList.get(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Augalo su tokiu auksciu nerarasta. Bandykit kita paieskos kriteriju.");
        }
    }

    public static void filterByAnnual() {
        System.out.println("Iveskite, ar augalas vienmetis (true/false):");
        boolean input = Validated.boolValid(sc);
        int count = 0;
        sc.nextLine();
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).isAnnual == input) {
                System.out.println(plantList.get(i));
                count++;
            }
        }
        System.out.println("Tokiu augalu nerarasta. Bandykit kita paieskos kriteriju.");
    }

    public static void filterByEatable() {
        System.out.println("Iveskite, ar augalas valgomas? (true/false):");
        boolean input = Validated.boolValid(sc);
        int count = 0;
        sc.nextLine();
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).isEatable == input) {
                System.out.println(plantList.get(i));
                count++;
            }
        }
        System.out.println("Tokiu augalu nerarasta. Bandykit kita paieskos kriteriju.");
    }

    public static void addPlant() {
        Plant.plantList.add(createPlant(0));
    }

    public static void editPlant() {
        System.out.println("Iveskite redaguojamo augalo ID:");
        int id = Validated.integer(sc);
        sc.nextLine();
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).id == id) {
                plantList.set(i, createPlant(id));
                return;
            }
        }
        System.out.println("Tokio ID neradome");
    }

    public static void deletePlant() {
        System.out.println("Iveskite trinamo augalo ID: ");
        int id = Validated.integer(sc);
        sc.nextLine();
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).id == id) {
                plantList.remove(i);
                return;
            }
        }
        System.out.println("Tokio ID neradome");
    }

    public static void wrongChoise() {
        System.out.println("Pasirinkite kita varianta");
    }
}