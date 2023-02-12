import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;




public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp[0] = Integer.parseInt(st.nextToken());
		int res = dp[0];
		for(int i=1; i<N;i++) {
			int cur = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(cur, dp[i-1]+cur);
			res=Math.max(res,dp[i]);
		}
		System.out.println(res);
	}
	
	
}
