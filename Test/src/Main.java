import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] answer;
    static int cnt;

    public static void dfs(int v) {
        answer[v] = cnt;
        for (int next_v: graph.get(v)) {
            if (answer[next_v] == 0) {
                cnt += 1;
                dfs(next_v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        N = Integer.parseInt(inp[0]);
        M = Integer.parseInt(inp[1]);
        R = Integer.parseInt(inp[2]);

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        answer = new int[N + 1];
        Arrays.fill(answer, 0);

        for (int i = 0; i < M; i++) {
            String l = br.readLine();
            StringTokenizer st = new StringTokenizer(l);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < graph.size(); i ++) {
            Collections.sort(graph.get(i));
        }

        cnt = 1;
        dfs(R);

        for (int i =1; i < answer.length; i ++) {
            System.out.println(answer[i]);
        }
    }
}