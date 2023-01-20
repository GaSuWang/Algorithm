
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String keyword = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int res =0;
		for(int i=0; i<N;i++) {
			String cur = br.readLine();
			String cur2=cur+cur;
			if(cur2.contains(keyword)) res++;
		}
		System.out.println(res);
	}
	
}