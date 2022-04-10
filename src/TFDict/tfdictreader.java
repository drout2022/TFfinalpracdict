package TFDict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class tfdictreader {
	
	public static void main(String[]args) throws IOException {

		// path to the input text file
		String path = "data\\dict.txt";
		
		// Read the file
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);		
		
		String line = null;
		String meaning[] = null; 
		int ind = 0;
		int linenum = 1;
		
		//Print output if file exists or not 
		System.out.println(doesFileExist(path));
		
		//Loop through each line, read the first word as the word to search, and the output the meanings on separate lines
		
		while (( line = br.readLine()) != null) {
			
			//in each line, print the word(s) before '-' as the word/phrase to be searched
			System.out.println("word " + linenum++ + " : " +  line.split("-")[0]);
			
			// get the remaining text after the '-' as the meaning(s)
			meaning=line.substring(line.indexOf("-")+1).split(",");
			
			//split if there are multiple meanings and print on separate lines
			for (ind = 0; ind < meaning.length; ind++) { 
			System.out.println("meaning "+(ind+1)+" : "+meaning[ind]);
			}
		}
		
		br.close();
	}
	
	// method to check if the file exists or not
	public static String  doesFileExist(String path) throws IOException {  
	  try {
	  Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(path);
		prop.load(fi);
		return "File does exist";		
	  }
	  catch(IOException e) {
		  System.out.println("Caught IOExeption");
		  return"File does not exist";
	  }
	}
}

