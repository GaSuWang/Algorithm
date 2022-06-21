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
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] dp = new int[N+1];
		dp[1] = 0;
		if(N>1) {
			dp[2] = 1;
			if(N>2) dp[3] = 1;
		}
		
		for(int i=4;i<N+1;i++) {
			int a= Integer.MAX_VALUE,b= Integer.MAX_VALUE,c = Integer.MAX_VALUE;
			if(i%3==0) {
				a = dp[i/3];
			}
			if(i%2==0) {
				b = dp[i/2];
			}
			c = dp[i-1];
			dp[i] = Math.min(a, Math.min(b, c))+1;
		}
		System.out.println(dp[N]);
		
	}
}
