/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import bjack.BJackGameSim;
import streams.ParallelStreamsDemo;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class MyBenchmark {

    // Important note: remember to use the 'uberjar' named benchmarks.jar when running
    // from the command line rather than test-1.0.0.jar
    // from cmd line: java -cp ./target/benchmarks.jar org.example.MyBenchmark

    public static void main(String... args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void bmark2threads() {
        String dbConfigFilePath = "src/main/resources/config.txt";

        BJackGameSim bJackGameSim = new BJackGameSim(5000, 2, dbConfigFilePath);
        bJackGameSim.playGameWrapper();
        bJackGameSim.dbMgr.truncateTable("dealerhands");
        bJackGameSim.dbMgr.truncateTable("playerhands");
    }

    @Benchmark
    public void bmark8threads(){
        String dbConfigFilePath = "src/main/resources/config.txt";

        BJackGameSim bJackGameSim = new BJackGameSim(5000, 8, dbConfigFilePath);
        bJackGameSim.playGameWrapper();
        bJackGameSim.dbMgr.truncateTable("dealerhands");
        bJackGameSim.dbMgr.truncateTable("playerhands");
    }

    @Benchmark
    public void bmarkNormalStream(){
        ParallelStreamsDemo parallelStreamsDemo = new ParallelStreamsDemo();
        parallelStreamsDemo.timeNormalStream();
    }

    @Benchmark
    public void bmarkParallelStream(){
        ParallelStreamsDemo parallelStreamsDemo = new ParallelStreamsDemo();
        parallelStreamsDemo.timeParallelStream();
    }
}
