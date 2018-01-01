package com.imanushin.performance

import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.results.format.ResultFormatType
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder

@State(Scope.Benchmark)
object StartKt{

    @JvmStatic
    fun main(args: Array<String>) {

        val options = OptionsBuilder()
                //                .timeout(TimeValue.seconds(13))
                .include("com.imanushin.performance.test.*")
                .warmupIterations(20)
                .measurementIterations(20)
                .forks(1)
                .threads(355)
                .mode(Mode.Throughput)
                .resultFormat(ResultFormatType.JSON)
                .result("build/jmh-result.json")
                .shouldFailOnError(true)
                .build()

        Runner(options).run()
    }
}
