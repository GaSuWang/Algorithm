import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Data implements Comparable<Data>{
	int v;
	int cost;
	Data(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Data o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost,o.cost);
	}
}

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int map[][] = new int [N][N];
    	StringTokenizer st = null;
    	for(int i=0; i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	PriorityQueue<Data> pq = new PriorityQueue<Data>();
    	long res = 0;
    	pq.offer(new Data(0,0));
    	boolean check[] = new boolean[N];
    	int cnt = 0;
    	while(!pq.isEmpty()) {
    		Data cur = pq.poll();
    		if(check[cur.v]) continue;
    		cnt++;
    		res += cur.cost;
    		check[cur.v] = true;
    		if(cnt == N) {
    			break;
    		}
    		for(int i=0; i<N;i++) {
    			if(check[i]) continue;
    			if(map[cur.v][i]==0) continue;
    			pq.offer(new Data(i,map[cur.v][i]));
    		}
    	}
    	System.out.println(res);
    	
    }
    
}
