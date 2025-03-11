import java.util.Arrays;
import java.util.Random;

public class EX3 {
    public static int[][] generate_graph(int n, int m) {
        int[][] g = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n && m > 0; i++) {
            for (int j = 0; j < i && m > 0; j++) {
                g[i][j] = random.nextInt(2);
                g[j][i] = g[i][j];
                if (g[i][j] != 0) m--;
            }
        }
        return g;
    }

    public static int[] degrees(int n, int[][] g) {
        int[] dg = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != 0) dg[i]++;
            }
        }
        return dg;
    }

    static int[] x = new int[100];
    static boolean exists = false;

    public static void print_clique(int k) {
        for (int i = 0; i < k; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    public static boolean Ok(int[][] g, int j) {
        for (int i = 0; i < j; i++) {
            if (x[i] == x[j]) return false;
        }
        for (int i = 0; i < j; i++) {
            if (g[x[i]][x[j]] == 0) return false;
        }
        return true;
    }

    public static void find_clique(int n, int[][] g, int[] dg, int k, int j) {
        for (int i = 0; i < n; i++) {
            x[j] = i;
            if (Ok(g, j) && dg[i] >= k - 1) {
                if (j == k - 1 && !exists) {
                    print_clique(k);
                    exists = true;
                    return;
                } else {
                    find_clique(n, g, dg, k, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java EX3 <n> <m> <k>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        System.out.println("n = " + n);
        System.out.println("m = " + m);
        System.out.println("k = " + k);

        int[][] g = generate_graph(n, m);
        int[] dg = degrees(n, g);

        for (int[] row : g) {
            System.out.println(Arrays.toString(row));
        }

        find_clique(n, g, dg, k, 0);
        
        if (!exists) {
            System.out.println("G doesn't have a clique of size at least " + k);
        }
    }
}
