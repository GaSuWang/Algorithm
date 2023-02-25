import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Edge implements Comparable<Edge>{
	int num1;
	int num2;
	int cost;
	Edge(int num1, int num2, int cost){
		this.num1 = num1;
		this.num2 = num2;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.cost,o.cost);
	}
}


public class Main {
	
	static int [] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		parents = new int[N];
		
		for(int i=0; i<N;i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken())-1;
			int num2 = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(num1,num2,cost));
		}
		
		int res = 0;
		int count = 0;
		while(count<N-2) {
			Edge cur = pq.poll();
			if(union(cur.num1,cur.num2)) {
				count++;
				res+=cur.cost;
			}
		}
		System.out.println(res);
	}
	
	public static int find(int num) {
		if(parents[num]==num) return num;
		return parents[num] = find(parents[num]);
	}
	
	public static boolean union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		if(pA==pB) return false;
		parents[pB] = pA;
		return true;
	}
}
