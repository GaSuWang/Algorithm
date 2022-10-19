////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int [] price;
	static int [] parents;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	parents = new int[N];
    	price = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N;i++) {
    		price[i] = Integer.parseInt(st.nextToken());
    	}
    	makeSet();
    	for(int i=0; i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken())-1; 
    		int b = Integer.parseInt(st.nextToken())-1;
    		union(a,b);
    	}
    	int res =0;
    	boolean check[] = new boolean[N];
    	for(int i=0; i<N;i++) {
    		if(check[findSet(i)]) continue;
    		res += price[findSet(i)];
    		check[findSet(i)] = true;
    	}
    	if(res>K) {
    		System.out.println("Oh no");
    	}
    	else {
    		System.out.println(res);
    	}
    }
    

    
    
    public static void makeSet() {
    	for(int i=0; i<parents.length;i++) {
    		parents[i] = i;
    	}
    }
    
    public static void union(int a, int b) {
    	int aParent = findSet(a);
    	int bParent = findSet(b);
    	if(aParent == bParent) return;
    	if(price[aParent]<=price[bParent]) {
    		parents[bParent] = aParent;
    	}
    	else {
    		parents[aParent] = bParent;
    	}
    	
    		
    	
    }
    public static int findSet(int target) {
    	if(parents[target]==target) return target;
    	return parents[target] = findSet(parents[target]);
    	
    }
}