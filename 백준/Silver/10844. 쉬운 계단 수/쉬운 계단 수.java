import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
			int minus = i - 1;
			int plus = i + 1;
			if (N > 1 && minus >= 0) {
				dp[2][minus] += dp[1][i];
			}
			if (N > 1 && plus < 10) {
				dp[2][plus] += dp[1][i];
			}
		}

		for (int i = 2; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				int minus = j - 1;
				int plus = j + 1;
				if (minus >= 0) {
					dp[i + 1][minus] = (dp[i + 1][minus] + dp[i][j]) % 1000000000;
				}
				if (plus < 10) {
					dp[i + 1][plus] = (dp[i + 1][plus] + dp[i][j]) % 1000000000;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < 10; i++) {
			res = (res + dp[N][i]) % 1000000000;
		}
		System.out.println(res);
	}

}
