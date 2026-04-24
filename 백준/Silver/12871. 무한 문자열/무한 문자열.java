import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String t = br.readLine();
        
        String st = s + t;
        String ts = t + s;
        
        if (st.equals(ts)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
