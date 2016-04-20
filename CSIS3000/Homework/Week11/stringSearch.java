package Week11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Naive substring search
 * Performance is not bad for English text
 * Terrible for DNA and strings with small alphabets
 * Worst case complexity is O(nm). For English text, the complexity is closer to O(n).
 */

public class stringSearch {

	public static void main(String[] args) {
		String textToSearchIn = fileToString("./awmt.txt");
		Scanner input = new Scanner(System.in);
		String pattern = "";
		
		while (!pattern.equals("q")) {
			System.out.print("Enter a word to search in awmt.txt (q to quit): ");
			pattern = input.nextLine();
			ArrayList<Integer> indices = search(pattern, textToSearchIn);
			System.out.println("The word \"" + pattern + "\" occurs " + indices.size() + " time(s) at index(s): " + indices);
		}

		input.close();
	}

	private static String fileToString(String filePath) {
		String str = null;
		try {
			str = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return str;
		}
		return str;
	}

	public static ArrayList<Integer> search(String pattern, String textToSearchIn) {
		int patternLength = pattern.length();
		int textToSearchInLength = textToSearchIn.length();
		int j;
		ArrayList<Integer> indices = new ArrayList<Integer>();

		for (int i = 0; i <= (textToSearchInLength - patternLength); i++) {
			for (j = 0; j < patternLength; j++) {
				if (textToSearchIn.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == patternLength) {
				indices.add(i);
			}
		}
		return indices;
	}

}
