
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Data{
		char[] num;
		int count;
		Data(char[] num, int count){
			this.num = num;
			this.count=count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		outer: for(int t=0; t<T;t++) {
			st = new StringTokenizer(br.readLine());
			String from = st.nextToken();
			String to = st.nextToken();
			Queue<Data> queue = new LinkedList<>();
			boolean check[] = new boolean[10000];
			check[Integer.parseInt(from)] = true;
			queue.offer(new Data(from.toCharArray(),0));
			
			while(!queue.isEmpty()) {
				Data cur = queue.poll();
				if(String.valueOf(cur.num).equals(to)) {
					System.out.println(cur.count);
					continue outer;
				}
				for(int i=0;i<4;i++) {
					for(int j=0;j<10;j++) {
						char [] next = cur.num.clone();
						next[i] = (char)('0'+j);
						if(!checkPrime(next,check)) continue;
						queue.offer(new Data(next,cur.count+1));
						check[Integer.parseInt(String.valueOf(next))] = true;
					}
				}
			}
			System.out.println("Impossible");
			
		}
	}
	public static boolean checkPrime(char[] target, boolean[]check) {
		int targetInt = Integer.parseInt(String.valueOf(target));
		if(check[targetInt]||targetInt<1000) return false;
		for(int i=2; i*i<=targetInt;i++) {
			if(targetInt%i==0) return false;
		}
		return true;
	}
}