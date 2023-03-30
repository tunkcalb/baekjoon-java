import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		List<Character> nums = new ArrayList<>();
		
		for(int i = 0; i < line.length(); i++) {
			nums.add(line.charAt(i));
		}
		
		Collections.sort(nums, Collections.reverseOrder());
		
		for(int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i));
		}
	}
}