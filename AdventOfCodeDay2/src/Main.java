import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Main {

	enum Command {FORWARD, UP, DOWN,}
	
    private static Pair<Command, Integer> createCommandPair(String[] splitLine) {
    	Command command = Command.valueOf(splitLine[0].toUpperCase());
        Integer unit = Integer.parseInt(splitLine[1]);
        return new ImmutablePair<Command, Integer>(command, unit);
    }
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jackr\\Desktop\\Advent of code 2021\\Day 2\\input.txt")); // line by line file reader for input file
		String line;
		ArrayList<Pair<Command, Integer>> instructions = new ArrayList<Pair<Command, Integer>>();

		
		while ((line = reader.readLine()) != null) { // iterates over lines in the txt input
			instructions.add(createCommandPair(line.split(" ")));
		}
		
		reader.close(); // reader is no longer needed - closed
		
		//Q1 
		
		int depth = 0;
		int forward = 0;
		
		for (Pair<Command, Integer> instruction : instructions) {
			if (instruction.getLeft() == Command.FORWARD) {
				forward += instruction.getRight();
			}
			else if (instruction.getLeft() == Command.DOWN) {
				depth += instruction.getRight(); 
			}
			else if (instruction.getLeft() == Command.UP) {
				depth -= instruction.getRight();
			}
		}
		
		System.out.println("Q1: " + depth*forward);
		
		//Q2
		
		int aim = 0;
		depth = 0;
		forward = 0;
		
		for (Pair<Command, Integer> instruction : instructions) {
			if (instruction.getLeft() == Command.FORWARD) {
				forward += instruction.getRight();
				depth += (aim*instruction.getRight());
			}
			else if (instruction.getLeft() == Command.DOWN) {
				aim += instruction.getRight(); 
			}
			else if (instruction.getLeft() == Command.UP) {
				aim -= instruction.getRight();
			}
		}
		
		System.out.println("Q2: " + depth*forward);
	}
}
