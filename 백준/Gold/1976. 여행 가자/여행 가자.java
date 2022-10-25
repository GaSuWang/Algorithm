import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	static int [] parents;
    public static void main(String[] args) throws IOException {
    	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	StringTokenizer st = null;
    	parents = new int[N];
    	for(int i=0; i<N;i++) {
    		parents[i] = i;
    	}
    	for(int i=0; i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<N;j++) {
    			if(Integer.parseInt(st.nextToken())==1) {
    				union(i,j);
    			}
    		}
    	}
    	String [] plan = br.readLine().split(" ");
    	int planGroup = findSet(Integer.parseInt(plan[0])-1);
    	
    	for(int i=1;i<plan.length;i++) {
    		if(planGroup!=findSet(Integer.parseInt(plan[i])-1)) {
    			System.out.println("NO");
    			return;
    		}
    	}
    	System.out.println("YES");
    	
    	
    	
    }
    public static int findSet(int target) {
    	if(parents[target]==target) return target;
    	return parents[target] =  findSet(parents[target]);
    }
    public static void union(int a, int b) {
    	int pA = findSet(a);
    	int pB = findSet(b);
    	if(pA == pB) return;
    	parents[pB] = pA;
    	return;
    }
    
}