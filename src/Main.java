import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Plant p1 = new Plant();
        p1.setName("Eucalypt");
        p1.setLatinName("Eucalyptus");
        p1.setIsAnnual(false);
        p1.setContinent("Australia");
        p1.setHeight(60);
        p1.setIsEatable(false);

        Plant p2 = new Plant();
        p2.setName("Sunflower");
        p2.setLatinName("Helianthus annuus");
        p2.setIsAnnual(true);
        p2.setContinent("North America, Eurasia");
        p2.setHeight(5);
        p2.setIsEatable(true);

        Plant.plantList.add(p1);
        Plant.plantList.add(p2);

        while (true) {
            Plant.info();
            int input = Validated.integer(sc);

            switch (input) {
                case 1:
                    Plant.printPlants();
                    break;
                case 2:
                    Plant.filterPlants();
                    break;
                case 3:
                    Plant.addPlant();
                    break;
                case 4:
                    Plant.editPlant();
                    break;
                case 5:
                    Plant.deletePlant();
                    break;
                case 6:
                    System.exit(0);
                default:
                    Plant.wrongChoise();
                    break;
            }
        }
    }
}












