package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readTextFile {

    public File chosenTextFile() {
        return new File("src/main/com.kierhann.adventurer/TextFiles/carte.txt");
    }

    public int getDimension() throws FileNotFoundException {
        int linesCounter = 0;
        Scanner scan = new Scanner(chosenTextFile());

        try {
            while (scan.hasNextLine()) {
                scan.nextLine();
                linesCounter++;
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return linesCounter;
    }

    public char[][] create2dArray() throws FileNotFoundException {
        int Columns = getDimension();
        int Rows = getDimension();
        char[][] map = new char[Columns][Rows];
        Scanner sc = new Scanner(chosenTextFile());
        char[] oneLineArray;

        System.out.println("Numbers of Rows : " + Rows);
        System.out.println("Numbers of Columns : " + Columns);

        while (sc.hasNextLine()) {
            for (int i = 0; i < map.length; i++) {
                String[] oneLine = sc.nextLine().split("");
                oneLineArray = toCharArray(oneLine);
                for (int j = 0; j < oneLineArray.length; j++) {
                    map[j][i] = oneLineArray[j];
                }
            }
        }
        return map;
    }

    public void printMap(char[][] map) {
        for (int k = 0; k < map.length; k++) {
            for (int l = 0; l < map.length; l++) {
                System.out.print(map[l][k] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    public char[] toCharArray(String[] oneLine) {
        char[] charArray = new char[20];
        int i = 0;

        for (String str : oneLine) {
            for (char c : str.toCharArray()) {
                charArray[i++] = c;
            }
        }
        return charArray;
    }
}