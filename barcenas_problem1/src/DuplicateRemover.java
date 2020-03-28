import java.io.*;
import java.util.*;

public class DuplicateRemover {
	//Makes a hash set of unique words to be scanned from the input file
	public Set<String> uniqueWords;
	
	//Takes only unique words and stores them as instance variables
	public void remove(String dataFile){
		try(Scanner sc = new Scanner(new File(dataFile))) {
			uniqueWords = new HashSet<String>();
			//Ensures that if there still is another word, that it will be scanned
			while (sc.hasNextLine()) {
				this.uniqueWords.add(sc.next());
			}
		}
		//In case file is unable to be accesssed
		catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(0);
		}
		catch (NullPointerException npe) {
			System.err.println("The Data Being pointed to is null. Terminating.");
			System.exit(0);
		}
	}
		
	//Input txt file and outputs all unique strings obtained from remove
	public void write(String outputFile) {
		
		try(FileWriter uniFile = new FileWriter(new File(outputFile))) {
			//Writes the words individually into the txt file
			for (String str : this.uniqueWords) {
				uniFile.write(str + "\n");
			}
			System.out.println("Finish");
		}
		//In case of file error
		catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(0);
		}
	}
}
