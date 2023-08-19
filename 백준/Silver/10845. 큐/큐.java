import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = null;
		Queue<Integer> q = new LinkedList<>();
		int num = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			String command = st.nextToken();
			
			if(command.equals("push")) {
				int number = Integer.parseInt(st.nextToken());
				q.offer(number);
				num = number;
			}
			else if (command.equals("pop")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.poll()).append("\n");
			}
			else if(command.equals("size")) {
				sb.append(q.size()).append("\n");
			}
			else if(command.equals("empty")) {
				if(q.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}else if(command.equals("front")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.peek()).append("\n");
			}else {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(num).append("\n");
			}
		}
		System.out.println(sb);
	}
}
