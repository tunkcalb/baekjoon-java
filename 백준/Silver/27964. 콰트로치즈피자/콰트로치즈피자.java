import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String food = st.nextToken();
			int length = food.length();
			if (length >= 6) {
				String tail = food.substring(length - 6, length);
				if (tail.equals("Cheese"))
					set.add(food);
			}
		}

		if (set.size() >= 4) {
			System.out.println("yummy");
		} else {
			{
				System.out.println("sad");
			}

		}
	}
}
