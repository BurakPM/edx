import java.util.*;

class BattleShips {
    static String[][] oceanMap = new String[10][10];
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    static int userShips = 0;
    static int compShips = 0;


    public static void main(String[] args) {
        System.out.println("**** Welcome to the Battle Ships game ****");
        System.out.println("Right now, the sea is empty.\n");
        displayMap();
        deployPlayerShips();
        deployCompShips();
        gameEngine();

    }
    public static void displayMap() {
        System.out.println("  0123456789");
        for (int row = 0; row < oceanMap.length; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < oceanMap[row].length; col++) {
                if (oceanMap[row][col] == null) {
                    System.out.print(" ");
                } else if (oceanMap[row][col] == "1") {
                    System.out.print("@");
                } else if (oceanMap[row][col] == "2") {
                    System.out.print(" ");
                } else if (oceanMap[row][col] == "+") { // the player and computer do not know each other's missed shots.
                    System.out.print(" ");
                } else {
                    System.out.print(oceanMap[row][col]);
                }

            }
            System.out.println("|" + row);

        }
        System.out.println("  0123456789\n");
    }

    public static void deployPlayerShips() {
        System.out.println("Locate your ships.\n");
        while (userShips < 5) {
            System.out.print("Enter X coordinate for your " + (userShips + 1) + ". ship: "); // for the columns in the map
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + (userShips + 1) + ". ship: "); // for the rows in the map
            int y = input.nextInt();

            if ((x < 10 && y < 10) && (oceanMap[y][x] == null)) {
                oceanMap[y][x] = "1";
                userShips++;
            } else if (x > 9 || y > 9) {
                System.out.println("Cannot place the ships outside the map.");
            } else if (oceanMap[y][x] != null) {
                System.out.println("The coordinate is already used.");
            }
        }
    }

    public static void deployCompShips() {
        while (compShips < 5) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (oceanMap[y][x] == null) {
                oceanMap[y][x] = "2";
                compShips++;
                System.out.println("Enemy ship deployed.");
            }
        }
        System.out.println("\n");

    }

    public static void playerTurn() {
        int turn = 0;

        while (turn == 0) {
            System.out.print("Enter X coordinate of the target: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate of the target: ");
            int y = input.nextInt();
            if (x > 9 || y > 9) {
                System.out.println("Out of range! Coordinates cannot be higher than 9.");
            } else if ((oceanMap[y][x] == "!") || (oceanMap[y][x] == "x") || (oceanMap[y][x] == "-")) {
                System.out.println("The same coordinates cannot be targeted again.");
            } else if (oceanMap[y][x] == "2") {
                System.out.println("Boom! You sunk an enemy ship!");
                oceanMap[y][x] = "!";
                compShips--;
                turn++;
            } else if (oceanMap[y][x] == "1") {
                System.out.println("Oh no, you sunk your own ship :(");
                oceanMap[y][x] = "x";
                userShips--;
                turn++;
            } else {
                System.out.println("You missed!");
                oceanMap[y][x] = "-";
                turn++;
            }
        }
    }

    public static void compTurn() {
        int turn = 0;

        while (turn == 0) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if ((oceanMap[y][x] == "!") || (oceanMap[y][x] == "x") || (oceanMap[y][x] == "+")) { // (+) for computer missed shots;
            } else if (oceanMap[y][x] == "1") {
                System.out.println("The computer sunk one of your ships!");
                oceanMap[y][x] = "x";
                userShips--;
                turn++;
            } else if (oceanMap[y][x] == "2") {
                System.out.println("The computer sank one of its own ships!");
                oceanMap[y][x] = "!";
                compShips--;
                turn++;
            } else {
                System.out.println("The computer missed!");
                oceanMap[y][x] = "+";
                turn++;
            }
        }
    }

    public static void gameEngine() {
        while ((userShips != 0) && (compShips != 0)) {
            playerTurn();
            compTurn();
            displayMap();
            System.out.println("Your ships: " + userShips + " Computer ships: " + compShips + "\n");
                              
        }
        if (userShips == 0) {
            System.out.println("You lost the battle.");
        } else if (compShips == 0) {
            System.out.println("Hooray! You won the battle!");
        }
    }
}
