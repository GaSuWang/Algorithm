////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean check[][]= new boolean[A+B+C][A+B+C];
		Queue<int []> queue = new LinkedList<int[]>();
		queue.offer(new int[] {A,B,C});
		check[A][B] = true;
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			//A , B
			if(cur[0]==cur[1]&&cur[1]==cur[2]) {
				System.out.println(1);
				return;
			}
			int max,min;
			if(cur[0]!=cur[1]) {
				if(cur[0]>cur[1]) {
					max = cur[0]-cur[1];
					min = cur[1]+cur[1];
					if(!check[max][min]) {
						check[max][min] = true;
						queue.offer(new int[] {max,min,cur[2]});
					}
				}
				if(cur[1]>cur[0]) {
					max = cur[1]-cur[0];
					min = cur[0]+cur[0];
					if(!check[min][max]) {
						check[min][max] = true;
						queue.offer(new int[] {min,max,cur[2]});
					}
				}
			}
			//A, C
			if(cur[0]!=cur[2]) {
				if(cur[0]>cur[2]) {
					max = cur[0]-cur[2];
					min = cur[2]+cur[2];
					if(!check[max][min]) {
						check[max][min] = true;
						queue.offer(new int[] {max,cur[1],min});
					}
				}
				if(cur[2]>cur[0]) {
					max = cur[2]-cur[0];
					min = cur[0]+cur[0];
					if(!check[min][max]) {
						check[min][max] = true;
						queue.offer(new int[] {min,cur[1],max});
					}
				}
			}
			//B, C
			if(cur[1]!=cur[2]) {
				if(cur[1]>cur[2]) {
					max = cur[1]-cur[2];
					min = cur[2]+cur[2];
					if(!check[max][min]) {
						check[max][min] = true;
						queue.offer(new int[] {cur[0],max,min});
					}
				}
				if(cur[2]>cur[1]) {
					max = cur[2]-cur[1];
					min = cur[1]+cur[1];
					if(!check[min][max]) {
						check[min][max] = true;
						queue.offer(new int[] {cur[0],min,max});
					}
				}
			}
		}
		System.out.println(0);
	}
}