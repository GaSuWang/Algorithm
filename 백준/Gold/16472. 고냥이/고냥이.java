import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		Map<Character,Integer> map = new HashMap<>();
		int left=0;
		int right=0;
		int res = 0;
		int len = 0;
		while(right<str.length) {
			
			Integer cnt = map.get(str[right]);
			if(cnt==null) map.put(str[right], 1);
			else map.put(str[right],cnt+1);
			right++;
			len++;
			while(map.size()>N) {
				int temp = map.get(str[left]);
				map.put(str[left], --temp);
				if(temp==0) map.remove(str[left]);
				left++;
				len--;
			}
			
			res = Math.max(res,len);
		}
		System.out.println(res);
		
	}

}
