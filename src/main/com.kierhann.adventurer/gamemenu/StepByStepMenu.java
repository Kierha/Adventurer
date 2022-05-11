package gamemenu;

import controller.GameManager;
import controller.TextFileManager;
import utils.Colors;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class StepByStepMenu {
    static TextFileManager manageMap = new TextFileManager();
    static GameManager manageGame = new GameManager();
    Scanner xUserInput = new Scanner(System.in);
    Scanner yUserInput = new Scanner(System.in);
    Scanner attempsInput = new Scanner(System.in);
    Scanner pathUserInput = new Scanner(System.in);

    int attempsCount;
    int x;
    int y;
    String path = null;

    public void displayStepByStepMenu(){
        try {
            char[][] map = manageMap.create2dArray();

            System.out.println(Colors.getPurple() + "This is the step by step menu");
            System.out.println("This will be your playground");
            manageMap.printMap(map);
            System.out.println(Colors.getPurple() + "Please enter how many move you will have");
            attempsCount = attempsInput.nextInt();
            System.out.println("Enter your x position : ");
            x = xUserInput.nextInt();
            System.out.println("Enter your y position : " + Colors.getPurple());
            y = yUserInput.nextInt();

            if (manageGame.checkStartingPosition(map, x , y, path)) {
                manageMap.printMap(map);
                for (int i = 0; i < attempsCount; i++){
                    System.out.println(Colors.getPurple() + "Enter your move (N - North - S = South - E = East - O = West) :" + Colors.getPurple());
                    path = pathUserInput.nextLine();
                    manageGame.movementManager(x, y, map, path);
                    if (Objects.equals(path, "N")) {
                        y = y - 1;
                    } else if (Objects.equals(path, "S")) {
                        y = y + 1;
                    } else if (Objects.equals(path, "E")) {
                        x = x + 1;
                    } else if (Objects.equals(path, "O")) {
                        x = x - 1;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(Colors.getRed() + "ERROR, Loading Map text file failed" + Colors.getRed());
            e.printStackTrace();
        }
    }
}
