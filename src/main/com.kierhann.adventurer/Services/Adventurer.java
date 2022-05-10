package Services;

import java.io.FileNotFoundException;

public class Adventurer {
    int x = 1;
    int y = 3;
    char chosenChar = 'A';
    static readTextFile textFile = new readTextFile();

    int max;
    {
        try {
            max = textFile.getDimension();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void startPosition(char[][] map) {

        if (map[x][y] == '#') {
            System.out.println("Impossible to drop your adventurer here, there is impenetrable woods");
            textFile.printMap(map);
        } else if (x > max || y > max) {
            System.out.println("Impossible to drop your adventurer here, it's out of map !");
        } else {
            map[x][y] = chosenChar;
            textFile.printMap(map);
        }
    }

    public void adventurerMovement(char[][] map) {
        char input = 'S';

        switch(input) {

            case 'N':
                try {
                    if (checkColision(map, x+1, y)) {
                        map[x][y] = ' ';
                        map[x+1][y] = 'A';
                        break;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            case 'S':
                try {
                    if (checkColision(map, x-1, y)) {
                        map[x][y] = ' ';
                        map[x-1][y] = 'A';
                        break;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            case 'E':
                try {
                    if (checkColision(map, x, y+1)) {
                        map[x][y] = ' ';
                        map[x][y] = 'A';
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            case 'O':
                try {
                    if (checkColision(map, x, y-1)) {
                        map[x][y] = ' ';
                        map[x][y] = 'A';
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
        }
    }

    public boolean checkColision(char[][] map, int x, int y) throws FileNotFoundException {


        if (x > max || y > max) {
            System.out.println("Wait... Where are you going ? This is out of the map");
            return false;
        }
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
