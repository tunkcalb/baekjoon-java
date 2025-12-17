import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
	
		int cnt = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            String[] name = new String[n + 1];
            List<Integer> list = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                name[i] = br.readLine();
            }

            for (int i = 0; i < 2 * n - 1; i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                if(list.contains(num)) {
                   list.remove((Integer) num);
                }else {
                    list.add(num);
                }
            }
            cnt++;
            if(!list.isEmpty()) {
                sb.append(cnt).append(" ").append(name[list.get(0)]).append("\n");
            }
        }
        
        System.out.println(sb);
	}
}
