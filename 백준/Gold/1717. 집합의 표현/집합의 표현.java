import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int parents[];
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	parents = new int[N+1];
    	for(int i=0; i<N+1;i++) {
    		parents[i] = i;
    	}
    	for(int i=0; i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int flag = Integer.parseInt(st.nextToken());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		if(flag==0) {
    			union(a,b);
    		}
    		else {
    			if(findSet(a) == findSet(b)){
    				System.out.println("YES");
    			}
    			else {
    				System.out.println("NO");
    			}
    		}
    	}
    }
    public static int findSet(int target) {
    	if(parents[target]==target) return target;
    	return parents[target] = findSet(parents[target]);
    }
    public static void union(int a, int b) {
    	if(findSet(a)==findSet(b)) return;
    	parents[findSet(b)] = a;
    } 
}