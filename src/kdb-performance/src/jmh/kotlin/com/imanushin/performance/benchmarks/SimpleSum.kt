package com.imanushin.performance.benchmarks

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.results.format.ResultFormatType
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 100)
@Measurement(iterations = 1000)
open class SimpleSum {

    companion object {
        private val kxConnection = kx.c("localhost", 40000)
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    fun test() {
        kxConnection.k("2+3")
    }
}
