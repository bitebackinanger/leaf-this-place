//imports Scanner and ArrayList
import java.util.Scanner;

import java.util.ArrayList;

public class Main {
    //Declare global variables
    public static String player = "[X]", status = "fine";
    public static String charName;
    public static boolean hasSword = false, treeCutDown = false, bearDead = false, npcvisited = false, rabfootacquired = false;
    public static int playerposx = 0, playerposy = 0, playerhp = 2;
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<String> inventory = new ArrayList<>();
    public static String[][] GameBoard = {{"[X]", "[ ]", "[ ]", "[ ]", "[C]"},
            {"[ ]", "[ ]", "[ ]", "[*]", "[ ]"},
            {"[*]", "[ ]", "[ ]", "[ ]", "[~]"},
            {"[ ]", "[ ]", "[T]", "[~]", "[ ]"},
            {"[*]", "[ ]", "[~]", "[ ]", "[W]"}};

    //Method to reprint Game Board after all actions and Movements
    public static void printBoard() {
        int y = 0, x = 0;
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
        inputDialogue();
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


        //Introductory text
        int charCount = 1;
        System.out.println("Would you like to name your character? The default is Lost (y/n)");
        String nickBool = input.nextLine().toLowerCase();

        switch (nickBool) {
            case "y":
                System.out.println("What's your name?");
                charName = input.nextLine();
                System.out.println("Nice to meet you, " + charName + ". :)");
                break;
            case "n":
                charName = "Lost";
                break;
        }

        System.out.println("\n");
        System.out.println();
        System.out.println("This game revolves around choosing from menus. to select what action you would like to take;\n" +
                "you can a) enter the number corresponding to their place on the list of choices or b) enter\n" +
                "the letter highlighted in square brackets. For example, if you were presented with the list:\n" +
                "1. [R]un\n" +
                "2. [H]ide\n" +
                "3. [A]ttack\n" +
                "4. [F]reeze\n" +
                "You could enter '1' or 'r' to run. May your escape be sift and painless, " + charName + ".");
        System.out.println();
        printBoard();

    }

