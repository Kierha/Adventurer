import Services.*;

import java.io.FileNotFoundException;

public class Main {
    static readTextFile readFile = new readTextFile();
    static Adventurer adventure = new Adventurer();


    public static void main(String[] args) throws FileNotFoundException {
        char[][] map = readFile.create2dArray();
//        readFile.addElement(map);

        adventure.startPosition(map);
        adventure.adventurerMovement(map);
        readFile.printMap(map);
    }
}
