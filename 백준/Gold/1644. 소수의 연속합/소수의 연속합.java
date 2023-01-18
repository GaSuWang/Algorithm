
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> prime = findPrime(N);
		if(prime.size()==0||N==1) {
			System.out.println(0);
			return;
		}
		int start=0;
		int end=1;
		int num = prime.get(0);
		int res = prime.get(prime.size()-1)==N?1:0;
		while(end<prime.size()&&start<=end) {
			if(num<N) {
				num+=prime.get(end);
				end++;
			}
			else if(num>N) {
				num-=prime.get(start);
				start++;
			}
			else {
				res++;
				if(end<N-1) {
					num+=prime.get(end);
					end++;
				}
				else {
					num-=prime.get(start);
					start++;
				}
				
			}
		}
		System.out.println(res);
	}
	public static List<Integer> findPrime(int N){
		List<Integer> res =new ArrayList<Integer>();
		outer: for(int i=2;i<=N;i++) {
			for(int j=2;j*j<=i;j++) {
				if(i!=j&&i%j==0) continue outer;
			}
			res.add(i);
		}
		return res;
	}
	
}