JMH 简介JMH(Java Microbenchmark Harness)是用于代码微基准测试的工具套件，主要是基于方法层面的基准测试，
精度可以达到纳秒级。该工具是由 Oracle 内部实现 JIT 的大牛们编写的，他们应该比任何人都了解 JIT 以及 JVM 对于基准测试的影响。
当你定位到热点方法，希望进一步优化方法性能的时候，就可以使用 JMH 对优化的结果进行量化的分析。JMH 比较典型的应用场景如下：
1.想准确地知道某个方法需要执行多长时间，以及执行时间和输入之间的相关性
2.对比接口不同实现在给定条件下的吞吐量
3.查看多少百分比的请求在多长时间内完成

BenchMark 又叫做基准测试，主要用来测试一些方法的性能，
可以根据不同的参数以不同的单位进行计算（例如可以使用吞吐量为单位，也可以使用平均时间作为单位，在 BenchmarkMode 里面进行调整）


微基准测试类型。JMH 提供了以下几种类型进行支持：

类型	描述
Throughput	每段时间执行的次数，一般是秒
AverageTime	平均时间，每次操作的平均耗时
SampleTime	在测试中，随机进行采样执行的时间
SingleShotTime	在每次执行中计算耗时
All	所有模式

@BenchmarkMode(Mode.All)
public class LinkedListIterationBenchMark {
 ...
}
@Benchmark
@BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
public void m() {
 ...
}

@Warmup
这个单词的意思就是预热，iterations = 3就是指预热轮数。
@Benchmark
@BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
@Warmup(iterations = 3)
public void m() {
 ...
}


@Measurement
正式度量计算的轮数。

iterations 进行测试的轮次
time 每轮进行的时长
timeUnit时长单位

@Benchmark
@BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
@Measurement(iterations = 3)
public void m() {
 ...
}

@Threads
每个进程中的测试线程


@Fork
进行 fork 的次数。如果 fork 数是3的话，则 JMH 会 fork 出3个进程来进行测试。

@Benchmark
@BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
@Fork(value = 3)
public void m() {
 ...
}


@OutputTimeUnit
基准测试结果的时间类型。一般选择秒、毫秒、微秒。

@Benchmark
方法级注解，表示该方法是需要进行 benchmark 的对象，用法和 JUnit 的 @Test 类似。

@Param
属性级注解，@Param 可以用来指定某项参数的多种情况。特别适合用来测试一个函数在不同的参数输入的情况下的性能。

@Setup
方法级注解，这个注解的作用就是我们需要在测试之前进行一些准备工作，比如对一些数据的初始化之类的。

@TearDown
方法级注解，这个注解的作用就是我们需要在测试之后进行一些结束工作，比如关闭线程池，数据库连接等的，主要用于资源的回收等。

@State
当使用@Setup参数的时候，必须在类上加这个参数，不然会提示无法运行。

State 用于声明某个类是一个“状态”，然后接受一个 Scope 参数用来表示该状态的共享范围。因为很多 benchmark 会需要一些表示状态的类，JMH 允许你把这些类以依赖注入的方式注入到 benchmark 函数里。Scope 主要分为三种。

Thread: 该状态为每个线程独享。
Group: 该状态为同一个组里面所有线程共享。
Benchmark: 该状态在所有线程间共享。


 /**
     * 仅限于IDE中运行
     * 命令行模式 则是 build 然后 java -jar 启动
     *
     * 1. 这是benchmark 启动的入口
     * 2. 这里同时还完成了JMH测试的一些配置工作
     * 3. 默认场景下，JMH会去找寻标注了@Benchmark的方法，可以通过include和exclude两个方法来完成包含以及排除的语义
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                // 包含语义
                // 可以用方法名，也可以用XXX.class.getSimpleName()
                .include("Helloworld")
                // 排除语义
                .exclude("Pref")
                // 预热10轮
                .warmupIterations(10)
                // 代表正式计量测试做10轮，
                // 而每次都是先执行完预热再执行正式计量，
                // 内容都是调用标注了@Benchmark的代码。
                .measurementIterations(10)
                //  forks(3)指的是做3轮测试，
                // 因为一次测试无法有效的代表结果，
                // 所以通过3轮测试较为全面的测试，
                // 而每一轮都是先预热，再正式计量。
                .forks(3)
             .output("E:/Benchmark.log")
                .build();

        new Runner(opt).run();
    }
