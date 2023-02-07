import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node{
	int num;
	int cost;
	public Node(int num, int cost) {
		super();
		this.num = num;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Node [num=" + num + ", cost=" + cost + "]";
	}
}

public class Main {
	static int max;
	static int target;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Node> [] list = new ArrayList[N];
		StringTokenizer st;
		for(int i=0; i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken())-1;
			int node2 = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			if(list[node1]==null) {
				list[node1] = new ArrayList<>();
			}
			if(list[node2]==null) {
				list[node2] = new ArrayList<>();
			}
			list[node1].add(new Node(node2,cost));
			list[node2].add(new Node(node1,cost));
		}
		boolean [] check = new boolean[N];
		check[0] = true;
		max = 0;
		target = 0;
		dfs(0,0,list,check);
		max = 0;
		check = new boolean[N];
		check[target] = true;
		dfs(target,0,list,check);
		System.out.println(max);
	}
	public static void dfs(int cur,int sum,List<Node>[] list, boolean[] check) {
		
			if(max<sum) {
				max = sum;
				target = cur;
			}
		if(list[cur]==null) return;
		for(Node node : list[cur] ) {
			if(check[node.num]) continue;
			check[node.num] = true;
			dfs(node.num,sum+node.cost,list,check);
		}
	}
}
