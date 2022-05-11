import Controller.GameModeManager;
import Services.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static readTextFile readFile = new readTextFile();
    static Adventurer adventure = new Adventurer();
    static GameModeManager manage = new GameModeManager();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        int xPosition = 9;
        int yPosition = 6;

        char[][] map = readFile.create2dArray();
        adventure.startPosition(map, xPosition, yPosition);
        manage.oneShot(xPosition, yPosition, map);
//        System.out.println("This will be your playground, your character will be represented by @ on the map");
//        readFile.printMap(map);
//        System.out.println("Enter your x position where to start :");
//        int xPosition = input.nextInt();
//        System.out.println("Enter your y position where to start :");
//        int yPosition = input.nextInt();
//        adventure.startPosition(map, xPosition, yPosition);
//        manage.stepByStep(xPosition, yPosition, map);

        }
    }

