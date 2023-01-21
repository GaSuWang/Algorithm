
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int MAX = 100000*N+1;
		int [][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(map[i],MAX);
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			map[from][to] = Math.min(cost,map[from][to]);
		}
		for(int k=0;k<N;k++) {
			for(int i=0; i<N;i++) {
				if(i==k) continue;
				for(int j=0; j<N;j++) {
					if(i==j||j==k) continue;
					map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
				}
			}
		}
		for(int i=0; i<N;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<N;j++) {
				sb.append(map[i][j]==MAX?0:map[i][j]).append(' ');
			}
			System.out.println(sb.toString());
		}
	}
	
}