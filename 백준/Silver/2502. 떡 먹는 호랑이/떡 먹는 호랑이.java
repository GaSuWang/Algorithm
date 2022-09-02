import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dp[] = new int[D+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=D;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		for(int i=1;i<=K;i++) {
			for(int j=i;j<=K;j++) {
				if(dp[D-2]*i+dp[D-1]*j==K) {
					System.out.println(i);
					System.out.println(j);
					return;
				}
			}
		}
		
	}
	
}