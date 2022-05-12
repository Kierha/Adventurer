package gamemenu;

import controller.GameManager;
import controller.TextFileManager;
import utils.Colors;

import java.io.File;
import java.util.Scanner;

public class OneShotMenu {
    static final GameManager manageGame = new GameManager();
    static final TextFileManager manageMap = new TextFileManager();
    final Scanner xUserInput = new Scanner(System.in);
    final Scanner yUserInput = new Scanner(System.in);
    final Scanner pathUserInput = new Scanner(System.in);

    int x;
    int y;
    String path = null;

    public void displayOSBasicMenu(){
        char[][] map = manageMap.create2dArray();
        System.out.println(Colors.getPurple() + "This is the One Shot from console inputs mod");
        System.out.println("This will be your playground :" + Colors.getPurple());
        manageMap.printMap(map);
        System.out.println(Colors.getPurple() + "First, we will configure your starting position");
        System.out.println("Enter your x coordinate : ");
        x = xUserInput.nextInt();
        System.out.println("Enter your y coordinate : " + Colors.getPurple());
        y = yUserInput.nextInt();

        if (manageGame.checkStartingPosition(map, x, y, path)) {
            manageMap.printMap(map);
            System.out.println(Colors.getPurple() + "Ok, now please enter your entire movement path (N = North, S = South, E = East, O = West) :" + Colors.getPurple());
            path = pathUserInput.nextLine();
            manageGame.movementManager(x, y, map, path);
        }
    }

    public void displayOSFromTextFileMenu(){
        char[][] map = manageMap.create2dArray();

        System.out.println(Colors.getPurple() + "This is the One Shot from text file mod");
        System.out.println("This will be your playground :" + Colors.getPurple());
        manageMap.printMap(map);
        File textFileData = manageMap.chosenTextFile();
        int[] strCoordToInt = manageMap.getCoordinatesFromTextFile(textFileData);
        int x = strCoordToInt[0];
        int y = strCoordToInt[1];
        path = manageMap.getPathFromTextFile(textFileData);

        if (manageGame.checkStartingPosition(map, x, y, path)){
            System.out.println(Colors.getBlue() + "<-- Starting position -->" + Colors.getBlue());
            manageMap.printMap(map);
            System.out.println(Colors.getBlue() + "<-- RESULT -->" + Colors.getBlue());
            manageGame.movementManager(x, y, map, path);
        }
    }
}
