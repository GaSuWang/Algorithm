////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[M][4];
		for(int i=0; i<N;i++) {
			char [] input = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(input[j]=='A') map[j][0]++;
				
				else if(input[j]=='C') map[j][1]++;
				
				else if(input[j]=='G') map[j][2]++;
				
				else if(input[j]=='T') map[j][3]++;
			}
		}
		int res = N*M;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int max = 0;
			char out= ' ';
			for(int j=0;j<4;j++) {
				if(max<map[i][j]) {
					max = map[i][j];
					if(j==0) out = 'A';						
					else if(j==1) out = 'C';
					else if(j==2) out = 'G';
					else if(j==3) out = 'T';
				}
			}
			res -= max;
			sb.append(out);
		}
		System.out.println(sb.toString());
		System.out.println(res);
	} 
}