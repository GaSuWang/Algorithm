import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;




public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int [][] map = new int[N][N];
		StringTokenizer st  = null;
		for(int i=0; i<N;i++) {
			Arrays.fill(map[i],10000);
		}
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
		}
		for(int k=0; k<N;k++) {
			for(int i=0; i<N;i++) {
				if(i==k) continue;
				for(int j=0; j<N;j++) {
					if(j==i) continue;
					map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
				}
			}
		}
		int res;
		for(int i=0; i<N;i++) {
			res=0;
			for(int j=0; j<N;j++) {
				if(i==j) continue;
				if(map[i][j]==10000 && map[j][i]==10000) res++;
			}
			System.out.println(res);
		}
	}
}
