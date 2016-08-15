
package displayFilesAndFolders;

import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class DisplayFolderContents {

	public static void main(String[] args) {
		
		String value = JOptionPane.showInputDialog("What is the Directory?");
		if (value != null){
			System.out.println("I show these files in " + value);
		} else {
			System.out.println("Hello, No Path input");
			
		}
		File currentDir = new File(value);
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

