package codechallenge;

import online.cod.L2Arrays;
import online.cod.L3TimeComplexity;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)

public class CodeChallengeBmarks {

    public static void main(String... args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void bmarkL2ArraysSoln2(){
        int[] testArray = {9, 3, 9, 3, 9, 7, 9};
        L2Arrays l2Arrays = new L2Arrays();
        l2Arrays.oddOccurSolution1(testArray);
    }

    @Benchmark
    public void bmarkL2ArraysSoln3(){
        int[] testArray = {9, 3, 9, 3, 9, 7, 9};
        L2Arrays l2Arrays = new L2Arrays();
        l2Arrays.oddOccurSolution2(testArray);
    }
    @Benchmark
    public void bmarkL2ArraysSoln4(){
        int[] testArray = {9, 3, 9, 3, 9, 7, 9};
        L2Arrays l2Arrays = new L2Arrays();
        l2Arrays.oddOccurSolution3(testArray);
    }

    @Benchmark
    public void bmarkL2ArraysSoln5(){
        int[] testArray = {9, 3, 9, 3, 9, 7, 9};
        L2Arrays l2Arrays = new L2Arrays();
        l2Arrays.oddOccurSolution4(testArray);
    }

    @Benchmark
    public void bmarkTapeEquilibriumSolution1(){
        int[] testArray = {3, 1, 2, 4, 3};
        L3TimeComplexity l3 = new L3TimeComplexity();
        l3.tapeEquilibriumSolution1(testArray);
    }
    @Benchmark
    public void bmarkTapeEquilibriumSolution2(){
        int[] testArray = {3, 1, 2, 4, 3};
        L3TimeComplexity l3 = new L3TimeComplexity();
        l3.tapeEquilibriumSolution2(testArray);
    }

}
