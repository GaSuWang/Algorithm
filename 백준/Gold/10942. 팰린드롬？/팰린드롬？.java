import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int [][] dp = new int[N][N];
		for(int i=0; i<N;i++) {
			dp[i][i] = 1; 
		}
		for(int i=0;i<N-1;i++) {
			if(arr[i+1]==arr[i]) dp[i][i+1] = 1;
		}
		for(int i=2;i<N;i++) {
			for(int j=0;j<N-i;j++) {
				int left = j+1;
				int right = j+i-1;
				if(arr[j]==arr[j+i]&&dp[left][right]==1) {
					dp[j][j+i] = 1;
				}
			}
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken())-1;
			int right = Integer.parseInt(st.nextToken())-1;
			sb.append(dp[left][right]).append("\n");
		}
		System.out.println(sb.toString());
			
	}

}
