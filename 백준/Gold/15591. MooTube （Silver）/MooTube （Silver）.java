

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Node{
	int num;
	int cost;
	Node(int num, int cost){
		this.num = num;
		this.cost = cost;
	}
}


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		List<Node> list [] = new ArrayList[N];
		
		for(int i=0; i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			if(list[a]==null) list[a] = new ArrayList<>();
			if(list[b]==null) list[b] = new ArrayList<>();
			list[a].add(new Node(b,cost));
			list[b].add(new Node(a,cost));
			
		}
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken())-1;
			Queue<Integer> queue= new LinkedList<>();
			int res = 0;
			queue.offer(start);
			boolean [] check = new boolean[N];
			check[start] = true;
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				
				for(int j=0; j<list[cur].size();j++) {
					Node next = list[cur].get(j);
					if(check[next.num]) continue;
					if(next.cost<K) continue;
					res ++;
					queue.offer(next.num);
					check[next.num] = true;
				}
			}
		
			System.out.println(res);
		}
		
	}

}