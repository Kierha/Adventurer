package Controller;

import Services.Adventurer;
import Services.readTextFile;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class GameModeManager {
    char player = '@';
    static Adventurer adventure = new Adventurer();
    static readTextFile textFile = new readTextFile();
    static Scanner input = new Scanner(System.in);


    public void stepByStep(int x, int y, char[][] map) {
        int i = 12;
        do {
            System.out.println("Choose direction to move (N - S - E - O)");
            char playerMovement = input.next().charAt(0);
            switch(playerMovement) {
                case 'N':
                    try {
                        if (adventure.checkColision(map, x, y - 1)) {
                            map[x][y] = ' ';
                            map[x][y-1] = player;
                            y = y - 1;
                        }
                        break;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                case 'S':
                    try {
                        if (adventure.checkColision(map, x, y + 1)) {
                            map[x][y] = ' ';
                            map[x][y+1] = player;
                            y = y + 1;
                        }
                        break;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                case 'E':
                    try {
                        if (adventure.checkColision(map, x + 1, y)) {
                            map[x][y] = ' ';
                            map[x+1][y] = player;
                            x = x + 1;
                            break;
                        }

                        break;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                case 'O':
                    try {
                        if (adventure.checkColision(map, x-1, y)) {
                            map[x][y] = ' ';
                            map[x-1][y] = player;
                            x = x - 1;
                        }
                        break;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
            }
            textFile.printMap(map);
            System.out.println("You have " + (i - 1)  + " moves left !");
            i--;
        } while (i != 0);
    }

    public void oneShot(int x, int y, char[][] map) {
        String str = "OONOOOSSO";


        for (int i = 0; i < str.length(); i++) {
            char playerMovement = str.charAt(i);
            switch(playerMovement) {
                case 'N':
                    try {
                        if (adventure.checkColision(map, x, y - 1)) {
                            map[x][y] = ' ';
                            map[x][y-1] = player;
                            y = y - 1;
                        }
                        break;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                case 'S':
                    try {
                        if (adventure.checkColision(map, x, y + 1)) {
                            map[x][y] = ' ';
                            map[x][y+1] = player;
                            y = y + 1;
                        }
                        break;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                case 'E':
                    try {
                        if (adventure.checkColision(map, x + 1, y)) {
                            map[x][y] = ' ';
                            map[x+1][y] = player;
                            x = x + 1;
                            break;
                        }

                        break;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                case 'O':
                    try {
                        if (adventure.checkColision(map, x-1, y)) {
                            map[x][y] = ' ';
                            map[x-1][y] = player;
                            x = x - 1;
                        }
                        break;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
            }
        }
        textFile.printMap(map);
    }
}
