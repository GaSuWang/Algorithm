////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//요즘들어 생각하고 푸는게 아니라 무지성으로 푸는 느낌인데...
// 답도 너무 빨리 찾아보고, 한번 틀리면 질문 게시판부터 들어가니... 이게 맞나...?
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long [N+1];
		for(int i=1; i<=(N<6?N:6);i++) {
			dp[i] = i;
		}
		for(int i=7;i<=N;i++) {
			dp[i] = dp[i-1] +1;
			for(int j=1; j<=i-3;j++) {
				dp[i] = Math.max(dp[i], dp[i-(j+2)]*(j+1));
			}
		}
		System.out.println(dp[N]);

		
		

	}
}