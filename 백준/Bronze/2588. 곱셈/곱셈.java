import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int num = Integer.parseInt(in.readLine());
		
		int first = num / 100;
		int third = num % 10;
		int second = (num - first * 100) / 10;
		
		System.out.println(N * third);
		System.out.println(N * second);
		System.out.println(N * first);
		System.out.println(N * num);		
	}
}
