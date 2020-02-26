import java.io.PrintStream;
import java.util.Scanner;

public class Leet {
	public void leetSpeak(Scanner in, PrintStream out) {
		String line = "";
		String token = "";
		String str = "";
		String leetToken = "";

		while (in.hasNextLine()) {
			line = in.nextLine();
			Scanner sc = new Scanner(line);
			while (sc.hasNext()) {
				token = sc.next();
				if (token.charAt(token.length() - 1) == 's') {
					token = token.substring(0, token.length() - 1) + 'Z';
				}
				leetToken = token.replace("o", "0").replace("l", "1").replace("e", "3").replace("a", "4").replace("t",
						"7");
				str = "(" + leetToken + ")";
				out.append(str + " ");

			}
			out.append("\n");
		}
	}
}
