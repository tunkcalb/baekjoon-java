import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int low = Integer.parseInt(in.readLine());
		int mid = Integer.parseInt(in.readLine());
		int high = mid - low + mid;
		System.out.println(high);
		
	}
}
