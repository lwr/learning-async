/////
package com.github.lwr.learningasync.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val jobs = List(100_000) {
        // create a lot of coroutines and list their jobs
        async {
            delay(1000L)
            print(".")
        }
    }
    jobs.awaitAll() // wait for all jobs to complete
}
