import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String [] in = new String[N];
		String [] out = new String[N];
		int res = 0;
		for(int i=0;i<N;i++) {
			in[i] = br.readLine();
		}
		for(int i=0;i<N;i++) {
			out[i] = br.readLine();
		}
		int beforeIndex= -1;
		String targetCar;
		for(int i=0;i<N;i++) {
			if(out[i].equals(in[i])) continue;
			res ++;
			for(int j=i+1;j<N;j++) {
				if(out[i].equals(in[j])) {
					beforeIndex = j;
					break;
				}
			}
			targetCar = out[i];
			for(int j = beforeIndex;j>i;j--) {
				in[j] = in[j-1];
			}
			in[i] = targetCar;
		}
		System.out.println(res);
	}

}