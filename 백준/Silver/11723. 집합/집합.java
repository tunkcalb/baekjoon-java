import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static HashSet<Integer> set;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		set = new HashSet<>();
		sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			String command = st.nextToken();
			
			if(!command.equals("all") && !command.equals("empty")) {
				int num = Integer.parseInt(st.nextToken());
				if(command.equals("add")) set.add(num);
				if(command.equals("remove")) set.remove(num);
				if(command.equals("check")) {
					if(set.contains(num)) addOne();
					else addZero();
				}
				if(command.equals("toggle")) {
					if(set.contains(num)) set.remove(num);
					else set.add(num);
				}
			}
			else {
				if(command.equals("all")) all();
				else set = new HashSet<>();
			}
		}
		System.out.println(sb);
	}
	
	private static void addOne() {
		sb.append("1").append("\n");
	}
	
	private static void addZero() {
		sb.append("0").append("\n");
	}

	public static void all() {
		set = new HashSet<>();
		
		for(int i = 1; i <= 20; i++) {
			set.add(i);
		}
	}
}
