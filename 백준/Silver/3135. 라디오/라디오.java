
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		int res = Math.abs(from-to);
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N;i++) {
			int saved = Integer.parseInt(br.readLine());
			int temp = 1;
			temp+=Math.abs(saved-to);
			res = Math.min(res,temp);
		}
		System.out.println(res);
	}
	
}