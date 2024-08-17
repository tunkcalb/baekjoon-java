import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		map.put('A',4);
		map.put('B',3);
		map.put('C',2);
		map.put('D',1);
		map.put('F',0);
		
		double num = 0;
		
		num = map.get(line.charAt(0));
		
		if(line.length() == 2) {
			if(line.charAt(1) == '+') num += 0.3;
			else if(line.charAt(1) == '-')num -= 0.3;
		}
		
		System.out.println(num);
	}
}
