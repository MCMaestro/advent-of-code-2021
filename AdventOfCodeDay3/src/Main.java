import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static List<String> binaryStrings = new ArrayList<String>(); // list to store depths from input lists as Integers
	static int binaryLength;
	
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jackr\\Desktop\\Advent of code 2021\\Day 3\\input.txt")); // line by line file reader for input file

		List<List<String>> columns = new ArrayList<List<String>>();

		String line; // line from the input list
		while ((line = reader.readLine()) != null) { // iterates over lines in the txt input
			binaryStrings.add(line); // converts line string to integer and adds to depths array
		}
		
		reader.close(); // reader is no longer needed - closed
		
		binaryLength = binaryStrings.get(0).length(); // gets length of binary for later use
		
		for (int i = 0; i < binaryLength; i++) {
			columns.add(new ArrayList<String>()); // creates a new list for each column in the columns list
		}
		
		for (String binLine : binaryStrings) {
			for (int i = 0; i < binaryLength; i++) {
				columns.get(i).add(String.valueOf(binLine.charAt(i))); // fills out the columns lists
			}
		}
		
		// Q1
		String gammaBin = "";
		String epsilonBin = "";
		for (List<String> column : columns) {
			int ones = 0;
			int zeros = 0;
			for (String bit : column) {
				if (bit.equals("0")) {
					zeros++;
				}
				else {
					ones++;
				}
			}
			if (ones > zeros) {
				gammaBin = gammaBin + "1";
				epsilonBin = epsilonBin + "0";
			}
			else {
				gammaBin = gammaBin + "0";
				epsilonBin = epsilonBin + "1";
			}
		}
		
		int gamma = Integer.parseInt(gammaBin, 2);
		int epsilon = Integer.parseInt(epsilonBin, 2);
		System.out.println("Q1: " + gamma*epsilon);
		
		// Q2
		int oxygen = Integer.parseInt(getOxygen(), 2);
		int cO2 = Integer.parseInt(getCO2(), 2);
		System.out.println("Q2: " + oxygen*cO2);
	}
	
	static String getOxygen() {
		List<String> remaining = new ArrayList<String>(binaryStrings);
		int position = 0;
		while (remaining.size() > 1 && position < binaryLength) {
			List<String> toRemove = new ArrayList<String>();
			int ones = 0;
			int zeros = 0;
			
			for (String binary : remaining ) {

				if (String.valueOf(binary.charAt(position)).equals("1")) {
					ones++;
				}
				else {
					zeros++;
				}
			}
			
			if (ones >= zeros) {
				for (String binary : remaining ) {
					if (String.valueOf(binary.charAt(position)).equals("0")) {
						toRemove.add(binary);
					}
				}
			}
			else {
				for (String binary : remaining ) {
					if (String.valueOf(binary.charAt(position)).equals("1")) {
						toRemove.add(binary);
					}
				}
			}
			remaining.removeAll(toRemove);
			position++;
		}
		return remaining.get(0);
	}
	
	static String getCO2() {
		List<String> remaining = new ArrayList<String>(binaryStrings);
		int position = 0;
		while (remaining.size() > 1 && position < binaryLength) {
			List<String> toRemove = new ArrayList<String>();
			int ones = 0;
			int zeros = 0;
			for (String binary : remaining ) {
				if (String.valueOf(binary.charAt(position)).equals("1")) {
					ones++;
				}
				else {
					zeros++;
				}
			}
			
			if (ones >= zeros) {
				for (String binary : remaining ) {
					if (String.valueOf(binary.charAt(position)).equals("1")) {
						toRemove.add(binary);
					}
				}
			}
			else {
				for (String binary : remaining ) {
					if (String.valueOf(binary.charAt(position)).equals("0")) {
						toRemove.add(binary);
					}
				}
				if (toRemove.size() == remaining.size()) {
					toRemove.remove(toRemove.size()-1);
				}
			}
			remaining.removeAll(toRemove);
			position++;
		}
		return remaining.get(0);
	}
}
