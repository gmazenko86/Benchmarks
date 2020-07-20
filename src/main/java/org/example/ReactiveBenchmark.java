package org.example;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static myioutils.MyIOUtils.pauseMilliSec;
import static myioutils.MyIOUtils.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class ReactiveBenchmark {

    @State(Scope.Thread)
    public class StateClass {
        final int maxInt = 100000;
        final String outputFile;
        final Predicate<Integer> predicate;
        final Observable<Integer> observable;

        public StateClass(String outputFile, Predicate<Integer> predicate) {
            this.outputFile = outputFile;
            this.predicate = predicate;
            this.observable = Observable.range(1, this.maxInt);
        }

    }
    public static void main(String... args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void testMainWrites(Blackhole blackhole){
        String oddOutFile = "src/main/resources/mainoddout.txt";
        StateClass state1 = new StateClass(oddOutFile, this::keepOdds);
        Disposable dispOdd = writeObsToFile(state1);
        blackhole.consume(dispOdd);

        String evenOutFile = "src/main/resources/mainevenout.txt";
        StateClass state2 = new StateClass(evenOutFile, this::keepEvens);
        Disposable dispEven = writeObsToFile(state2);
        blackhole.consume(dispEven);
    }

    @Benchmark
    public void testThreadWrites(Blackhole blackhole){
        String oddOutFile = "src/main/resources/threadsoddout.txt";
        StateClass state1 = new StateClass(oddOutFile, this::keepOdds);
        Disposable dispOdd = writeObsToFileThreads(state1);
        blackhole.consume(dispOdd);

        String evenOutFile = "src/main/resources/threadsevenout.txt";
        StateClass state2 = new StateClass(evenOutFile, this::keepEvens);
        Disposable dispEven = writeObsToFileThreads(state2);
        blackhole.consume(dispEven);
    }

    public Disposable writeObsToFile(StateClass state){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(state.outputFile))){
            Disposable disposable = state.observable
                    .filter(state.predicate)
                    .forEach(integer -> {
                        bw.write(integer.toString());
                        bw.newLine();
                    });
            return disposable;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Disposable writeObsToFileThreads(StateClass state){

        // can't use try-with-resources or Observable (stream) will be closed
        // before processing is complete and cause an Exception
        // have to close the BufferedWriter as the last Action in the processing chain
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(state.outputFile));
            Disposable disposable = state.observable
                    .subscribeOn(Schedulers.single())
                    .observeOn(Schedulers.io())
                    .filter(state.predicate)
                    .subscribe(integer -> {
                                bw.write(integer.toString());
                                bw.newLine();
                            },
                            this::errorNotify,
                            closeBw(bw)
                    );
            // without the pause, execution is irregular. Stream will only be processed
            // one time in 3 or 4. I suppose the main thread usually finishes before the
            // stream is processed unless the delay is inserted
            // would be better to use a mechanism like thread.join() or future.get() to
            // do the sync. Not sure how to do this with threads created by Schedulers
            pauseMilliSec(1);
            return disposable;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    void errorNotify(Throwable throwable){
        System.out.println("Encountered an Error: " + throwable.toString());
    }

    Action closeBw(BufferedWriter bufferedWriter){
        Action action = () -> {
            try {
                bufferedWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        };
        return action;
    }

    boolean keepEvens(Integer integer){
        return integer % 2 == 0;
    }

    boolean keepOdds(Integer integer){
        return integer % 2 == 1;
    }

}
