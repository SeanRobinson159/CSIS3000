package Week11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * Naive substring search
 * Performance is not bad for English text
 * Terrible for DNA and strings with small alphabets
 * Worst case complexity is O(nm). For English text, the complexity is closer to O(n).
 */

public class substring {

	public static void main(String[] args) {
		String textToSearchIn = fileToString("./awmt.txt");
		String pattern = "scientist";
		
		System.out.println("The word " + pattern + " first occurs at index: "
				+ search(pattern, textToSearchIn));
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

	// Return the first occurrence of the index of the pattern
	public static int search(String pattern, String textToSearchIn) {
		int patternLength = pattern.length();
		int textToSearchInLength = textToSearchIn.length();
		int j;

		for (int i = 0; i <= (textToSearchInLength - patternLength); i++) {
			for (j = 0; j < patternLength; j++) {
				if (textToSearchIn.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == patternLength) {
				return i;
			}
		}
		return Integer.MIN_VALUE;
	}

}
