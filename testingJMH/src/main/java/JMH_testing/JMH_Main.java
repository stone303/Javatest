package JMH_testing;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JMH_Main {
    public static void main(String[] args) throws RunnerException {


        Options opt = new OptionsBuilder()
                .include(LinkedListIterationBenchMark.class.getSimpleName())
                .forks(3)
                .warmupIterations(2)
                .measurementIterations(2)
                .output("E:/Benchmark.log")
                .build();

        new Runner(opt).run();
    }
}
