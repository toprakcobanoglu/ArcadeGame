package java102.arcadeGame;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class Game {
    public void Start() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Temple ! ");
        System.out.println("Please enter your name: ");
        String playerName = scan.next();

        Player player = new Player(playerName);
        System.out.println(player.getName()+", welcome to dark side of temple!");
        System.out.println("Please select a character.");
        player.selectChar();

        Location location = null;

        while (true)    {
            player.printInfo();
            System.out.println();
            System.out.println("Please select a location.");
            System.out.println();
            System.out.println("LOCATIONS");
            System.out.println("- - - - - - - - - - - -");
            System.out.println("1- Safe House");
            System.out.println("2- Store");
            System.out.println("3- DEEP FOREST \t Award --> Food");
            System.out.println("4- BLOODY RIVER \t Award --> Firewood");
            System.out.println(("5- SKULL CAVE \t Award --> Water"));
            System.out.println("0- Exit");
            int selectLoc = scan.nextInt();

            switch (selectLoc)  {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Store(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new Cave(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location == null)  {
                System.out.println("");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }
        }

    }
}
