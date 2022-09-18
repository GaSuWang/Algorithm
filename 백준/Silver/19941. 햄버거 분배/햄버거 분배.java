import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	char[]arr = new char[N];
    	arr = br.readLine().toCharArray();
    	int res = 0;
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i]=='P') {
    			for(int j=i-K<0?0:i-K;j<=(i+K>=N?N-1:i+K);j++) {
    				if(arr[j]=='H') {
    					res++;
    					arr[j] = 'E';
    					break;
    				}
    			}
    		}
    	}
    	System.out.println(res);
    }
}