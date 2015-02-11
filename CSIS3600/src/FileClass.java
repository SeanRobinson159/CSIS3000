//Using the File Class
//Usage: Java FileClass filename

import java.io.*;

public class FileClass {

	public static void main(String[] args) throws IOException {
		// Construct a File Object for a given file
		File f = new File(args[0]);

		if (f.exists()) {
			System.out.println("File Found");
		} else {
			System.out.println("File Not Found");
		}
		//print out the full name
		System.out.println("Canonical Name: " + f.getCanonicalPath());

		//Check if it's readable
		if (f.canRead()) {
			System.out.println("Readable");
		} else {
			System.out.println("Not readble");
		}
		
		//
	}

}
