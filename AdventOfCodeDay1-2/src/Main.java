import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jackr\\Desktop\\Advent of code 2021\\Day 1\\input.txt")); // line by line file reader for input file
		List<Integer> depths = new ArrayList<Integer>(); // list to store depths from input lists as Integers
		String line; // line from the input list
		Integer depth1 = null; // used for the last depth when iterating to calculate whether depth has increased or not
		Integer depth2 = null;
		Integer lastCombinedDepth = 0;
		int increased = 0; // number of times the depth has increased
		
		while ((line = reader.readLine()) != null) { // iterates over lines in the txt input
			depths.add(Integer.valueOf(line)); // converts line string to integer and adds to depths array
		}
		
		reader.close(); // reader is no longer needed - closed
		
		for (int depth : depths) { // iterates over array of depth integers
			if (depth1 != null && depth2 != null ) { // checks that both previous depth int's aren't null (ie not yet set) 
				if ((depth1 + depth2 + depth) > lastCombinedDepth) { // combines most recent 3 depths and compares to last 3 depth sliding window and increments increased int by 1
					increased++; 
				}
				lastCombinedDepth = (depth1 + depth2 + depth);  // sets the lastCombinedDepth (previous 3-depth sliding window) to current for next iteration
			}
			depth1 = depth2; // changes oldest depth to second oldest for next iteration
			depth2 = depth; // changes last depth to current depth for next iteration
		}
		increased--; // adjusts for first 3-depth sliding window being compared to 0 cos I'm lazy
		System.out.println(increased);
	}
}