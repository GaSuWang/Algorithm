
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N + 1][10];
		Arrays.fill(dp[1], 1);
		int sum = 10;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = sum;
			for (int j = 1; j < 10; j++) {
				dp[i][j] = (dp[i][j - 1] % 10007 - dp[i - 1][j - 1] % 10007 + 10007) % 10007;
				sum = (sum + dp[i][j]) % 10007;
			}
		}
		System.out.println(sum);

	}

}