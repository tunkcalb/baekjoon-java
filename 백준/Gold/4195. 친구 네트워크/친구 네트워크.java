import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int T;
	static HashMap<String, String> parents;
	static HashMap<String, Integer> num;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			parents = new HashMap<>();
			num = new HashMap<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();

				if (parents.get(name1) == null) {
					parents.put(name1, name1);
					num.put(name1, 1);
				}
				if (parents.get(name2) == null) {
					parents.put(name2, name2);
					num.put(name2, 1);
				}

				union(name1, name2);
				sb.append(num.get(find(name1))).append("\n");
			}
		}

		System.out.println(sb);
	}

	private static void union(String name1, String name2) {
		name1 = find(name1);
		name2 = find(name2);

		if (!name1.equals(name2)) {
			parents.put(name2, name1);
			num.put(name1, num.get(name1) + num.get(name2));
		}
	}

	private static String find(String name) {
		if (name.equals(parents.get(name)))
			return name;

		else {
			String parent = find(parents.get(name));
			parents.put(name, parent);
			return parent;
		}
	}
}