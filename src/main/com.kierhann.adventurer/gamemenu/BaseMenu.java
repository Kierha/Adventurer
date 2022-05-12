package gamemenu;

import utils.Colors;

import java.util.Scanner;

public class BaseMenu {

    public void displayMenu(){
        OneShotMenu oneShotMenu = new OneShotMenu();
        StepByStepMenu stepByStep = new StepByStepMenu();
        boolean active = true;
        Scanner userInput = new Scanner(System.in);
        String response;

        do {
            System.out.println(Colors.getPurple() + "Simple Adventurer console game");
            System.out.println("Choose a game mode : ");
            System.out.println("1. Step By Step");
            System.out.println("2. One Shot from direct inputs");
            System.out.println("3. One shot from text file inputs" + Colors.getPurple());
            System.out.println(Colors.getRed() + "4. Exit" + Colors.getRed());

            response = userInput.nextLine();

            switch (response) {
                case "1" -> stepByStep.displayStepByStepMenu();
                case "2" -> oneShotMenu.displayOSBasicMenu();
                case "3" -> oneShotMenu.displayOSFromTextFileMenu();
                case "4" -> {
                    System.out.println(Colors.getRed() + "Closing the app..." + Colors.getRed());
                    active = false;
                }
            }
        } while (active);
    }
}
