package codechallenge;

import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import online.cod.L5PrefixSums;
import online.cod.L6Sorting;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class L6SortingBmarks {

    public static void main(String... args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @State(Scope.Thread)
    static public class StateS6 {
        int[] intArray1;
        int[] intArray2;

        public StateS6() {
//            IntStream intStream1 = IntStream.rangeClosed(0, 10_000);
            IntStream intStream1 = new Random().ints(10_000,
                    0, 2_147_483_647);
            IntStream intStream2 = new Random().ints(100_000,
                    -10, 0);
            this.intArray1 = intStream1.toArray();
            this.intArray2 = intStream2.toArray();
        }
    }

    @Benchmark
    public void bmarkNumberOfDiscIntersections1(Blackhole blackhole, StateS6 stateS6){
        L6Sorting l6 = new L6Sorting();
        int retVal = l6.numberOfDiscIntersections1(stateS6.intArray1);
        blackhole.consume(retVal);
    }

    @Benchmark
    public void bmarkNumberOfDiscIntersections2(Blackhole blackhole, StateS6 stateS6){
        L6Sorting l6 = new L6Sorting();
        int retVal = l6.numberOfDiscIntersections2(stateS6.intArray1);
        blackhole.consume(retVal);
    }
    @Benchmark
    public void bmarkNumberOfDiscIntersections3(Blackhole blackhole, StateS6 stateS6){
        L6Sorting l6 = new L6Sorting();
        int retVal = l6.numberOfDiscIntersections3(stateS6.intArray1);
        blackhole.consume(retVal);
    }

    @Benchmark
    public void bmarkNumberOfDiscIntersections4(Blackhole blackhole, StateS6 stateS6){
        L6Sorting l6 = new L6Sorting();
        int retVal = l6.numberOfDiscIntersections4(stateS6.intArray1);
        blackhole.consume(retVal);
    }
    @Benchmark
    public void bmarkNumberOfDiscIntersections5(Blackhole blackhole, StateS6 stateS6){
        L6Sorting l6 = new L6Sorting();
        int retVal = l6.numberOfDiscIntersections5(stateS6.intArray1);
        blackhole.consume(retVal);
    }


    @Benchmark
    public void bmarkTriangles1(Blackhole blackhole, StateS6 stateS6){
        L6Sorting l6 = new L6Sorting();
        int retVal = l6.triangle1(stateS6.intArray2);
        blackhole.consume(retVal);
    }

    @Benchmark
    public void bmarkTriangles2(Blackhole blackhole, StateS6 stateS6){
        L6Sorting l6 = new L6Sorting();
        int retVal = l6.triangle2(stateS6.intArray2);
        blackhole.consume(retVal);
    }

}
