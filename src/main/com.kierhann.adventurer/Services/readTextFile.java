package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readTextFile {


    public File chosenTextFile() {
        return new File("src/main/com.kierhann.adventurer/TextFiles/carte.txt");
    }

    public int getDimension(File file) throws FileNotFoundException {
        int linesCounter = 0;
        Scanner scan = new Scanner(file);

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
        int Rows = getDimension(chosenTextFile());
        int Columns = getDimension(chosenTextFile());
        char[][] map = new char[Rows][Columns];
        Scanner sc = new Scanner(chosenTextFile());
        char[] oneLineArray;

        System.out.println("Numbers of Rows : " + Rows);
        System.out.println("Numbers of Columns : " + Columns);

        while (sc.hasNextLine()) {
            for (int i = 0; i < map.length; i++) {
                String[] oneLine = sc.nextLine().split("");
                oneLineArray = toCharArray(oneLine);
                for (int j = 0; j < oneLineArray.length; j++) {
                    map[i][j] = oneLineArray[j];
                }
            }
        }
        return map;
    }

    public void printMap(char[][] map) {
        for (int k = 0; k < map.length; k++) {
            for (int l = 0; l < map.length; l++) {
                System.out.print(map[k][l] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    public void addElement(char[][] map) {
        for (int m = 0; m < map.length; m++) {
            for (int n = 0; n < map.length; n++) {
                if (m == 1 && n == 3) {
                    map[m][n] = 'R';
                }
            }
        }
        printMap(map);
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