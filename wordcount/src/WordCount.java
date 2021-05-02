import java.io.BufferedReader;
import java.io.FilterReader;
import java.io.IOException;
import acm.program.ConsoleProgram;
import acmx.export.java.io.FileReader;
public class WordCount  {
	
	public int countWords(String str) {
		boolean inword = false;
		int word = 0;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				inword = true;
			} else {
				if (inword) word++;
				inword = false;
			}
		}
		if (inword) word++;
			return word;
	}
	
	public void run() {
		int lines = 0;
		int words = 0;
		int chars = 0;
		BufferedReader rd = openFileReader("File: ");
		try {
			while (true) {
				String line1 = rd.readLine();
				if (line1 == null) break;
				lines++;
				words += countWords(line1);
				chars += line1.length();
			}
			rd.close();
		} catch(IOException ex) {
			System.out.println("An I/O exception has occurred");
		}
	System.out.println("Line count = " + lines);
	System.out.println("Word count = " + words);
	System.out.println("Character count = " + chars);
	}
	private BufferedReader openFileReader(String prompt) {
		BufferedReader rd = null;
		while (rd == null) {
			String name = readLine(prompt);
			try {
				rd = new BufferedReader(new FilterReader(name));
			} catch (IOException ex) {
				System.out.println("Can't open that file.");
			}
		}
		return rd;
	}

	private String readLine(String prompt) {
		// TODO Auto-generated method stub
		return null;
	}
}