import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int total = Integer.parseInt(st.nextToken());
		int dp[][] = new int[N+1][total+1];
		int range[][] = new int[N+1][2];
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			range[i][0] = time;
			range[i][1] = score;
		}
		for(int i=1;i<N+1;i++) {
			//시간
			for(int j=1;j<total+1;j++) {
				if(range[i][0]>j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-range[i][0]]+range[i][1]);
			}
		}
		System.out.println(dp[N][total]);
	}
}