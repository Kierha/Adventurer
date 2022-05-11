package utils;

public class Colors {
    static String resetColor = "\u001B[0m";
    static String blue = "\u001B[34m";
    static String green = "\u001B[32m";
    static String purple = "\033[1;35m";
    static String yellow = "\033[1;33m";
    static String red = "\u001B[31m";

    public static String getResetColor() {
        return resetColor;
    }

    public static String getBlue() {
        return blue;
    }

    public static String getGreen() {
        return green;
    }

    public static String getPurple() {
        return purple;
    }

    public static String getYellow() {
        return yellow;
    }

    public static String getRed() {
        return red;
    }
}
