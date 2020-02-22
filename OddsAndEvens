import java.util.Random;
import java.util.Scanner;

public class OddAndEvens {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Let’s play a game called \"Odds and Evens\"!");
		System.out.print("Enter your name: ");
		String name = input.next();
		System.out.println("Welcome " + name.toUpperCase());
		System.out.print("Which do you choose (O)dds or (E)vens? ");

		String choice = input.next();

		while (!choice.equalsIgnoreCase("o") && (!choice.equalsIgnoreCase("e"))) {
			System.out.println("Please, enter 'o' or 'e'.");
			choice = input.next();
		}
		if (choice.equalsIgnoreCase("o")) {
			System.out.println(name + " has picked odds! The computer will be evens.");
		} else {
			System.out.println(name + " has picked evens! The computer will be odds.");
		}

		System.out.println("--------------------------------");
		System.out.print("How many fingers do you put out?: ");
		int player = input.nextInt();
		while (player > 5 || player < 0) {
			System.out.println("You can play 0 to 5 fingers!");
			player = input.nextInt();
		}

		Random rand = new Random();
		int computer = rand.nextInt(6);
		System.out.println("The computer plays " + computer + " \"fingers\".");
		System.out.println("--------------------------------");
		int sum = player + computer;
		System.out.println("The sum is: " + (sum));

		boolean oddOrEven = (sum % 2 == 0);
		if (oddOrEven) {
			System.out.println(sum + " is ...even.");
		} else {
			System.out.println(sum + " is ...odd.");

		}
		System.out.println("--------------------------------");
		if (oddOrEven) {
			System.out.println("Even");
			if (choice.equalsIgnoreCase("e")) {
				System.out.print("The user wins!");
			} else {
				System.out.print("The computer wins!");
			}
		} else {
			System.out.println("Odd");
			if (choice.equalsIgnoreCase("o")) {
				System.out.print("The user wins!");
			} else {
				System.out.println("The computer wins!");

			}
		}
	}
}
