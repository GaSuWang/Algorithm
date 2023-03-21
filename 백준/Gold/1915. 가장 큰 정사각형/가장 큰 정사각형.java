

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N+1][M+1];
		for(int i=1; i<=N;i++) {
			char [] temp = br.readLine().toCharArray();
			for(int j=1;j<=M;j++) {
				map[i][j] = temp[j-1]-'0';
			}
		}
		int res = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(map[i][j]==0) continue;
				map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j],map[i][j-1]))+1;
				res = Math.max(res,map[i][j]);
			}
		}
		System.out.println(res*res);
	}
}


