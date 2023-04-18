import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Item{
	long s;
	String str;
	
	Item(int s, String str){
		this.s = s;
		this.str = str;
	}
}



public class Main {
	static String res;
	static boolean [] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		check = new boolean[Math.max(S,T)+1];
		if(S==T) {
			System.out.println(0);
			return;
		}
		if(T==0) {
			System.out.println('-');
			return;
		}
		res="";
		bfs(S,T);
		res = res.equals("") ? "-1" : res;
		System.out.println(res);
		
	}
	
	public static void bfs(int s, int t) {
		Queue<Item> queue = new LinkedList<Item>();
		queue.offer(new Item(s,""));
		boolean flag = true;
		check[s] = true;
		while(!queue.isEmpty()) {
			Item cur = queue.poll();
			
			if(cur.s*cur.s<=t&&!check[(int) (cur.s*cur.s)]) {
				if(cur.s*cur.s==t) {
					res = cur.str+"*";
					return;
				}
				check[(int) (cur.s*cur.s)] = true;
				queue.offer(new Item((int) (cur.s*cur.s),cur.str+"*"));
			}
			if(cur.s+cur.s<=t&&!check[(int) (cur.s+cur.s)]) {
				if(cur.s+cur.s==t) {
					res = cur.str+"+";
					return;
				}
				check[(int) (cur.s+cur.s)] = true;
				queue.offer(new Item((int) (cur.s+cur.s),cur.str+"+"));
			}
			if(flag) {
				if(t==1) {
					res = "/";
					return;
				}
				flag = false;
				check[1] = true;
				queue.offer(new Item(1,"/"));
			}
			
		}
	}
}
