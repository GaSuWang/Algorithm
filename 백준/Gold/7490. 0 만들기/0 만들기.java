
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static List<String> res;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			res = new ArrayList<String>();
			dfs(0, "1", 1);
			Collections.sort(res);
			for(int i=0; i<res.size();i++) {
				System.out.println(res.get(i));
			}
			System.out.println();
		}
		
	}

	static void dfs(int num, String resStr, int curNum) {
		if (num == N) {
			// resStr.replace(" ", "");
			// res.add(resStr);
			String tempStr = resStr;
			tempStr=tempStr.replace("/", "");
			String[] arr = tempStr.split(" ");

			int temp = Integer.parseInt(arr[0]);
			for (int i = 1; i < arr.length-1; i++) {
				if (arr[i].equals("+")) {
					temp += Integer.parseInt(arr[i + 1]);
				} else if (arr[i].equals("-")) {
					temp -= Integer.parseInt(arr[i+1]);
				}
			}
			if (temp == 0) {
				res.add(resStr.replace(" ", "").replace("/", " "));
			}
			return;
		}
		if (curNum == 1) {
			dfs(num + 1, resStr, curNum + 1);
		} else {
			// 더하기
			dfs(num + 1, resStr + " + " + curNum, curNum + 1);
			// 빼기
			dfs(num + 1, resStr + " - " + curNum, curNum + 1);
			// 공백
			dfs(num + 1, resStr + "/" + curNum, curNum + 1);
		}
	}
}
