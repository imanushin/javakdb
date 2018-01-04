package com.imanushin.performance.benchmarks

import com.imanushin.performance.KdbEnvironment.kxConnection
import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
open class HugeListDownload {

    private companion object {
        val kdbExpression = "til 1024*1024*64"
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    fun testOrigin() {
        kxConnection.k(kdbExpression)
    }
}
