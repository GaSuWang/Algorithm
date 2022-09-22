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
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	int m =Integer.parseInt(br.readLine());
    	int ten = 0;
    	st = new StringTokenizer(br.readLine());
    	for(int i=m-1; i>=0; i--) {
    		ten += Integer.parseInt(st.nextToken())*Math.pow(A,i);
    	}
    	StringBuilder sb = new StringBuilder();
    	
    	while(ten>0) {
    		sb.insert(0, ten%B);
    		sb.insert(0," ");
    		ten = ten/B;
    	}
    	System.out.println(sb.toString().trim());
    }
}