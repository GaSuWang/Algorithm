
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] dpMin = new int[N+1][3];
		int[][] dpMax = new int[N+1][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		dpMin[1][0] = Integer.parseInt(st.nextToken());
		dpMin[1][1] = Integer.parseInt(st.nextToken());
		dpMin[1][2] = Integer.parseInt(st.nextToken());
		dpMax[1][0] = dpMin[1][0];
		dpMax[1][1] = dpMin[1][1];
		dpMax[1][2] = dpMin[1][2];
		for(int i=2; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				int num = Integer.parseInt(st.nextToken());
				dpMin[i][j] = 999999;
				for(int k=j-1;k<=j+1;k++) {
					if(k<0||k>2) continue;
					dpMin[i][j] = Math.min(dpMin[i][j], num+dpMin[i-1][k]);
					dpMax[i][j] = Math.max(dpMax[i][j], num+dpMax[i-1][k]);
				}
			}
			
		}
		StringBuilder sb= new StringBuilder();
		sb.append(Math.max(dpMax[N][0],Math.max(dpMax[N][1],dpMax[N][2]))).append(' ')
		.append(Math.min(dpMin[N][0],Math.min(dpMin[N][1],dpMin[N][2])));
		System.out.println(sb.toString());
		

	}

}