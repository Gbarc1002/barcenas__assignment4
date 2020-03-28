import java.io.*;
import java.util.*;

public class DuplicateCounter {
	
	public HashMap<String, Integer> wordCount;
	
	public void count(String dataFile) {
		try(Scanner sc = new Scanner(new File(dataFile))) {	
			this.wordCount = new HashMap<String, Integer>();
			String word;
			while (sc.hasNextLine()) {	
				word = sc.next();
				if (this.wordCount.containsKey(word)) {
					this.wordCount.replace(word, this.wordCount.get(word) + 1);	
				} else {
					this.wordCount.put(word, 1);
				}
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
				for (String str : this.wordCount.keySet()) {
					uniFile.write(str + " " + this.wordCount.get(str) +"\n");
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
