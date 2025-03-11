public class EX2 {
    public static String SMatrix(int g[][], int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(g[i][j] == 1 ? " \u25A0 " : " \u25CF ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[]) {
        if (args.length != 2) {
            System.err.println("java EX2 <number1> <number2>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int[] d = new int[n];
        int[][] g = new int[n][n];

        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                g[i][j] = (Math.random() < 0.5) ? 0 : 1;
                g[j][i] = g[i][j];
            }
        }

        long end = System.nanoTime();

        if (n <= 30_000) {
            System.out.println(SMatrix(g, n));
        } else {
            System.out.println((end - start) / 1_000_000 + " ms");
        }

        int m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (g[i][j] != 0) m++;
            }
        }

        System.out.println("Number of edges: m=" + m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != 0) {
                    d[i]++;
                }
            }
        }

        int s = 0;
        int dmin = Integer.MAX_VALUE;
        int dmax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            s += d[i];
            dmin = Math.min(dmin, d[i]);
            dmax = Math.max(dmax, d[i]);
        }

        System.out.println("\u0394(G) = " + dmax);
        System.out.println("\u03B4(G) = " + dmin);

        if (s == 2 * m) {
            System.out.println("s = 2 * m");
        } else {
            System.out.println("s != 2 * m");
        }
    }
}
