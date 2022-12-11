import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		double pack = 10000;
		double one = 10000;
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			pack = Math.min(pack,Double.parseDouble(st.nextToken()));
			one = Math.min(one, Double.parseDouble(st.nextToken()));
		}
		double res = 100000;
		int packCount = N/6;
		res = Math.min(res,pack*(packCount+1));
		res = Math.min(res, one*N);
		res = Math.min(res,pack*packCount + one*(N%6));
		System.out.println((int)res);
	}
}