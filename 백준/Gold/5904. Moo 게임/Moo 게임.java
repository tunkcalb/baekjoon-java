import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(in.readLine());
		
		Moo(num);
		System.out.println(answer);
		
	}

	private static void Moo(int num) {
		int size = 3;
		int index = 0;
		
		if(num == 1) {
			answer = 'm';
		}else if(num <= 3) {
			answer = 'o';
		}else {
			while(size < num) {
				size = size * 2 + index + 4;
				index++;
			}
			
			int psize = (size -  index - 3) / 2;
			
			if(size - psize + 1 <= num) {
				Moo(num - size + psize );
			}else if(num == psize + 1) {
				answer = 'm';
			}else {
				answer = 'o';
			}
			
			
		}
		
		
	}
}