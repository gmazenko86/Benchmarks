package codechallenge;

import online.cod.L4CountingElements;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class L4CountingElementsBm {

    public static void main(String... args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
    @Benchmark
    public void bmarkFrogRiverSolution1(){
        int jumps = 5; int[] leaves = {1,3,1,4,2,3,5,4};
        L4CountingElements l4 = new L4CountingElements();
        l4.frogRiverSolution1(jumps, leaves);
    }

    @Benchmark
    public void bmarkFrogRiverSolution2(){
        int jumps = 5; int[] leaves = {1,3,1,4,2,3,5,4};
        L4CountingElements l4 = new L4CountingElements();
        l4.frogRiverSolution2(jumps, leaves);
    }

    @Benchmark
    public void bmarkMaxCountersSolution1(){
        int numCounters = 5; int[] L4_1 = {3,4,4,6,1,4,4};
        L4CountingElements l4 = new L4CountingElements();
        l4.maxCountersSolution1(numCounters, L4_1);
    }

    @Benchmark
    public void bmarkMaxCountersSolution2(){
        int numCounters = 5; int[] L4_2 = {3,4,4,6,1,4,4};
        L4CountingElements l4 = new L4CountingElements();
        l4.maxCountersSolution2(numCounters, L4_2);
    }

    @Benchmark
    public void bmarkMaxCountersSolution3(){
        int numCounters = 5; int[] L4_3 = {3,4,4,6,1,4,4};
        L4CountingElements l4 = new L4CountingElements();
        l4.maxCountersSolution3(numCounters, L4_3);
    }

    @Benchmark
    public void bmarkMaxCountersSolution5(){
        int numCounters = 5; int[] L4_5 = {3,4,4,6,1,4,4};
        L4CountingElements l4 = new L4CountingElements();
        l4.maxCountersSolution5(numCounters, L4_5);
    }

    @Benchmark
    public void bmarksetAllMax(){
        int[] counters = {1,2,3,4,5,6,7,8,9};
        L4CountingElements l4 = new L4CountingElements();
        l4.setAllMax(counters);
    }
}
