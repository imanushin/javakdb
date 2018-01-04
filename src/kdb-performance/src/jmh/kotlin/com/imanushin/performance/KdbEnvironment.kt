package com.imanushin.performance

internal object KdbEnvironment {
    val kxConnection = kx.c("localhost", 40000)
}