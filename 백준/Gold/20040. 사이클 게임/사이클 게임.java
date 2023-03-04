import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;




public class Main {
	
	static int [] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N];
		for(int i=0; i<N;i++) {
			parents[i] = i;
		}
		
		for(int i=1; i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(union(a,b)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
	
	public static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		if(pA==pB) return true;
		parents[pB] = pA;
		return false;
	}
}
