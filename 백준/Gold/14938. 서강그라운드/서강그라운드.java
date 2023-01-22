
////
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
		int R = Integer.parseInt(st.nextToken());
		int disMap[][] = new int[N][N];
		int itemMap[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			itemMap[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N;i++) {
			Arrays.fill(disMap[i],15000);
		}
		for(int i=0; i<R;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			disMap[a][b] = cost;
			disMap[b][a] = cost;
		}
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				if(k==i) continue;
				for(int j=0;j<N;j++) {
					if(i==j) continue;
					disMap[i][j] = Math.min(disMap[i][j], disMap[i][k]+disMap[k][j]);
				}
			}
		}
		int res = 0;
		for(int i=0;i<N;i++) {
			int tempSum = itemMap[i];
			for(int j=0; j<N;j++) {
				if(i==j||disMap[i][j]>M) continue;
				tempSum+=itemMap[j];
			}
			res = Math.max(res,tempSum);
		}
		System.out.println(res);
	}
	
}