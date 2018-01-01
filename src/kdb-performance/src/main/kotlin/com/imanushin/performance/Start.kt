package com.imanushin.performance

fun main(args: Array<String>) {
    val kxConnection = kx.c("localhost", 40000)

    val result = kxConnection.k("2+3")

    println("result is " + result)
}