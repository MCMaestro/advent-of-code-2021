import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jackr\\Desktop\\Advent of code 2021\\Day 1\\input.txt")); // line by line file reader for input file
		List<Integer> depths = new ArrayList<Integer>(); // list to store depths from input lists as Integers
		String line; // line from the input list
		Integer lastDepth = null; // used for the last depth when iterating to calculate whether depth has increased or not
		int increased = 0; // number of times the depth has increased
		
		while ((line = reader.readLine()) != null) { // iterates over lines in the txt input
			depths.add(Integer.valueOf(line)); // converts line string to integer and adds to depths array
		}
		
		reader.close(); // reader is no longer needed - closed
		
		for (int depth : depths) { // iterates over array of depth integers
			if (lastDepth != null && depth > lastDepth) { // checks that last depth number isn't null (ie first measurement) and if it is larger (deeper) than last depth, increment increased by 1
				increased++;
			}
			lastDepth = depth; // changes last depth to current depth for next iteration
		}
		System.out.println(increased);
	}
	
}
