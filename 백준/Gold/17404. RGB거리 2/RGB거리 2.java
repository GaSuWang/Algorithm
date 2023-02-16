
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N][3];
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					dp[1][j] = Integer.MAX_VALUE;
					continue;
				}
				dp[1][j] = map[1][j] + map[0][i];
			}
			
			for(int j=2;j<N;j++) {
				dp[j][0] = map[j][0]+ Math.min(dp[j-1][1],dp[j-1][2]); 
				dp[j][1] = map[j][1]+Math.min(dp[j-1][0],dp[j-1][2]); 
				dp[j][2] = map[j][2]+Math.min(dp[j-1][1],dp[j-1][0]);
				if(j==N-1) dp[j][i] = Integer.MAX_VALUE;
			}
			res = Math.min(res, Math.min(dp[N-1][0], Math.min(dp[N-1][1],dp[N-1][2])));
		}
		System.out.println(res);
	}

}