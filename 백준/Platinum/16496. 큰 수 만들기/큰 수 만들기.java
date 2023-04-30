import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		String[] line = in.readLine().split(" ");
		
		Arrays.sort(line, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		
		String answer = "";
		for(int i = 0; i < N; i++) {
			answer += line[i];
		}
		if(answer.charAt(0) == '0') System.out.println(0);
		else System.out.println(answer);
	}
}
