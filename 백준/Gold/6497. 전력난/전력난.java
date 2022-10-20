import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Edge implements Comparable<Edge>{
    int v1,v2,len;
    
    Edge(int v1, int v2, int len){
        this.len = len;
        this.v1 = v1;
        this.v2 = v2;
    }
    
    @Override
    public int compareTo(Edge o1) {
        // TODO Auto-generated method stub
        return Integer.compare(this.len, o1.len);
    }
}

public class Main {
    public static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            PriorityQueue <Edge> pq = new PriorityQueue<>();
            if(N==0&&M==0) break;
            parents = new int[M];
            for(int i=0; i<M;i++) {
                parents[i] = i;
            }
            long total = 0;
            long res = 0;
            for(int i=0; i<N;i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());
                total += len;
                pq.offer(new Edge(v1,v2,len));
            }
            int cnt = 0;
            while(!pq.isEmpty()) {
                Edge cur = pq.poll();
                if(findSet(cur.v1)==findSet(cur.v2)) continue;
                res += cur.len;
                union(cur.v1,cur.v2);
                cnt++;
                if(cnt == N-1) {
                    break;
                }
            }
            System.out.println(total-res);
        }

    }
    
    static int findSet(int target) {
        if(parents[target]==target) return target;
        return parents[target] = findSet(parents[target]);
    }
    
    static void union(int a, int b) {
        parents[findSet(b)] = findSet(a);
    }

}