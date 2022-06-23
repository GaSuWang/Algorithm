import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 10000;
		}
		dp[0] = 0;
		for(int i=0; i<N;i++) {
			for(int j=1;j<=arr[i];j++) {
				if(i+j>=N) break;
				dp[i+j] = Math.min(dp[i]+1, dp[i+j]);
			}
		}
		if(dp[N-1]==10000) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[N-1]);
		}
	}
}
