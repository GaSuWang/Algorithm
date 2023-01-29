import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int num;
	int cost;
	
	Node(int num, int cost){
		this.cost = cost;
		this.num = num;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}

	@Override
	public String toString() {
		return "Node [num=" + num + ", cost=" + cost + "]";
	}
	
	
}


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Node> [] list = new ArrayList[N];
		StringTokenizer st;
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			if(list[a]==null) {
				list[a] = new ArrayList<>();
			}
			list[a].add(new Node(b,cost));
			//list[b].add(new Node(a,cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		int [] costArr = new int[N];
		boolean [] check = new boolean[N];
		Arrays.fill(costArr,100000001);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		costArr[start] = 0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(check[cur.num]) continue;
			check[cur.num] = true;
			if(list[cur.num]==null) continue;
			for(int i=0; i<list[cur.num].size();i++) {
				Node next = list[cur.num].get(i);
				if(costArr[next.num]>costArr[cur.num]+next.cost) {
					costArr[next.num] = costArr[cur.num]+next.cost;
					pq.offer(new Node(next.num,costArr[cur.num]+next.cost));
				}
			}
		}
		System.out.println(costArr[end]);
		
	}
	
}
