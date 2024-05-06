import java.util.Scanner;

import java.util.ArrayList;
public class Main {
    public static String player = "[X]", status = "fine";
    public static int playerposx = 0, playerposy = 0, playerhp = 2;
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<String> inventory = new ArrayList<String>();
    public static String[][] GameBoard = {{"[ ]", "[ ]", "[ ]", "[ ]", "[C]"},
                                          {"[ ]", "[ ]", "[ ]", "[*]", "[ ]"},
                                          {"[*]", "[ ]", "[ ]", "[ ]", "[ ]"},
                                          {"[ ]", "[*]", "[ ]", "[ ]", "[ ]"},
                                          {"[ ]", "[ ]", "[ ]", "[ ]", "[>]"}};
    static void printBoard() {
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
        inputDialog();

    }
    static void moveDialog() {
        String moveChoice;
        if (playerposy == 0) {
            System.out.println("What direction? \n" +
                    "1. [E]ast \n" +
                    "2. [S]outh \n" +
                    "3. [W]est \n" +
                    "4. [P]revious menu");
            moveChoice = input.nextLine().toLowerCase();
            switch (moveChoice) {

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
                    inputDialog();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialog();
                    break;
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
                    inputDialog();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialog();
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
                    inputDialog();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialog();
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
                    inputDialog();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialog();
                    break;
            }

        } else if (playerposy == 0 && playerposx == 0) {
            System.out.println("What direction? \n" +
                    "1. [E]ast \n" +
                    "2. [S]outh \n" +
                    "3. [P]revious menu");
            moveChoice = input.nextLine().toLowerCase();
            switch (moveChoice) {
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
                    inputDialog();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialog();
                    break;
            }

        } else if (playerposy == 0 && playerposx == 4) {
            System.out.println("What direction? \n" +
                    "1. [S]outh \n" +
                    "2. [W]est \n" +
                    "3. [P]revious menu");
            moveChoice = input.nextLine().toLowerCase();
            switch (moveChoice) {
                case "s":
                    GameBoard [playerposy][playerposx] = "[C]";
                    playerposy = playerposy + 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "w":
                    GameBoard [playerposy][playerposx] = "[C]";
                    playerposx = playerposx - 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "p":
                    inputDialog();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialog();
                    break;
            }

        } else if (playerposy == 4 && playerposx == 0) {
            System.out.println("What direction? \n" +
                    "1. [N]orth \n" +
                    "2. [E]ast \n" +
                    "3. [P]revious menu");
            moveChoice = input.nextLine().toLowerCase();
            switch (moveChoice) {
                case "n":
                    GameBoard [playerposy][playerposx] = "[>]";
                    playerposy = playerposy - 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "e":
                    GameBoard [playerposy][playerposx] = "[>]";
                    playerposx = playerposx + 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "p":
                    inputDialog();
                    break;
            }

        } else if (playerposy ==  4 && playerposx == 4) {
            System.out.println("What direction? \n" +
                    "1. [N]orth \n" +
                    "2. [W]est \n" +
                    "5. [P]revious menu");
            moveChoice = input.nextLine().toLowerCase();
            switch (moveChoice) {
                case "n":
                    GameBoard [playerposy][playerposx] = "[ ]";
                    playerposy = playerposy - 1;
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
                    inputDialog();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialog();
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
                    inputDialog();
                    break;
                default:
                    System.out.println("That is not an option.");
                    inputDialog();
                    break;
            }
        }
        System.out.println();
    }
    static void inputDialog() {
        String moveChoice;
        System.out.println("What would you like to do? \n" +
                           "1. [M]ove \n" +
                           "2. [C]heck Inventory \n" +
                           "3. [S]tats \n" +
                           "4. [I]nspect");
        String menuChoice = input.nextLine().toLowerCase();
        switch(menuChoice) {
            case "m":
                moveDialog();
                inputDialog();
                break;
            case "c":
                System.out.println(inventory);
                inputDialog();
                break;
            case "s":
                System.out.println("HP: " + playerhp + "\n" +
                                   "Status: " + status);
                inputDialog();
                break;
            case "i":
                inputDialog();
                break;
            default:
                System.out.println("That is not an option.");
                inputDialog();
                break;
        } 
                
    }
}
