////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean check [];
		int map[][];
		StringTokenizer st;
		for(int t=0;t<T;t++) {
			max = 0;
			check = new boolean[11];
			map = new int[11][11];
			for(int i=0; i<11;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<11;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(map,check,0,0);
			System.out.println(max);
		}
	}
	public static void dfs(int[][]map, boolean[] check, int num, int sum) {
		if(num==11) {
			max = Math.max(max,sum);
			return;
		}
		for(int i=0;i<11;i++) {
			if(map[num][i]==0) continue;
			if(check[i]) continue;
			check[i] = true;
			dfs(map,check,num+1,sum+map[num][i]);
			check[i] = false;
		}
	}
}