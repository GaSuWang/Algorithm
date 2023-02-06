import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();

		int N1 = str1.length();
		int N2 = str2.length();
		if(N1>N2) {
			int temp = N1;
			N1 = N2;
			N2 = temp;
			String tempInput = str1;
			str1=str2;
			str2 = tempInput;
			
		}
		char []input1 = str1.toCharArray();
		char []input2 = str2.toCharArray();
		int [][] map = new int[N1+1][N2+1];
		int res = 0;
		for(int i=1; i<=N1;i++) {
			for(int j=1;j<=N2;j++) {
				if(input1[i-1]==input2[j-1]) {
					map[i][j] = map[i-1][j-1]+1;
					res=Math.max(res,map[i][j]);
				}
				
			}
		}
		System.out.println(res);
	}

}
