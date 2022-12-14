import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean [][] check = new boolean[N+2][N+2]; 
		//현재 길이, 시간, 클립보드길이, 복사했는지?
		queue.offer(new int[] {2,2,1});
		check[2][1] = true;
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			if(N==cur[0]) {
				System.out.println(cur[1]);
				return;
			}
			//붙여넣기만
			if(cur[0]+cur[2]<=N+1&&!check[cur[0]+cur[2]][cur[2]]) {
			queue.offer(new int[] {cur[0]+cur[2],cur[1]+1,cur[2]});
				check[cur[0]+cur[2]][cur[2]] = true;
			}
			//복사만
			if(!check[cur[0]][cur[0]]) {
				queue.offer(new int[] {cur[0],cur[1]+1,cur[0]});
				check[cur[0]][cur[0]] = true;
			}
			//-1
			if(cur[0]>2 && !check[cur[0]-1][cur[2]]) {
				queue.offer(new int[] {cur[0]-1,cur[1]+1,cur[2]});
				check[cur[0]-1][cur[2]] = true;
			}
			
		}
	}
}