package practice3_regexp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WorkWithRegEx {
	public static String MATCH = "match";
	public static String NOT_MATCH = "not match";	

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter a path to file:");
		String filePath = scanner.nextLine();
		System.out.println("Enter a regular expression:");
		String regex = scanner.nextLine();
		scanner.close();
		regex_match(filePath, regex);
	}

	private static void regex_match(String sourceFilePath, String regex) {
		Scanner source;
		PrintWriter target;
		String targetFilePath = sourceFilePath.substring(0,sourceFilePath.length()-4)+"_result.txt";
		String line;
		Pattern pattern = Pattern.compile(regex);
		try {
			source = new Scanner (new File(sourceFilePath));
			target  = new PrintWriter(targetFilePath);
			while (source.hasNext()){
				line = source.nextLine();
				if (pattern.matcher(line).matches()){
					target.println(line+"\t"+MATCH);
				}else{
					target.println(line+"\t"+NOT_MATCH);
				}
			}
			target.close();
			source.close();
			System.out.println("File with the comparison results: " + targetFilePath);
		} catch (FileNotFoundException e) {
			System.out.println("File " + sourceFilePath + " is not found.");
		}		
	}
	
	

}
