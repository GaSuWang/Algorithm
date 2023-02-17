
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int [] p = new int[N+1];
			boolean [] check = new boolean[N+1];
			for(int i=0; i<N-1;i++) {
				st= new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				p[child] = parent;
			}
			st = new StringTokenizer(br.readLine());
			int target1 = Integer.parseInt(st.nextToken());
			int target2 = Integer.parseInt(st.nextToken());
			int parent = target1;
			check[parent] = true;
			while(parent!=0) {
				parent = p[parent];
				check[parent] = true;
			}
			parent = target2;
			while(!check[parent]) {
				parent = p[parent];
			}
			System.out.println(parent);
		}
		
	}

}