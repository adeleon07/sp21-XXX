package timingtest;
import edu.princeton.cs.algs4.Stopwatch;


/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        int N = 1000;
        int Limit = 50000;
        int M = 10000;


        AList<Integer> N_count = new AList<>();
        AList<Double> time = new AList<>();
        AList<Integer> ops = new AList<>();

        while (N <= Limit) {
            SLList<Integer> TestList = new SLList<>();

            for (int i = 0; i <= N; i++) {
                TestList.addLast(i);
            }

            Stopwatch sw = new Stopwatch();
            for (int j = 0; j <= M; j++) {
                TestList.getLast();
            }
            N_count.addLast(N);
            time.addLast(sw.elapsedTime());
            ops.addLast(M);

            N *= 2;
        }
        printTimingTable(N_count, time, ops);
    }
}
