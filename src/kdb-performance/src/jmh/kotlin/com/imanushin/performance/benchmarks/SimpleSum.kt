package com.imanushin.performance.benchmarks

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class SimpleSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val opt = OptionsBuilder()
                    .include(".*" + SimpleSum::class.java.simpleName + ".*")
                    .warmupIterations(5)
                    .measurementIterations(5)
                    .forks(1)
                    .build()

            Runner(opt).run()
        }

        private val kxConnection = kx.c("localhost", 40000)
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    fun test() {
        kxConnection.k("2+3")
    }
}
