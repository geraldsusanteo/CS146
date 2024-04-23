import java.util.Arrays;

public class Main {
    private static int[] p;

    public static void main(String[] args) {
        int n = 2;
        int[] wells = {1, 1};
        int[][] pipes = {{1, 2, 1}, {1, 2, 2}};
        if (wells.length == n || 2 <= n || n <= 10000 || 1 <= pipes.length || pipes.length <= 10000) {
            System.out.println(minCostToSupplyWater(n, wells, pipes));
        }
    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        p = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        int[][] allPipes = new int[pipes.length + n][3];
        System.arraycopy(pipes, 0, allPipes, 0, pipes.length);
        for (int i = 0; i < n; i++) {
            allPipes[pipes.length + i] = new int[]{0, i + 1, wells[i]};
        }
        Arrays.sort(allPipes, (a, b) -> a[2] - b[2]);
        int ans = 0;
        for (var x : allPipes) {
            int a = x[0], b = x[1], c = x[2];
            int pa = find(a), pb = find(b);
            if (pa != pb) {
                p[pa] = pb;
                ans += c;
                if (--n == 0) {
                    return ans;
                }
            }
        }
        return ans;
    }

    private static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
