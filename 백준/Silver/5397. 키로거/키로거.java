import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			int idx = 0;
			LinkedList<Character> linkedList = new LinkedList<>();
			ListIterator<Character> list = linkedList.listIterator();
			for(int j = 0; j < line.length(); j++) {
				char now = line.charAt(j);
				
				if(now == '<') {
					if(list.hasPrevious()) list.previous();
				}
				else if(now == '>') {
					if(list.hasNext()) list.next();
				}
				else if(now == '-') {
					if(list.hasPrevious()) {
						list.previous();
						list.remove();
					}
				}
				else {
					list.add(now);
				}
			}
			for(char now : linkedList) {
				sb.append(now);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
