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

	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			int num = Integer.parseInt(br.readLine());
			int dp[] = new int[num + 1];
			dp[0] = 0;
			dp[1] = 1;
			if (num > 1) {
				dp[2] = 2;
				if(num>2) {
					dp[3] = 4;
				}
			}

			for (int i = 4; i <= num; i++) {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
			System.out.println(dp[num]);

		}
	}
}
