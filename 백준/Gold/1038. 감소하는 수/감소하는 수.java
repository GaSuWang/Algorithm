import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int res_count;
	static long res_num;
	static int N;
	public static void main(String[] args) throws IOException {
		// 입력받기 1 2 3 4 5 6 7 8 9 10 20 21 30 31 32 40 41 42 43
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

			res_num = -1;
			if(N<10) {
				System.out.println(N);
				return;
				//continue;
			}
			res_count = 9;
			for(int i =2;i<=10;i++) {
				if(res_count >= N) break;
				if(N>1000000) break;
				dfs(0,i,10,0);
			}
			System.out.println(res_num);

						
	}

	private static void dfs(int count, int num_count, int max,long num) {
		if(count == num_count) {
			res_count++;
			if(res_count==N) {
				res_num = num;
			}
			return;
		}
		
		for(int i=count==0?1:0;i<max;i++) {
			dfs(count+1,num_count,i,(long)(num+i*Math.pow(10, num_count-count-1)));
		}
		
	}
}
                                        