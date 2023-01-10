
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] map = new int[V][V];
		for (int i = 0; i < V; i++) {
			Arrays.fill(map[i], 16000000);
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			map[v1][v2] = cost;
		}
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					map[i][j] =Math.min(map[i][j], map[i][k] + map[k][j]); 
				}
			}
		}
		int res = 16000000;
		for (int i = 0; i < V; i++) {
			res = Math.min(res, map[i][i]);
		}
		System.out.println(res==16000000?-1:res);

	}
}