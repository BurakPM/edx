public class TripPlanner {
	static final Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);
	static final DecimalFormat time = new DecimalFormat("#.00");

	public static void main(String[] args) {
		greetUser();
		getTimeAndBudget();
		getTimeDifference();
		getSquareArea();
	}

	public static void greetUser() {
		System.out.println("Welcome to Vacation Planner!");
		System.out.print("What is your name? ");
		String name = input.nextLine();
		System.out.println("Nice to meet you " + name + ",");
		System.out.print(" where are you travelling to? ");
		String destination = input.nextLine();
		System.out.println("Great! " + destination + " sounds like a great trip");
		System.out.println("***********");
	}

	public static void getTimeAndBudget() {
		System.out.print("How many days are you going to spend travelling? ");
		int days = input.nextInt();
		System.out.print("How much money, in USD, are you planning");
		System.out.print(" to spend on your trip? ");
		double budgetUsd = input.nextDouble();
		System.out.print("What is the three letter currency symbol");
		System.out.print(" for your travel destination? ");
		String currency = input.next();
		System.out.print("How many " + currency + " are there in 1 USD? ");
		double currencyValue = input.nextDouble();
		System.out.print("If you are travelling for " + days + " that is the ");
		System.out.println("same as " + days * 24 + " hours  or " + days * 1440 + " minutes");
		System.out.print("If you are going to spend $" + truncate(budgetUsd) + " USD that means ");
		System.out.println("per day you can spend up to $" + truncate(budgetUsd / days) + " USD");
		System.out.print("Your total budget in " + currency + " is " + truncate(budgetUsd * currencyValue));
		System.out.print(" " + currency + ", which per day is " + truncate(budgetUsd * currencyValue / days));
		System.out.println(" " + currency);
		System.out.println("***********");

	}

	public static void getTimeDifference() {
		System.out.print("What is the time difference, in hour, between ");
		System.out.println("your home and your destination?");
		System.out.print("Enter a negative number if the destination time zone is behind ");
		System.out.print("your home time zone: ");
		int timeDif = input.nextInt();
		double timeDifNight;
		double timeDifNoon;

		if (timeDif >= 0) {
			timeDifNight = (timeDif % 24) + 0.00;
			timeDifNoon = (timeDif % 24) + 12.00;
		} else {
			timeDifNight = 24.00 - ((-1 * timeDif) % 24);
			timeDifNoon = 12.00 - ((-1 * timeDif) % 24);
		}

		System.out.print("That means that when it is midnight at home ");
		System.out.print("it will be " + time.format(timeDifNight) + " in your destination ");
		System.out.println("and when it is noon at home it will be " + time.format(timeDifNoon));
		System.out.println("***********");
	}

	public static void getSquareArea() {
		System.out.print("What is the square area of your destination country in km2? ");
		double areaInKm2 = input.nextDouble();
		double areaInMiles2 = (areaInKm2 * 0.38610);

		System.out.println("In miles2 that is " + areaInMiles2);
		System.out.println("***********");
	}

	public static double truncate(double value) {
		double exit;
		value *= 100;
		exit = (int) value / 100.0;
		return exit;
	}

}
