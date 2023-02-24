

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int a;
	int b;
	float cost;
	
	Edge(int a, int b, float cost){
		this.a = a;
		this.b = b;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return Float.compare(this.cost, o.cost);
	}
}


public class Main {

	static int [] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		float [][] stars = new float[N][2];
		StringTokenizer st;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Float.parseFloat(st.nextToken());
			stars[i][1] = Float.parseFloat(st.nextToken());
		}
		
		PriorityQueue<Edge> pq = calculateCost(stars,N);
		
		parents = new int[N];
		
		for(int i=0; i<N;i++) {
			parents[i] = i;
		}
		
		float res = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int a = cur.a;
			int b = cur.b;
			
			if(union(a,b)) res+=cur.cost;
		}
		System.out.println(res);
		
	}
	
	public static PriorityQueue<Edge> calculateCost(float[][] stars, int N){
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i=0; i<N;i++) {
			for(int j=i+1;j<N;j++) {
				float dx = stars[i][0] - stars[j][0];
				float dy = stars[i][1] - stars[j][1];
				
				float cost = (float) Math.sqrt((dx*dx+dy*dy));
				
				pq.offer(new Edge(i,j,cost));
				
			}
		}
		
		return pq;
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


