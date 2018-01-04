package com.imanushin.performance.benchmarks

import com.imanushin.performance.KdbEnvironment.kxConnection
import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 100)
@Measurement(iterations = 1000)
open class SimpleSum {

    private companion object {
        val kdbExpression = "2+3"
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    fun testOrigin() {
        kxConnection.k(kdbExpression)
    }
}
