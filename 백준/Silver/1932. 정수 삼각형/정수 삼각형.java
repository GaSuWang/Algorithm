import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N][N];
		dp[0][0] = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				int left = j-1;
				int right = j;
				int cur = Integer.parseInt(st.nextToken());
				if(left>=0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][left]+cur); 
				}
				if(right<N) {
					dp[i][j] = Math.max(dp[i][j],dp[i-1][right]+cur);
				}
			}
		}
		int res = 0;
		for(int i=0;i<N;i++) {
			res = Math.max(res, dp[N-1][i]);
		}
		System.out.println(res);
		
				
	}
	
	
}