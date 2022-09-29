import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	int check[] = new int[n];
    	boolean map[][] = new boolean[n][n];
    	for(int i=0; i<m;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken())-1;
    		int b = Integer.parseInt(st.nextToken())-1;
    		map[a][b] = true;
    		map[b][a] = true;
    	}
    	for(int i=1;i<n;i++) {
    		if(map[0][i]) check[i] = 1;
    	}
    	for(int i=1;i<n;i++) {
    		if(check[i]!=1) continue;
    		for(int j=1;j<n;j++) {
    			if(check[j]!=0) continue;
    			if(map[i][j]) check[j] =2;
    		}
    	}
    	int res=0;
    	for(int i=0; i<n;i++) {
    		if(check[i]==0) continue;
    		res++;
    	}
    	System.out.println(res);
    }
}