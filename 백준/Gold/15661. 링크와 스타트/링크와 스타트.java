import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean check[];
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		map = new int[N][N];
		check = new boolean[N];
		res= 2000;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(res);
		
	}
	public static void dfs(int num) {
		if(num==N) {
			int teamA=0;
			int teamB = 0;
			for(int i=0; i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j) continue;
					if(check[i]==check[j]) {
						if(check[i]) {
							teamA+=map[i][j];
						}
						else {
							teamB+=map[i][j];
						}
					}
				}
			}
			if(teamA!=0&&teamB!=0) {
				res = Math.min(res, Math.abs(teamA-teamB));
			}
			return;
		}
		
		dfs(num+1);
		check[num] = true;
		dfs(num+1);
		check[num] = false;
	}
}
