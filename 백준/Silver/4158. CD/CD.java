import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		HashMap<String,String> map =null;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N==0&&M==0) break;
			map = new HashMap<>();
			int res=0;
			for(int i=0;i<N;i++) {
				map.put(br.readLine(), "a");
			}
			for(int i=0;i<M;i++) {
				if(map.get(br.readLine())==null) continue;
				res++;
			}
			System.out.println(res);
		}
	}
	
	
}