package controller;

import utils.Colors;

import java.util.Scanner;

public class GameManager {
    static final TextFileManager manageMap = new TextFileManager();
    final Character player = '@';
    final Scanner userInput = new Scanner(System.in);
    final int maxSize = manageMap.getSquareMapDimension();

    public boolean checkStartingPosition(char[][] map, int x, int y, String path) {

            if (x < 0 || x > maxSize || y < 0 || y > maxSize) {
                System.out.println(Colors.getRed() + "This is out of the map !" + Colors.getRed());
                return false;
            }
            if (map[x][y] == '#') {
                System.out.println(Colors.getRed() + "Impossible to drop your adventurer here, there is impenetrable woods" + Colors.getRed());
                reverseStartingCoordinates(x, y, map, path);
                return false;
            }
            startPosition(map, x, y);
            return true;
    }

    public void reverseStartingCoordinates(int x, int y, char[][] map, String path) {
        String response;
        int xReversed = y;
        int yReversed = x;
        Scanner pathUserInput = new Scanner(System.in);

        if (checkStartingPosition(map, xReversed, yReversed, path)) {
            System.out.println(Colors.getGreen() + "Program tried to reverse your coordinates, values x = " + xReversed + " y = " + yReversed + " can drop your adventurer on an empty position, would you like to drop your character here ? (yes/no)" + Colors.getGreen());
            response = userInput.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                startPosition(map, xReversed, yReversed);
                manageMap.printMap(map);
                if (path == null) {
                    System.out.println(Colors.getGreen() + "Ok, now please enter your entire movement path (N = North, S = South, E = East, O = West) :" + Colors.getGreen());
                    path = pathUserInput.nextLine();
                }
                movementManager(xReversed, yReversed, map, path);

            } else {
                System.out.println(Colors.getRed() + "Impossible to drop your adventurer, please verify your coordinates inputs" + Colors.getRed());
            }
        }
    }

    public void startPosition(char[][] map, int x, int y) {
        map[x][y] = player;
    }

    public void movementManager(int x, int y, char[][] map, String path){
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N' || path.charAt(i) == 'S' || path.charAt(i) == 'E' || path.charAt(i) == 'O') {
                char playerMovement = path.charAt(i);
                switch(playerMovement) {
                    case 'N':
                        if (checkColission(map, x, y - 1)) {
                            map[x][y] = ' ';
                            map[x][y-1] = player;
                            y = y - 1;
                        }
                        break;
                    case 'S':
                        if (checkColission(map, x, y + 1)) {
                            map[x][y] = ' ';
                            map[x][y+1] = player;
                            y = y + 1;
                        }
                        break;
                    case 'E':
                        if (checkColission(map, x + 1, y)) {
                            map[x][y] = ' ';
                            map[x+1][y] = player;
                            x = x + 1;
                            break;
                        }

                        break;
                    case 'O':
                        if (checkColission(map, x-1, y)) {
                            map[x][y] = ' ';
                            map[x-1][y] = player;
                            x = x - 1;
                        }
                        break;
                }
            }
            System.out.println(Colors.getRed() + "Only N - S - E - O inputs are making your adventurer move !" + Colors.getRed());
        }
        manageMap.printMap(map);
        System.out.println(Colors.getGreen() + "Last Position : x = " + x + " y = " + y + Colors.getGreen());
        System.out.println(Colors.getYellow() + "--------------------------------------------" + Colors.getYellow());
    }

    public boolean checkColission(char[][] map, int x, int y) {
        if (x < 0 || x > maxSize || y < 0 || y > maxSize) {
            System.out.println(Colors.getRed() + "This is out of the map, you lose one attempt for this fail !" + Colors.getRed());
            return false;
        }
        if (map[x][y] == '#') {
            System.out.println(Colors.getRed() + "There is impenetrable woods, I should try something else" + Colors.getRed());
            return false;
        }
        System.out.println(Colors.getGreen() + "New Adventurer position : x = " + x + " y = " + y + Colors.getGreen());
        return true;
    }
}
