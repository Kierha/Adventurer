package controller;

import utils.Colors;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextFileManager {
    final File mapTextFile = new File("src/main/com.kierhann.adventurer/textfiles/maps/carte.txt");
    private Object Frame;

//    Allow to select file by displaying a Windows window
    public File chosenTextFile() {
        FileDialog dialog = new FileDialog((Frame) null, "Select the file you wanna load...");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        File[] file = dialog.getFiles();
        return file[0];
    }

//    Get the dimension of the map
    public int getSquareMapDimension() {
        int linesCounter = 0;
        try {
            Scanner scan = new Scanner(mapTextFile);

            while (scan.hasNextLine()) {
                scan.nextLine();
                linesCounter++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println(Colors.getRed() + "File not found" + Colors.getRed());
            e.printStackTrace();
        }
        return linesCounter;
    }

//    Create the map into 2D array from the textFile
    public char[][] create2dArray() throws FileNotFoundException {
        int Columns = getSquareMapDimension();
        int Rows = getSquareMapDimension();
        char[][] map = new char[Columns][Rows];
        Scanner sc = new Scanner(mapTextFile);
        char[] oneLineArray;

        while (sc.hasNextLine()) {
            for (int i = 0; i < map.length; i++) {
                String[] oneLine = sc.nextLine().split("");
                oneLineArray = strArrToCharArr(oneLine);
                for (int j = 0; j < oneLineArray.length; j++) {
                    map[j][i] = oneLineArray[j];
                }
            }
        }
        System.out.println(Colors.getGreen() + "Map generated" + Colors.getGreen());
        return map;
    }

//    Display the map
    public void printMap(char[][] map) {
        for (int k = 0; k < map.length; k++) {
            for (int l = 0; l < map.length; l++) {
                System.out.print(Colors.getResetColor() + map[l][k] + " " + Colors.getResetColor());
            }
            System.out.println();
        }
        System.out.println(Colors.getYellow() + "--------------------------------------------" + Colors.getYellow());
    }

//    Allow to convert a String array into a Char Array
    public char[] strArrToCharArr(String[] oneLine) {
        char[] charArray = new char[getSquareMapDimension()];
        int i = 0;

        for (String str : oneLine) {
            for (char c : str.toCharArray()) {
                charArray[i++] = c;
            }
        }
        return charArray;
    }

//    Get the x and y position from the textfile
    public int[] getCoordinatesFromTextFile(File textFilePath) {
        String[] splittedCoordinates = new String[0];
        int[] strCoordToInt = new int[0];

//        String textFilePath = "src/main/com.kierhann.adventurer/textFiles/locations/test.txt";

        try {
            List<String> linesFile = Files.lines(Paths.get(String.valueOf(textFilePath))).collect(Collectors.toList());
            String strCoordinates = linesFile.get(0);
            
            strCoordinates = strCoordinates.replace("\"", "");
            
            if (strCoordinates.length() - 1 < 5) {
                splittedCoordinates = strCoordinates.split(",");
            }

            strCoordToInt = new int[splittedCoordinates.length];

            for (int i = 0; i < splittedCoordinates.length; i++) {
                strCoordToInt[i] = Integer.parseInt(splittedCoordinates[i]);
            }

        } catch (IOException e) {
            System.out.println(Colors.getRed() + "Impossible to find the text file" + Colors.getRed());
            e.printStackTrace();
        }
    return strCoordToInt;
    }

// Get the adventurer path from the textfile
    public String getPathFromTextFile(File textFilePath){

        String path = null;
        try {
//            String textFilePath = "src/main/com.kierhann.adventurer/textFiles/locations/test.txt";

            List<String> linesFile = Files.lines(Paths.get(String.valueOf(textFilePath))).collect(Collectors.toList());
            path = linesFile.get(1);

        } catch (IOException e) {
            System.out.println(Colors.getRed() + "ERROR, impossible to load this text file" + Colors.getRed());
            e.printStackTrace();
        }
        return path;
    }
}