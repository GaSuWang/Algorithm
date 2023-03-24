

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] h = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res = 0;
		for(int i=0; i<N;i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(h[cur]==0) {
				res++;
				h[cur-1]++;
			}
			else {
				h[cur]--;
				h[cur-1]++;
			}
		}
		System.out.println(res);
	
		
	}
}


