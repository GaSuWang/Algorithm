

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Node{
	int x;
	int y;
	public Node(int y, int x) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Node o = (Node)obj;
		return this.x==o.x&&this.y==o.y;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return y*10+x;
	}
	
}

public class Main {

	static int [] dy = {0,1,0,-1};
	static int [] dx = {1,0,-1,0};
	static Node [][] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[N][M];
		parent = new Node[N][M];
		
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				parent[i][j] = new Node(i,j);
			}
		}
		
		for(int i=0; i<N;i++) {
			char [] temp = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(temp[j]=='R') map[i][j]=0;
				else if(temp[j]=='D') map[i][j]=1;
				else if(temp[j]=='L') map[i][j]=2;
				else if(temp[j]=='U') map[i][j]=3;
			}
		}
		if(N==1&&M==1) System.out.println(1);
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==-1) continue;
				dfs(map,i,j);
			}
		}
		HashSet <Node> set = new HashSet<>();
		for(int i=0; i<N;i++) {
			for(int j=0; j<M;j++) {
				set.add(findP(parent[i][j]));
			}
		}
		System.out.println(set.size());
	}
	
	public static void dfs(int [][] map, int y, int x) {
		int dir = map[y][x];
		int nextY = y + dy[dir];
		int nextX = x + dx[dir];
		if(map[nextY][nextX]==-1) return;
		if(union(new Node(y,x),new Node(nextY,nextX))) {
			dfs(map,nextY,nextX);
		}
	}
	
	
	public static Node findP(Node cur) {
		int x = cur.x;
		int y = cur.y;
		if(parent[y][x].equals(cur)) return cur;
		else return parent[y][x] = findP(parent[y][x]);
	}
	
	public static boolean union(Node a, Node b) {
		Node pA = findP(a);
		Node pB = findP(b);
		if(pA.equals(pB)) {
			return false;
		}
		else {
			int x = pB.x;
			int y = pB.y;
			parent[y][x] = pA;
			return true;
		}
	}
}