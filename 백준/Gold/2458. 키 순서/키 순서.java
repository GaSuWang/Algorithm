import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int MAX = 5000;
        int [][] map = new int[N][N];
        for(int i=0; i<N;i++){
            Arrays.fill(map[i],MAX);
        }
        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken())-1;
            int tall = Integer.parseInt(st.nextToken())-1;
            map[small][tall] = 1;
        }

        for(int k=0; k<N;k++){
            for(int i=0; i<N;i++){
                if(i==k) continue;
                for(int j=0;j<N;j++){
                    if(j==i) continue;
                    map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        int res=0;
        outer: for(int i=0; i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(map[i][j]==MAX&&map[j][i]==MAX) continue outer;
            }
            res++;
        }
        System.out.println(res);

    }
}