    public static void moveDialogue() {
        String moveChoice;
        if (playerposy == 0) {
            if (playerposx == 0) {
                System.out.println("You were just strolling around and took one wrong detour, a thick fog surrounds \n " +
                        "the entire forest, almost as if it’s enchanted… With the path you took suddenly \n" +
                        "blocked off, you look for an exit.\n");
                System.out.println("What direction? \n" +
                        "1. [E]ast \n" +
                        "2. [S]outh \n" +
                        "3. [W]est \n" +
                        "4. [P]revious menu");

                moveChoice = input.nextLine().toLowerCase();
                switch (moveChoice) {
                    case "e":
                    case "1":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposx = playerposx + 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "s":
                    case "2":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposy = playerposy + 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "p":
                    case "3":
                        inputDialogue();
                        break;
                    case "n":
                    case "4":
                    case "5":
                    case "w":
                        System.out.println("You take a step but feel no soil beneath your sole as darkness envelops you. You look back and only see a square grid.\n" +
                                "Your vision fades to black before you wake up in the same spot you fell from.");
                    default:
                        System.out.println("That is not an option.");
                        inputDialogue();
                        break;

                }
            } else {
                System.out.println("What direction? \n" +
                        "1. [E]ast \n" +
                        "2. [S]outh \n" +
                        "3. [W]est \n" +
                        "4. [P]revious menu");

                moveChoice = input.nextLine().toLowerCase();
                switch (moveChoice) {
                    case "e":
                    case "1":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposx = playerposx + 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "s":
                    case "2":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposy = playerposy + 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "w":
                    case "3":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposx = playerposx - 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "p":
                    case "4":
                        inputDialogue();
                        break;
                    default:
                        System.out.println("That is not an option.");
                        inputDialogue();
                        break;
                }
            }
        } else if (playerposx == 0 && playerposy > 0) {
            System.out.println("What direction? \n" +
                    "1. [N]orth\n" +
                    "2. [E]ast\n" +
                    "3. [S]outh\n" +
                    "4. [P]revious menu");
            moveChoice = input.nextLine().toLowerCase();
            switch (moveChoice) {
                case "n":
                case "1":
                    GameBoard[playerposy][playerposx] = "[ ]";
                    playerposy--;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "e":
                case "2":
                    GameBoard[playerposy][playerposx] = "[ ]";
                    playerposx = playerposx + 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "s":
                case "3":
                    GameBoard[playerposy][playerposx] = "[ ]";
                    playerposy = playerposy + 1;
                    GameBoard[playerposy][playerposx] = player;
                    printBoard();
                    break;
                case "p":
                case "4":
                    inputDialogue();
                    break;
            }
        } else if (playerposy == 4) {

            if (playerposx == 4) {
                System.out.println("What direction? \n" +
                        "1. [N]orth \n" +
                        "3. [S]outh \n" +
                        "4. [W]est \n" +
                        "5. [P]revious menu");
                moveChoice = input.nextLine().toLowerCase();
                switch (moveChoice) {
                    case "n":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposy = playerposy - 1;
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
                    case "1":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposy = playerposy - 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "e":
                    case "2":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposx = playerposx + 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "s":
                    case "3":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposy = playerposy + 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "w":
                    case "4":
                        GameBoard[playerposy][playerposx] = "[ ]";
                        playerposx = playerposx - 1;
                        GameBoard[playerposy][playerposx] = player;
                        printBoard();
                        break;
                    case "p":
                    case "5":
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


        public static void swordDialogue () {
            String moveChoice;
            System.out.println("You encounter a chest that’s contents are glowing.\n" +
                    "Open it?\n" +
                    "1. [Y]es\n" +
                    "2. [N]o");
            String chestChoice = input.nextLine().toLowerCase();
            switch (chestChoice) {
                case "y":
                case "1":
                    System.out.println("It is too dangerous to go alone, take this! You have obtained a sword!\n" +
                            "*[SWORD] ADDED TO INVENTORY");
                    inventory.add("[SWORD]\n" +
                            "A shortsword with a well honed edge. Good for skinning and cutting.");
                    hasSword = true;
                    System.out.println("What direction?\n" +
                            "1. [N]orth\n" +
                            "2. [E]ast\n");
                    String menuChoice = input.nextLine().toLowerCase();
                    switch (menuChoice) {
                        case "n":
                        case "1":
                            GameBoard[playerposy][playerposx] = "[ ]";
                            playerposy = playerposy - 1;
                            GameBoard[playerposy][playerposx] = player;
                            printBoard();
                            break;
                        case "e":
                        case "2":
                            GameBoard[playerposy][playerposx] = "[ ]";
                            playerposx = playerposx + 1;
                            GameBoard[playerposy][playerposx] = player;
                            printBoard();
                            break;
                        default:
                            System.out.println("That is not an option");
                            swordDialogue();
                    }
                    break;
                case "n":
                case "2":
                    System.out.println("You abandon your only hope of escape");
                    System.out.println("What direction? \n" +
                            "1. [N]orth \n" +
                            "2. [S]outh \n" +
                            "3. [W]est \n" +
                            "4. [P]revious menu");
                    moveChoice = input.nextLine().toLowerCase();
                    switch (moveChoice) {
                        case "n":
                        case "1":
                            GameBoard[playerposy][playerposx] = "[S]";
                            playerposy = playerposy - 1;
                            GameBoard[playerposy][playerposx] = player;
                            printBoard();
                            break;
                        case "e":
                        case "2":
                            GameBoard[playerposy][playerposx] = "[S]";
                            playerposx = playerposx + 1;
                            GameBoard[playerposy][playerposx] = player;
                            printBoard();
                            break;
                        case "s":
                        case "3":
                            GameBoard[playerposy][playerposx] = "[S]";
                            playerposy = playerposy + 1;
                            GameBoard[playerposy][playerposx] = player;
                            printBoard();
                            break;
                        case "p":
                        case "4":
                            inputDialogue();
                            break;
                        default:
                            System.out.println("That is not an option.");
                            inputDialogue();
                            break;

                    }
            }
        }

        public static void npcDialogue () {
            String dialogueChoice, moveChoice;
            System.out.println("In the distance, you see a cottage with smoke coming from the top, as you enter, you find an old man in a rocking chair.\n" +
                    "You approach him.");
            System.out.println("Hello there, how did you manage to get stuck in this place? \n" +
                    "1. [W]ho are you?\n" +
                    "2. [G]oodbye");
            dialogueChoice = input.nextLine().toLowerCase();
            switch (dialogueChoice) {
                case "1":
                case "w":
                    System.out.println("I am an old hermit, withdrawn from society living here. Even if I wanted to, I am much too old to leave this place.\n" +
                            "1. [W]hat do you mean, if you wanted to?\n" +
                            "2. [N]evermind");
                    dialogueChoice = input.nextLine().toLowerCase();
                    switch (dialogueChoice) {
                        case "1":
                        case "w":
                            System.out.println("There is an evil witch blocking the only exit to this forest, she has set up a barrier around the forest\n" +
                                    "luring unsuspecting victims so she can test on them.\n" +
                                    "1. [H]ow do I leave this forest?\n" +
                                    "2. [N]evermind");
                            dialogueChoice = input.nextLine().toLowerCase();
                            switch (dialogueChoice) {
                                case "1":
                                case "h":
                                    System.out.println("I suppose if you wanted to leave this forest, you could present two items to leave the forest,\n" +
                                            "but I’m much too old to obtain them\n" +
                                            "1. [W]hat are they?\n" +
                                            "2. [N]evermind");
                                    dialogueChoice = input.nextLine().toLowerCase();
                                    switch (dialogueChoice) {
                                        case "1":
                                        case "w":
                                            System.out.println("A Bear Hide and a Rabbits’ foot, though you’d have to be insane to go out of your way to find them.\n" +
                                                    "I see you have a map, let me show you where they are and the sword you can use to gather them is.\n" +
                                                    "*ITEM LOCATIONS MARKED ON MAP\n" +
                                                    "1. [G]oodbye");
                                            GameBoard[1][3] = "[R]";
                                            GameBoard[2][0] = "[B]";
                                            GameBoard[4][0] = "[S]";
                                            dialogueChoice = input.nextLine().toLowerCase();
                                            switch (dialogueChoice) {
                                                case "1":
                                                case "g":
                                                    System.out.println("What direction? \n" +
                                                            "1. [S]outh \n" +
                                                            "2. [W]est \n" +
                                                            "3. [P]revious menu");
                                                    dialogueChoice = input.nextLine().toLowerCase();
                                                    switch (dialogueChoice) {
                                                        case "s":
                                                        case "1":
                                                            GameBoard[playerposy][playerposx] = "[C]";
                                                            playerposy = playerposy + 1;
                                                            GameBoard[playerposy][playerposx] = player;
                                                            printBoard();
                                                            break;
                                                        case "w":
                                                        case "2":
                                                            GameBoard[playerposy][playerposx] = "[C]";
                                                            playerposx = playerposx - 1;
                                                            GameBoard[playerposy][playerposx] = player;
                                                            printBoard();
                                                            break;
                                                        case "p":
                                                        case "3":
                                                            inputDialogue();
                                                            break;
                                                        default:
                                                            System.out.println("That is not an option.");
                                                            inputDialogue();
                                                            break;
                                                    }
                                            }
                                        case "2":
                                        case "n":
                                            npcDialogue();
                                            break;
                                    }
                            }
                        case "2":
                        case "n":
                            npcDialogue();
                            break;
                    }
                    break;

                case "2":
                case "g":
                    moveChoice = input.nextLine().toLowerCase();
                    switch (moveChoice) {
                        case "1":
                        case "g":
                            System.out.println("What direction? \n" +
                                    "1. [S]outh \n" +
                                    "2. [W]est \n" +
                                    "3. [P]revious menu");
                            moveChoice = input.nextLine().toLowerCase();
                            switch (moveChoice) {
                                case "s":
                                case "1":
                                    GameBoard[playerposy][playerposx] = "[C]";
                                    playerposy = playerposy + 1;
                                    GameBoard[playerposy][playerposx] = player;
                                    printBoard();
                                    break;
                                case "w":
                                case "2":
                                    GameBoard[playerposy][playerposx] = "[C]";
                                    playerposx = playerposx - 1;
                                    GameBoard[playerposy][playerposx] = player;
                                    printBoard();
                                    break;
                                case "p":
                                case "3":
                                    inputDialogue();
                                    break;
                                default:
                                    System.out.println("That is not an option.");
                                    inputDialogue();
                                    break;
                            }
                    }
                    break;
            }
        }
public static void bearDialogue() {
        if (hasSword == true) {
            System.out.println("A wild bear approaches you! However, you came prepared. You sliced and diced through the bear. You obtained the Bear Hide!\n" +
                    "*[BEAR HIDE] ADDED TO INVENTORY");
            inventory.add("[BEAR HIDE]");
            status = "optimistic";
            moveDialogue();
        } else if (hasSword == false && playerhp == 2) {
            System.out.println("A wild bear approached you! The apex predator of the forest, With no item to defend yourself, you scramble to escape its grasp.\n" +
                    " Barely escaping with your life, you lose the bear and move on… ONE LIFE LEFT!");
            playerhp = playerhp - 1;
            status = "badly hurt";
            moveDialogue();
        } else if (hasSword == false && playerhp == 1) {
            System.out.println("A wild bear approached you! The apex predator of the forest… With no item to defend yourself, you’re helplessly sliced and diced by its claws… YOU DIED!");
            System.exit(0);
        }
}
public static void rabbitCaveDialogue() {

        System.out.println("As you cross the river, you notice a rabbit in its cave sleeping. This could be your chance… Kill the rabbit?\n" +
                "1. [Y]es\n" +
                "2. [N]o");
        String choice = input.nextLine().toLowerCase();
        switch (choice) {
            case "y":
            case "1":
                System.out.println("You quietly approach the rabbit, slaying it in its sleep. You have acquired a Rabbit’s Foot! You exit the Rabbit Cave.");

                rabfootacquired = true;
                moveDialogue();
            case "n":
            case "2":
                System.out.println("It’s too cute to kill… you leave it for now…");
                rabbitCaveDialogue();
        }

}
public static void treeDialogue() {

        if (hasSword == true) {
            System.out.println("An old tree on its last legs… It looks like you can hack it down with a sword, cut it down?\n" +
                    "1. [Y]es\n" +
                    "2. [N]o");
            String choice = input.nextLine().toLowerCase();
            switch (choice){
                case "y":
                case "1":
                    System.out.println("You slash down the tree, and it falls over the river bed, making it safe for you to cross.");
                    GameBoard[3][3] = "[=]";
                    treeCutDown = true;
                    moveDialogue();
                case "n":
                case "2":
                    System.out.println("You decide not to cut down the tree.");
                    treeDialogue();
            }
        }
}
public static void riverDialogue() {
        System.out.println("You see a clearing in the forest, an escape? No, a river… Cross it?\n" +
                "1. [Y]es\n" +
                "2. [N]o");
        String choice = input.nextLine().toLowerCase();
        switch (choice){
            case "y":
            case "1":
                if (playerhp == 2) {
                    System.out.println("You are quickly pulled down by the stream’s powerful current! Struggling to resist its flow you\n" +
                            " manage to grab onto a surfaced rock and drag yourself to shore, however, you’re winded and exhausted… ONE LIFE LEFT!");
                    GameBoard[playerposy][playerposx] = "[~]";
                    playerhp = playerhp - 1;
                    playerposx = 1; playerposy = 4;
                } else if (playerhp == 1) {
                    System.out.println("You are quickly pulled down by the stream's powerful current, too weak to push against it, you quickly succumb to the will of the water… YOU DIED!");
                    System.exit(0);
                }
        }
}
public static void witchDialogue() {
        if (rabfootacquired == true && bearDead == true) {
            System.out.println("You presented your items to the witch, her face lights up with a wicked grin. Moments after, she disappears in a quick flash, and the barrier evaporates. YOU WIN!");
            System.exit(0);
        } else {
            System.out.println("You lack the items required to pass. The witch looks at you with discontent, and smites you down! GAME OVER!");
            System.exit(0);
        }
}
        public static void inputDialogue () {
            if (playerposy == 0 && playerposx == 4 && npcvisited == false) {
                npcDialogue();
            } else if (playerposy == 4 && playerposx == 0 && hasSword == false) {
                swordDialogue();
            } else if (playerposy == 2 && playerposx == 0 && bearDead == false) {
                bearDialogue();
            } else if (playerposx == 2 && playerposy == 3 && treeCutDown == false) {
                treeDialogue();
            } else if (playerposy == 1 && playerposx == 3 && rabfootacquired == false) {
                rabbitCaveDialogue();
            } else {
                System.out.println("What would you like to do? \n" +
                        "1. [M]ove \n" +
                        "2. [C]heck Inventory \n" +
                        "3. [S]tats \n" +
                        "4. [I]nspect");
                String menuChoice = input.nextLine().toLowerCase();
                switch (menuChoice) {
                    case "m":
                    case "1":
                        moveDialogue();
                        break;
                    case "c":
                    case "2":
                        System.out.println(inventory);
                        inputDialogue();
                        break;
                    case "s":
                    case "3":
                        System.out.println("HP: " + playerhp + "\n" +
                                "Status: " + status);
                        inputDialogue();
                        break;
                    default:
                        System.out.println("That is not an option.");
                        inputDialogue();
                        break;
                }
            }

        }

    }



