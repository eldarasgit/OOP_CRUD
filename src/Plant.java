import java.util.ArrayList;
import java.util.Scanner;

public class Plant {
    public static ArrayList<Plant> plantList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static int idCount = 0;

    private final int id;
    private String name;
    private String latinName;
    private boolean isAnnual;
    private String continent;
    private int height;
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

    public boolean getIsAnnual() {
        return this.isAnnual;
    }

    public void setIsAnnual(boolean isAnnual) {
        this.isAnnual = isAnnual;
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
        System.out.println("2. Prideti augala");
        System.out.println("3. Redaguoti augala");
        System.out.println("4. Istrinti augala");
        System.out.println("5. Iseiti is saraso");
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
        pl.setName(sc.nextLine());
        System.out.println("Iveskite lotyniska pavadinima: ");
        pl.setLatinName(sc.nextLine());
        System.out.println("Iveskite augalo paplityma: ");
        pl.setContinent(sc.nextLine());
        System.out.println("Iveskita augalo auksti: ");
        pl.setHeight(sc.nextInt());
        System.out.println("Ar augalas vienmetis?: ");
        pl.setIsAnnual(sc.nextBoolean());
        System.out.println("Ar augalas valgomas? ");
        pl.setIsEatable(sc.nextBoolean());
        sc.nextLine();
        return pl;
    }

    public static void addPlant() {
        Plant.plantList.add(createPlant(0));
    }

    public static void editPlant() {
        System.out.println("Iveskite redaguojamo augalo ID:");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).id == id) {
                plantList.set(i, createPlant(id));
                return;
            }
        }
    }

    public static void deletePlant() {
        System.out.println("Iveskite trinamo augalo ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).id == id) {
                plantList.remove(i);
                return;
            }
        }
    }

    public static void wrongChoise() {
        System.out.println("Pasirinkite kita varianta: ");
    }
}