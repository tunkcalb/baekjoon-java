import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int burger = Integer.MAX_VALUE;
		int drink = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			int money = Integer.parseInt(in.readLine());
			if(burger >= money) burger = money;
		}
		for(int i = 0; i < 2; i++) {
			int money = Integer.parseInt(in.readLine());
			if(drink >= money) drink = money;
		}
		
		System.out.println(burger + drink - 50);
	}
}
