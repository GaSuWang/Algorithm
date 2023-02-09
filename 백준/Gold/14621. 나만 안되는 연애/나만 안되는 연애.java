
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int node1;
	int node2;
	int cost;
	public Edge(int node1, int node2, int cost) {
		super();
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.cost, o.cost);
	}
	
	
}


public class Main {
	
	static int [] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char [] arr= new char[N];
		parent = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			arr[i] = st.nextToken().charAt(0);
			parent[i] = i;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken())-1;
			int node2 = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			if(arr[node1]==arr[node2]) continue;
			pq.offer(new Edge(node1,node2,cost));
		}
		int sum =0;
		int connection = 1;
		while(connection != N&&!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(union(cur.node1,cur.node2)) {
				connection++;
				sum+=cur.cost;
			}
		}
		if(connection!=N) {
			System.out.println(-1);
			return;
		}
		System.out.println(sum);
	}
	public static boolean union(int node1, int node2) {
		int pNode1 = find(node1);
		int pNode2 = find(node2);
		if(pNode1 == pNode2) return false;
		parent[pNode2] = pNode1;
		return true;
	}
	
	public static int find(int node) {
		if(parent[node]==node) return node;
		return find(parent[node]);
	}
}