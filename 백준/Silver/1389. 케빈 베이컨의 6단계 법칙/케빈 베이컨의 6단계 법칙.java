////
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M=  Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		for(int i=0; i<N;i++) {
			Arrays.fill(map[i], N*N);
		}
		for(int i=0; i<M;i++) {
			st  = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
			map[b][a] = 1;
		}
		for(int i=0; i<N; i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					map[j][k] = Math.min(map[j][k], map[j][i]+map[i][k]);
				}
			}
		}
		int res=0;
		int min = N*N;
		for(int i=0;i<N;i++) {
			int temp = 0;
			for(int j=0; j<N;j++) {
				if(i==j) continue;
				temp+=map[i][j];
			}
			if(temp<min) {
				min = temp;
				res = i;
			}
		}
		System.out.println(res+1);
		
	}
	
}