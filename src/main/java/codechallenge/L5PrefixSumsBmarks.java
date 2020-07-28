package codechallenge;

import online.cod.L5PrefixSums;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class L5PrefixSumsBmarks {

    public static void main(String... args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void bmarkGenomicRangeSolution1(Blackhole blackhole){
        L5PrefixSums l5 = new L5PrefixSums();
        String str1 = "ACGTACGTACGTACGTACGTACGT";
        int[] P1 = {5,10,15}; int[] Q1 = {23,18,15};
        int[] retArray = l5.genomicRangeSolution1(str1, P1, Q1);
        blackhole.consume(retArray);
    }

    @Benchmark
    public void bmarkGenomicRangeSolution2(Blackhole blackhole){
        L5PrefixSums l5 = new L5PrefixSums();
        String str1 = "ACGTACGTACGTACGTACGTACGT";
        int[] P1 = {5,10,15}; int[] Q1 = {23,18,15};
        int[] retArray = l5.genomicRangeSolution2(str1, P1, Q1);
        blackhole.consume(retArray);
    }

    @Benchmark
    public void bmarkGenomicRangeSolution3(Blackhole blackhole){
        L5PrefixSums l5 = new L5PrefixSums();
        String str1 = "ACGTACGTACGTACGTACGTACGT";
        int[] P1 = {5,10,15}; int[] Q1 = {23,18,15};
        int[] retArray = l5.genomicRangeSolution3(str1, P1, Q1);
        blackhole.consume(retArray);
    }

    @Benchmark
    public void bmarkGenomicRangeSolution4(Blackhole blackhole){
        L5PrefixSums l5 = new L5PrefixSums();
        String str1 = "ACGTACGTACGTACGTACGTACGT";
        int[] P1 = {5,10,15}; int[] Q1 = {23,18,15};
        int[] retArray = l5.genomicRangeSolution4(str1, P1, Q1);
        blackhole.consume(retArray);
    }

    @Benchmark
    public void bmarkGenomicRangeSolution5(Blackhole blackhole){
        L5PrefixSums l5 = new L5PrefixSums();
        String str1 = "ACGTACGTACGTACGTACGTACGT";
        int[] P1 = {5,10,15}; int[] Q1 = {23,18,15};
        int[] retArray = l5.genomicRangeSolution5(str1, P1, Q1);
        blackhole.consume(retArray);
    }

    @Benchmark
    public void bmarkGenomicRangeSolution6(Blackhole blackhole){
        L5PrefixSums l5 = new L5PrefixSums();
        String str1 = "ACGTACGTACGTACGTACGTACGT";
        int[] P1 = {5,10,15}; int[] Q1 = {23,18,15};
        int[] retArray = l5.genomicRangeSolution6(str1, P1, Q1);
        blackhole.consume(retArray);
    }


    @Benchmark
    public void bmarkMinAvgTwoSliceSolution2(Blackhole blackhole){
        L5PrefixSums l5 = new L5PrefixSums();
        int[] L5_3 = {4,2,2,5,1,5,8};
        int retVal = l5.minAvgTwoSliceSolution2(L5_3);
        blackhole.consume(retVal);
    }

    @Benchmark
    public void bmarkMinAvgTwoSliceSolution3(Blackhole blackhole){
        L5PrefixSums l5 = new L5PrefixSums();
        int[] L5_3 = {4,2,2,5,1,5,8};
        int retVal = l5.minAvgTwoSliceSolution3(L5_3);
        blackhole.consume(retVal);
    }

    @Benchmark
    public void bmarkMinAvgTwoSliceSolution4(Blackhole blackhole){
        L5PrefixSums l5 = new L5PrefixSums();
        int[] L5_3 = {4,2,2,5,1,5,8};
        int retVal = l5.minAvgTwoSliceSolution4(L5_3);
        blackhole.consume(retVal);
    }
}
