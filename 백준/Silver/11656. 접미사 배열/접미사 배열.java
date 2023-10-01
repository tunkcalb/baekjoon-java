import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line = in.readLine();

		int length = line.length();

		String[] array = new String[length];
		for (int i = 0; i < length; i++) {
			array[i] = line.substring(i, length);
		}

		Arrays.sort(array);

		for (int i = 0; i < length; i++) {
			System.out.println(array[i]);
		}
	}
}
