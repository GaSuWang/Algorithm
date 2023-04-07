

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] map = new int[N][N];
		int res[][] = new int[N][N];
		int MAX = 100000*400;
		for(int i=0; i<N;i++){
			Arrays.fill(map[i],MAX);
		}
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(cost, map[a][b]);
			map[b][a] = Math.min(cost, map[b][a]);
		}
		for(int i=0; i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==MAX) continue;
				res[i][j] = j+1;
			}
		}
		
		
		
		for(int k=0;k<N;k++) {
			for(int i=0; i<N;i++) {
				if(k==i) continue;
				for(int j=0; j<N;j++) {
					if(i==j) continue;
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						res[i][j] = res[i][k];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				if(i==j) sb.append("- ");
				else sb.append(res[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}


