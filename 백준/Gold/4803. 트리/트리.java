
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N,M;
		
		for(int t=1;;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N==0&&M==0) break;
			int [] nodeParent = new int[N];
			int res = N;
			boolean [] cycleCheck = new boolean[N];
			HashSet<Integer> parents = new HashSet<>();
			System.out.print("Case "+t+": ");

			for(int i=0; i<N;i++) {
				nodeParent[i] = i;
			}
			for(int i=0; i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				if(!union(a,b,nodeParent,cycleCheck)) cycleCheck[find(a,nodeParent)] = true;
			}
			for(int i=0;i<N;i++) {
				 parents.add(find(nodeParent[i],nodeParent));
			}
			res = parents.size();
			for(Integer p : parents) {
				if(cycleCheck[find(p,nodeParent)]) res--;
			}
			if(res==0) {
				System.out.println("No trees.");
			}
			else if(res==1) {
				System.out.println("There is one tree.");
			}
			else {
				System.out.println("A forest of "+res+" trees.");
			}
		}	
	}
	public static int find(int a, int[] nodeParent) {
		if(nodeParent[a]==a) {
			return a;
		}
		else return nodeParent[a] = find(nodeParent[a],nodeParent);
	}
	public static boolean union(int a, int b, int[] nodeParent, boolean [] cycleCheck) {
		int pA = find(a,nodeParent);
		int pB = find(b,nodeParent);
		nodeParent[pB] = pA;
		if(pA==pB||cycleCheck[pA]||cycleCheck[pB]) return false;
		
		return true;
	}
	
}