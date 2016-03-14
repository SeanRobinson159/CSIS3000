package Week11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * Naive substring search
 * Performance is not bad for English text
 * Terrible for DNA and strings with small Alphabets
 */

public class substring {

	public static void main(String[] args) {
		String textToSearchIn = fileToString("./awmt.txt");
		String pattern = "scientists";
		
		System.out.println(textToSearchIn);
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

}
