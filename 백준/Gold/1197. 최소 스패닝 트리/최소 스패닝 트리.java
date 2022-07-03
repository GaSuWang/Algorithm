import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}
	
	static int p[];
	static int vn;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vn = Integer.parseInt(st.nextToken());
		int en = Integer.parseInt(st.nextToken());
		Edge [] arr = new Edge[en];
		for(int i=0;i<en;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			arr[i] = new Edge(start, end, weight);
		}
		Arrays.sort(arr);
		makeSet();
		int res = 0;
		int cnt = 0;
		for(Edge edge : arr) {
			if(unionSet(edge.start, edge.end)) {
				cnt++;
				res+=edge.weight;
			}
			if(cnt == vn-1) {
				break;
			}
		}
		System.out.println(res);
		
	}
	 static boolean unionSet(int a, int b) {
	        a = findSet(a);
	        b = findSet(b);
	        if(a == b) {
	            return false;
	        }
	        p[b] = a; 
	        return true;
	    }
	    

	    static int findSet(int a) {
	        if(a == p[a]) { 
	            return a;
	        }
	        p[a] = findSet(p[a]); 
	        return p[a]; 
	    }

	    static void makeSet() {
	        p = new int[vn];
	        for(int i =0; i < vn; i++) {
	            p[i] = i;
	        }
	    }

}
