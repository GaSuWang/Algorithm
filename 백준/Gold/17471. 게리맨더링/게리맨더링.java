import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int [] parents;
	static int sum1;
	static int sum2;
	static int N;
	static int pop[];
	static int map[][];
	static boolean check[];
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		pop = new int[N];
		map = new int[N][N];
		check = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		parents = new int[N];
		res = 10000;
		
		for(int i=0; i<N;i++) {
			//parents[i] = i;
			pop[i] = Integer.parseInt(st.nextToken());	
		}

		int num;
		int index;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			index = 0;
			for(int j=0; j<num;j++) {
				
				index = Integer.parseInt(st.nextToken())-1;
				//union(i,index);
				map[i][index] = 1;
			}
		}
//		int region = 0;
//		int [] regionNum = new int [3];
//		Arrays.fill(regionNum, -1);
//		regionNum[0] = findSet(0);
//		outer: for(int i=1;i<N;i++) {
//			for(int j=0;j<3;j++) {
//				if(regionNum[j]==findSet(i)) continue outer;
//				region++;
//				if(region>1) {
//					System.out.println(-1);
//					return;
//				}
//				regionNum[region] = findSet(i);
//			}
//		}
//		sum1=0;
//		sum2 = 0;
//		if(region==1) {
//			for(int i=0; i<N;i++) {
//				if(findSet(i)==regionNum[0]) sum1+=pop[i];
//				else sum2 += pop[i];
//			}
//			System.out.println(Math.abs(sum1-sum2));
//			return;
//		}
//		else {
			//도시 조합 찾아
			dfs(0);
			//그다음 연결되어있는지 확인
			//연결 안되면 말고, 연결되면 계산
			System.out.println(res==10000?-1:res);
//		}
		
		
	}
	public static void dfs(int num) {
		if(num==N) {
			//System.out.println(Arrays.toString(check));
			if(bfs(true)&&bfs(false)) {
				res = Math.min(res, Math.abs(sum1-sum2));
			}
			return;
		}
		
		dfs(num+1);
		check[num] = true;
		dfs(num+1);
		check[num] = false;
	}
	public static boolean bfs(boolean flag) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt = 0;
		for(int i=0; i<N;i++) {
			if(check[i]==flag) cnt++;
		}
		if(cnt==0) return false;
		boolean tempCheck[] = Arrays.copyOf(check, N);
		for(int i=0; i<N;i++) {
			if(check[i]==flag) {
				queue.offer(i);
				tempCheck[i] = !flag;
				break;
			}
		}
		
		int tempSum = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			tempSum += pop[cur];
			for(int i=0; i<N;i++) {
				if(map[cur][i]==0) continue;
				if(tempCheck[i] !=flag) continue;
				tempCheck[i] = !flag;
				queue.offer(i);
			}
		}
		for(int i=0; i<N;i++) {
			if(tempCheck[i]==flag) return false;
		}
		if(flag) sum1 = tempSum;
		else sum2 = tempSum;
		return true;
	}
	
	public static int findSet(int target) {
		if(parents[target]==target) return target;
		return parents[target] = findSet(parents[target]);
	}
	
	public static void union(int a, int b) {
		int pA = findSet(a);
		int pB = findSet(b);
		if(pA==pB) return;
		parents[pB] = pA;
	}
}
