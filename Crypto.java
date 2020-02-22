package alg;

import java.util.Scanner;

public class Crypto {

	public static void main(String[] args) {
		String userInput = normalizeText();
		System.out.println(encryptString(userInput, , 7));
	}

	public static String normalizeText() {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().replaceAll("[^a-zA-Z]+", "").toUpperCase();
		return text;

	}

	public static String caesarify(String text, int shift) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) + shift > 'Z') {
				int newCharIndex = (text.charAt(i) + shift - 1) % 'Z' + 'A';
				result += (char) newCharIndex;

			} else {
				int currCharIndex = text.charAt(i);
				result += (char) (currCharIndex + shift);
			}

		}
		return result;
	}

	public static String groupify(String text, int group) {
		String part = "";
		String dividedText = "";
		int left = (text.length() % group);
		String extra = text.substring(text.length() - left);
		String filler = "";

		for (int i = 0; i < text.length(); i++) {
			part += text.charAt(i);
			if (part.length() == group) {
				dividedText += part + " ";
				part = "";

			}
		}
		if (left > 0) {

			for (int i = 0; i < group - (text.length() % group); i++) {
				filler += "x";
			}

		}

		dividedText += extra + filler;
		return dividedText;
	}

	public static String encryptString(String str, int shiftValue, int groupSize) {
		return groupify(caesarify(str, shiftValue), groupSize);
	}

}
