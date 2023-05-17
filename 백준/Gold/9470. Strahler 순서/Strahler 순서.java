import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int res = 0;
			int node [][] = new int[M][3];//0 insertCount, 1 Strahler, 2 input Count
			List<Integer> outList [] = new ArrayList[M];
			for(int i=0; i<P;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				node[to][0]++;
				if(outList[from]==null) {
					outList[from] = new ArrayList<>();
				}
				outList[from].add(to);
			}
			Queue<Integer> queue = new LinkedList<>();
			for(int i=0; i<M;i++) {
				if(node[i][0]==0) {
					node[i][1] = 1;
					queue.offer(i);
				}
			}
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				if(outList[cur]==null) continue;
				for(int out : outList[cur]) {
					node[out][0]--;
					
					if(node[cur][1]==node[out][1]) {
						node[out][2]++;
						
					}
					else if(node[cur][1]>node[out][1]) {
						node[out][2] = 1;
						node[out][1] = node[cur][1];
					}
					if(node[out][0]==0) {
						queue.offer(out);
						if(node[out][2]>1) node[out][1]++;
					}
				}
			}
			res = node[M-1][1];	
			System.out.println(t+" "+res);
		}
	}
	
}
