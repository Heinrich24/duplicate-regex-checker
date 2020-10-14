package com.heinrich24;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMain {
	public static void main(String[] args) {
		// Define regex patter to capture duplicate words in a String
		String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
		// Compile patter to be case-insensitive
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		Scanner in = new Scanner(System.in);
		int numSentences = Integer.parseInt(in.nextLine());

		while (numSentences-- > 0) {
			String input = in.nextLine();

			Matcher m = p.matcher(input);			
			while (m.find()) {
				// Replace the entire group match with the first instance found in the group.
				input = input.replaceAll(m.group(), m.group(1));
			}
			// Print the results to the screen
			System.out.println(input);
		}

		in.close();
	}

}
