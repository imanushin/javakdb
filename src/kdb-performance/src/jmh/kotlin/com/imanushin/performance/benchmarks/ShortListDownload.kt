package com.imanushin.performance.benchmarks

import com.imanushin.performance.KdbEnvironment.kxConnection
import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10)
@Measurement(iterations = 100)
open class ShortListDownload {

    private companion object {
        val kdbExpression = "til 1024"
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    fun testOrigin() {
        kxConnection.k(kdbExpression)
    }
}
