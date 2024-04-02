import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		String[] serial = new String[n];
		
		for(int i = 0; i < n; i++) {
			serial[i] = in.readLine();
		}
		
		Arrays.sort(serial, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) {
					return -1;
				}
				else if (o1.length() == o2.length()) {
					if(sum(o1) == sum(o2)) {
						return o1.compareTo(o2);
					}
					else return Integer.compare(sum(o1), sum(o2));
				}
				else return 1;
			}
		});
		for(int i = 0; i < n; i++) {
			System.out.println(serial[i]);
		}
		
	}
	public static int sum(String line) {
		int sum = 0;
		
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) >= '0' && line.charAt(i) <= '9') sum += line.charAt(i) - '0';
		}
		
		return sum;
	}
}
