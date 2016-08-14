package displayFilesAndFolders;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DisplayFolderContents {

	public static void main(String[] args) {
		Scanner user_input = new Scanner(System.in);
		String user_i;
		System.out.print("Directory: ");
		user_i = user_input.next();
		File currentDir = new File(user_i);
		
		displayDirectoryContents(currentDir);
		
	}

	public static void displayDirectoryContents(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}