import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int num[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t =0;;t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			num = new int [n];
			for(int i=0 ; i<n;i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			combi(0,0,"");
			System.out.println();
		}
		
	}	
	private static void combi(int start, int count,String res) {
		if(count == 6) {
			System.out.println(res);
			return;
		}
		for(int i= start; i<n;i++) {
			combi(i+1,count+1,res+num[i]+" ");
		}
		return;
	}
		
		
	

}
