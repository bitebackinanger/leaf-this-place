import java.util.Scanner;

import java.util.ArrayList;
public class Main {
    public static String player = "[x]";
    public static String[][] GameBoard = {{"[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}};
    static void printBoard() {
        int y = 0, x =0;

        for (; y < 5; y++) {
            for (; x < 5; x++) {
                System.out.print(GameBoard[y][x]);
            }
            if (x == 5) {
                x = 0;
            }
            System.out.println();

        }
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

        Scanner input = new Scanner(System.in);


        GameBoard[0][0] = player;
        int charCount = 1;
        System.out.println("Would you like to name your character? The default is Lost" + charCount + " (y/n)");
        String nickBool = input.nextLine().toLowerCase();
        ArrayList<String> charNameArrList = new ArrayList<String>();
        switch(nickBool) {
            case "y":
                System.out.println("What's your name?");
                charNameArrList.add(input.nextLine());
                System.out.println("Nice to meet you, " + charNameArrList.get(0) + ". :)");
            case "n":
                charNameArrList.add("Lost" + charCount);
        }
        System.out.println("\n");
        printBoard();

    }
}