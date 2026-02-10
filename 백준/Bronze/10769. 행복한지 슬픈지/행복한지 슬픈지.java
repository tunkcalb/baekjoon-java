import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		int happy = (line.length() - line.replace(":-)", "").length()) / 3;
		int sad = (line.length() - line.replace(":-(", "").length()) / 3;;
		
		String ans = "";
		if(happy == 0 && sad == 0) {
			ans = "none";
		}
		else if(happy > sad) {
			ans = "happy";
		}
		else if(sad > happy) {
			ans = "sad";
		}
		else ans = "unsure";
		
		System.out.println(ans);
	}
}
