package org.example;

import io.reactivex.disposables.Disposable;

public class DeveopmentTemp {
    static public void  main(String... args){
        System.out.println("Beginning of temp execution");

        ReactiveBenchmark rb = new ReactiveBenchmark();
        rb.testMainWrites();
        Disposable disposable = rb.writeObsToFileThreads();
        System.out.println(disposable.toString());
    }
}
