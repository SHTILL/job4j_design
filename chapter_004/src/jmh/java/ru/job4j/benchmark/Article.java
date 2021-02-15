package ru.job4j.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class Article {
    FindMatches fullScan = new FullScan();
    FindMatches scanWithSet = new ScanWithSet();
    String[] originTokens;
    String[] lineTokens;

    @Param({"Мой дядя самых честных правил, "
            + "Когда не в шутку занемог, "
            + "Он уважать себя заставил "
            + "И лучше выдумать не мог. "
            + "Его пример другим наука; "
            + "Но, боже мой, какая скука "
            + "С больным сидеть и день и ночь, "
            + "Не отходя ни шагу прочь! "
            + "Какое низкое коварство "
            + "Полуживого забавлять, "
            + "Ему подушки поправлять, "
            + "Печально подносить лекарство, "
            + "Вздыхать и думать про себя: "
            + "Когда же черт возьмет тебя!"})
    public String origins;

    @Param({"Мой дядя мог думать про тебя и день и ночь",
            "Мой дядя мог думать про Linux и Java день и ночь"})
    public String lines;

    public boolean measure(FindMatches f, String[] origin, String[] line) {
        return (f.include(origin, line));
    }

    @Setup
    public void prepare() {
        originTokens = split(origins);
        lineTokens = split(lines);
    }

    @Benchmark
    @Warmup(iterations = 1, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public boolean measureFullScan() {
        return measure(fullScan, originTokens, lineTokens);
    }

    @Benchmark
    @Warmup(iterations = 1, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public boolean measureScanWithSet() {
        return measure(scanWithSet, originTokens, lineTokens);
    }

    private static String[] split(String s) {
        return s.split("[\\p{Space}\\p{Punct}]+?");
    }
    public static boolean generateBy(String origin, String line, FindMatches f) {
        String[] originTokens = split(origin);
        String[] lineTokens = split(line);
        return f.include(originTokens, lineTokens);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Article.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}
