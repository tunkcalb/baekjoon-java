import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
	    StringTokenizer st = new StringTokenizer(in.readLine());
		
	    int A = Integer.parseInt(st.nextToken());
	    
	    int B = Integer.parseInt(st.nextToken());
	    
	    int V = Integer.parseInt(st.nextToken());
	    
	    int cnt = 0;
	    V -= A;
	    cnt++;
	    
	    A -= B;
	    
	    if(V % A == 0) cnt += V / A;
	    else cnt += V / A + 1;
	    
	    System.out.println(cnt);
	}
}
