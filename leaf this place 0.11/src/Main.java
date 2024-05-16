//imports Scanner and ArrayList
import java.util.Scanner;

import java.util.ArrayList;

public class Main {
    //Declare global variables
    public static String player = "[X]", status = "fine";
    public static int playerposx = 0, playerposy = 0, playerhp = 2;
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<String> inventory = new ArrayList<String>();
    public static String[][] GameBoard = {{"[ ]", "[ ]", "[ ]", "[ ]", "[C]"},
                                          {"[ ]", "[ ]", "[ ]", "[*]", "[ ]"},
                                          {"[*]", "[ ]", "[ ]", "[ ]", "[~]"},
                                          {"[ ]", "[*]", "[ ]", "[~]", "[ ]"},
                                          {"[ ]", "[ ]", "[~]", "[ ]", "[W]"}};
    //Method to reprint Game Board after all actions and Movements
    public void printBoard() {
        int y = 0, x =0;
        GameBoard[playerposy][playerposx] = player;
        for (; y < 5; y++) {
            for (; x < 5; x++) {
                System.out.print(GameBoard[y][x]);
            }
            if (x == 5) {
                x = 0;
            }
            System.out.println();

        }
        y = 0;
        x = 0;
    }

    //Title Screen
    public static void main(String[] args) {

        System.out.println(" ██▓    ▓█████ ▄▄▄        █████▒   ▄▄▄█████▓ ██░ ██  ██▓  ██████     ██▓███   ██▓    ▄▄▄       ▄████▄  ▓█████ \n" +
                           "▓██▒    ▓█   ▀▒████▄    ▓██   ▒    ▓  ██▒ ▓▒▓██░ ██▒▓██▒▒██    ▒    ▓██░  ██▒▓██▒   ▒████▄    ▒██▀ ▀█  ▓█   ▀ \n" +
                           "▒██░    ▒███  ▒██  ▀█▄  ▒████ ░    ▒ ▓██░ ▒░▒██▀▀██░▒██▒░ ▓██▄      ▓██░ ██▓▒▒██░   ▒██  ▀█▄  ▒▓█    ▄ ▒███   \n" +
                           "▒██░    ▒▓█  ▄░██▄▄▄▄██ ░▓█▒  ░    ░ ▓██▓ ░ ░▓█ ░██ ░██░  ▒   ██▒   ▒██▄█▓▒ ▒▒██░   ░██▄▄▄▄██ ▒▓▓▄ ▄██▒▒▓█  ▄ \n" +
                           "░██████▒░▒████▒▓█   ▓██▒░▒█░         ▒██▒ ░ ░▓█▒░██▓░██░▒██████▒▒   ▒██▒ ░  ░░██████▒▓█   ▓██▒▒ ▓███▀ ░░▒████▒\n" +
                           "░ ▒░▓  ░░░ ▒░ ░▒▒   ▓▒█░ ▒ ░         ▒ ░░    ▒ ░░▒░▒░▓  ▒ ▒▓▒ ▒ ░   ▒▓▒░ ░  ░░ ▒░▓  ░▒▒   ▓▒█░░ ░▒ ▒  ░░░ ▒░ ░\n" +
                           "░ ░ ▒  ░ ░ ░  ░ ▒   ▒▒ ░ ░             ░     ▒ ░▒░ ░ ▒ ░░ ░▒  ░ ░   ░▒ ░     ░ ░ ▒  ░ ▒   ▒▒ ░  ░  ▒    ░ ░  ░\n" +
                           "  ░ ░      ░    ░   ▒    ░ ░         ░       ░  ░░ ░ ▒ ░░  ░  ░     ░░         ░ ░    ░   ▒   ░           ░   \n" +
                           "    ░  ░   ░  ░     ░  ░                     ░  ░  ░ ░        ░                  ░  ░     ░  ░░ ░         ░  ░\n" +
                           "                                                                                              ░               \n" +
                           "\n");



        System.out.println("You were just strolling around and took one wrong detour, a thick fog surrounds \n " +
                           "the entire forest, almost as if it’s enchanted… With the path you took suddenly \n" +
                           "blocked off, you look for an exit.\n");
        //Introductory text
        int charCount = 1;
        System.out.println("Would you like to name your character? The default is Lost (y/n)");
        String nickBool = input.nextLine().toLowerCase();
        String charName;
        switch(nickBool) {
            case "y":
                System.out.println("What's your name?");
                charName = input.nextLine();
                System.out.println("Nice to meet you, " + charName + ". :)");
            case "n":
                charName = "Lost";
        }
        System.out.println("\n");
        printBoard();
        System.out.println();
        System.out.println();
        inputDialogue();

    }
    public void moveDialogue() {
        String moveChoice;
        if (playerposy == 0) {
            if (playerposx == 0) {
                //initial wake up text goes here
            } else-if (playerposx == 4) {
                //cottage Dialogueue and npc d
            }else {
                System.out.println("What direction? \n" +
                        "1. [E]ast \n" +
                        "2. [S]outh \n" +
                        "3. [W]est \n" +
                        "4. [P]revious menu");

                moveChoice = input.nextLine().toLowerCase();
                switch (moveChoice) {
                    case "e":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposx = playerposx + 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "s":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposy = playerposy + 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "w":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposx = playerposx - 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "p":
                        inputDialogue();
                        break;
                    default:
                        System.out.println("That is not an option.");
                        inputDialogue();
                        break;
                }
            }
            }

        } else if (playerposy == 4) {
            System.out.println("What direction? \n" +
                    "1. [N]orth \n" +
                    "2. [E]ast \n" +
                    "3. [W]est \n" +
                    "4. [P]revious menu");
            moveChoice = input.nextLine().toLowerCase();
            switch (moveChoice) {
                case "n":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposy = playerposy - 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "e":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposx = playerposx + 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;

                case "w":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposx = playerposx - 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "p":
                    inputDialogue();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialogue();
                    break;
            }

        } else if (playerposx == 0) {
            System.out.println("What direction? \n" +
                    "1. [N]orth \n" +
                    "2. [E]ast \n" +
                    "3. [S]outh \n" +
                    "4. [P]revious menu");
            moveChoice = input.nextLine().toLowerCase();
            switch (moveChoice) {
                case "n":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposy = playerposy - 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "e":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposx = playerposx + 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "s":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposy = playerposy + 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "p":
                    inputDialogue();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialogue();
                    break;
            }

        } else if (playerposx == 4) {
            System.out.println("What direction? \n" +
                    "1. [N]orth \n" +
                    "3. [S]outh \n" +
                    "4. [W]est \n" +
                    "5. [P]revious menu");
            moveChoice = input.nextLine().toLowerCase();
            switch (moveChoice) {
                case "n":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposy = playerposy - 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "s":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposy = playerposy + 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "w":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposx = playerposx - 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "p":
                    inputDialogue();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialogue();
                    break;
            }

        } else {
            System.out.println("What direction? \n" +
                    "1. [N]orth \n" +
                    "2. [E]ast \n" +
                    "3. [S]outh \n" +
                    "4. [W]est \n" +
                    "5. [P]revious menu");
            moveChoice = input.nextLine().toLowerCase();
            switch (moveChoice) {
                case "n":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposy = playerposy - 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "e":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposx = playerposx + 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "s":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposy = playerposy + 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "w":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposx = playerposx - 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "p":
                    inputDialogue();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialogue();
                    break;
            }
        }
        System.out.println();
    }
    static void inputDialogue() {
        String moveChoice;
        System.out.println("What would you like to do? \n" +
                           "1. [M]ove \n" +
                           "2. [C]heck Inventory \n" +
                           "3. [S]tats \n" +
                           "4. [I]nspect");
        String menuChoice = input.nextLine().toLowerCase();
        switch(menuChoice) {
            case "m":
                moveDialogue();
                inputDialogue();
                break;
            case "c":
                System.out.println(inventory);
                inputDialogue();
                break;
            case "s":
                System.out.println("HP: " + playerhp + "\n" +
                                   "Status: " + status);
                inputDialogue();
                break;
            case "i":
                inputDialogue();
                break;
            default:
                System.out.println("That is not an option.");
                inputDialogue();
                break;
        } 
                
    }
}
