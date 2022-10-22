import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



class Data implements Comparable<Data>{
	int v,w;
	
	Data(int v, int w){
		this.v = v;
		this.w = w;
				
	}
	
	@Override
	public int compareTo(Data o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.w, o.w);
	}
	
}

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int V = Integer.parseInt(st.nextToken());
    	int E = Integer.parseInt(st.nextToken());
    	//int map[][] = new int[V][V];
    	List<int[]> [] list = new List[V];
//    	Arrays.fill(list, new ArrayList<int[]>());
    	boolean check[] = new boolean[V];
//    	int minEdges[] = new int [V];
    	PriorityQueue <Data> pq = new PriorityQueue<Data>();
    	for(int i=0; i<E;i++) {
    		st = new StringTokenizer(br.readLine());
    		int v1 = Integer.parseInt(st.nextToken())-1;
    		int v2 = Integer.parseInt(st.nextToken())-1;
    		int len = Integer.parseInt(st.nextToken());
            if(list[v1]==null) {
    			list[v1] = new ArrayList<int[]>();
    		}
    		if(list[v2]==null) {
    			list[v2] = new ArrayList<int[]>();
    		}
    		list[v1].add(new int[] {v2,len});
    		list[v2].add(new int[] {v1,len});
//    		map[v1][v2] = len;
//  		map[v2][v1] = len;
    	}
    	
//   	Arrays.fill(minEdges,Integer.MAX_VALUE);
    	int res = 0;
//    	minEdges[0] = 0;
//    	for(int i=0; i<V;i++) {
//    		int minEdge = Integer.MAX_VALUE;
//    		int minVertex=-1;
    	
//    		for(int j=0; j<V;j++) {
//    			if(check[j]) continue;
//    			if(minEdge > minEdges[j]) {
//    				minVertex = j;
//    				minEdge = minEdges[j];
//    			}
//    		}
    	int cnt = 0;
    	pq.offer(new Data(0,0));
    	while(!pq.isEmpty()) {
//    		check[minVertex] = true;
//    		for(int j=0; j<list[minVertex].size();j++) {
//    			int [] cur = list[minVertex].get(j);
//    			if(check[cur[0]]) continue;
//    			if(cur[1]<minEdges[cur[0]]) minEdges[cur[0]] = cur[1];
//    			if(check[j]||map[minVertex][j]==0)continue;
//    			if(map[minVertex][j]<minEdges[j]) {
//    				minEdges[j] = map[minVertex][j];
//    			}
//    		}
    		
    		Data cur = pq.poll();
    		if(check[cur.v]) continue;
    		res += cur.w;
    		check[cur.v] = true;
    		cnt++;
    		if(cnt==V) {
    			break;
    		}
    		for(int j=0; j<list[cur.v].size();j++) {
    			if(check[list[cur.v].get(j)[0]]) continue;
    			pq.offer(new Data(list[cur.v].get(j)[0],list[cur.v].get(j)[1]));
    		}
    	}
    	System.out.println(res);	
    }
}