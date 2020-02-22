import java.util.Scanner;

public class MazeRunner {

	static Scanner input = new Scanner(System.in);
	static Maze theMap = new Maze();
	static String direction;
	static int moves = 0;

	public static void main(String[] args) {
		intro();
		gameEngine();
	}

	public static void intro() {

		System.out.println("Welcome to the Maze Runner game!");
		System.out.println("Here is your position: ");
		theMap.printMap();
	}

	public static String userMove() {

		System.out.print("Where do you want to go? (R, L, U, D) ");
		String moveTo = input.next().toUpperCase();
		while (!(moveTo.equals("R") || moveTo.equals("L") || moveTo.equals("U") || moveTo.equals("D"))) {
			System.out.println("Invalid direction, try again.");
			moveTo = input.next().toUpperCase();
		}
		return moveTo;
	}

	public static void tryMove(String moveTo) {

		if (moveTo.equals("R") && theMap.canIMoveRight()) {
			theMap.moveRight();
		} else if (moveTo.equals("L") && theMap.canIMoveLeft()) {
			theMap.moveLeft();
		} else if (moveTo.equals("U") && theMap.canIMoveUp()) {
			theMap.moveUp();
		} else if (moveTo.equals("D") && theMap.canIMoveDown()) {
			theMap.moveDown();
		} else if (theMap.isThereAPit(moveTo)) {
			navigatePit(moveTo);
		} else {
			System.out.println("Sorry, you've hit a wall.");
		}
		theMap.printMap();
	}

	public static void movesMessages(int moves) {

		switch (moves) {

		case (50):
			System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
			break;
		case (75):
			System.out.println("	Alert! You have made 75 moves, you only have 25 moves left to escape.");
			break;
		case (90):
			System.out.println("	Alert! You have made 75 moves, you only have 25 moves left to escape.");
			break;
		case (100):
			System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
			break;
		}
	}

	public static void navigatePit(String moveTo) {

		System.out.println("Watch out! There's a pit ahead, jump it? (y/n)");
		String choice = input.next();
		if (choice.startsWith("y")) {
			theMap.jumpOverPit(moveTo);
		}

	}

	public static void gameEngine() {

		while (!(theMap.didIWin())) {
			direction = userMove();
			tryMove(direction);
			moves += 1;
			movesMessages(moves);
			if (moves >= 100) {
				System.out.println("You couldn't escape in 100 moves. GAME OVER.");
				break;
			}
		}
		if (theMap.didIWin()) {
			System.out.println("Congratulations, you made it out alive!	");
			System.out.println("You did in " + moves + " moves.");
		}

	}

}
