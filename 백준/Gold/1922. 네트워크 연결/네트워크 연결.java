import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int node;
	int cost;
	Edge(int node, int cost){
		this.node = node;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost, o.cost);
	}
}


public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean check[] = new boolean[N];
		int map[][] = new int[N][N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		StringTokenizer st;
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken())-1;
			int node2 = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			map[node1][node2] = cost;
			map[node2][node1] = cost;
		}
		Edge cur;
		int cnt=0;
		int res = 0;
		pq.offer(new Edge(0,0));
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(check[cur.node]) continue;
			res += cur.cost;
			check[cur.node] = true;
			cnt++;
			if(cnt==N) break;
			for(int i=0; i<N;i++) {
				if(check[i]) continue;
				if(map[cur.node][i]==0) continue;
				pq.offer(new Edge(i,map[cur.node][i]));
				
			}
		}
		System.out.println(res);

	}

}
