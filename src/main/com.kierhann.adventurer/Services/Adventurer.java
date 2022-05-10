package Services;

import Controller.GameModeManager;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Adventurer {
    public static readTextFile textFile;
    char player = '@';
    int max;
    {
        try {
            max = textFile.getDimension();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void startPosition(char[][] map, int x, int y) {

        if (map[x][y] == '#') {
            System.out.println("Impossible to drop your adventurer here, there is impenetrable woods");
            textFile.printMap(map);
        } else if (x > max || y > max) {
            System.out.println("Impossible to drop your adventurer here, it's out of map !");
        } else {
            map[x][y] = player;
            textFile.printMap(map);
        }
    }

    public boolean checkColision(char[][] map, int x, int y) throws FileNotFoundException {
        GameModeManager manage = new GameModeManager();

        if (map[x][y] == '#') {
            System.out.println("There is impenetrable woods, I should try something else");
            return false;
        }
        System.out.println("New Adventurer position :");
        System.out.println("x : " + x);
        System.out.println("y : " + y);
        return true;
    }
}
