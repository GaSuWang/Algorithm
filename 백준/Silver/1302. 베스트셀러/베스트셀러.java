import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0; i<N;i++) {
			String input = br.readLine();
			if(map.containsKey(input)) {
				map.put(input, map.get(input)+1);
			}
			else {
				map.put(input,1);
			}
		}
		int res = 0;
		String resString = "";
		for(String key : map.keySet()) {
			if(res<map.get(key)) {
				resString = key;
				res = map.get(key);
			}
			else if(res==map.get(key)) {
				if(resString.compareTo(key)>0) {
					resString=key;
				}
			}
		}
		System.out.println(resString);
	}

}
