import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	static int N;
	static int ewsn[];
	static double res;
	static boolean map[][];
	static int dx[] = {1,-1,0,0};
	static int dy []= {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ewsn = new int[4];
		map = new boolean[2*N+1][2*N+1];
		for(int i=0; i<4;i++) {
			ewsn[i] = Integer.parseInt(st.nextToken());
		}
		res =0;
		map[N][N] = true;
		dfs(N,N,1,0);
		System.out.println(res);
	}
	private static void dfs(int x, int y, double per, int num) {
		if(num==N) {
			res+=per;
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(ewsn[i]==0) continue;
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(map[nextY][nextX]) continue;
			map[nextY][nextX] = true;
			dfs(nextX,nextY,per*ewsn[i]*0.01,num+1);
			map[nextY][nextX] = false;
		}
		return;
	}
}
