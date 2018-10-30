package com.github.lwr.learningasync.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun loadProfile(id: Int): Map<String, Any> {
    delay(1000L)
    return mapOf("id" to id, "name" to "foo$id", "avatarUrl" to "url$id")
}


suspend fun loadImage(url: String): String {
    delay(1000L)
    if (url == "url1") {
        return "[massive of data $url ...]"
    } else {
        throw Exception("url can not be load: $url")
    }
}


suspend fun loadAvatarImage(id: Int): String {
    val profile = loadProfile(id)
    return loadImage(profile["avatarUrl"] as String)
}


fun main() = runBlocking {
    println("done sequentially in time: ${measureTimeMillis {
        (1..2).forEach { id ->
            try {
                println("got avatar image data: ${loadAvatarImage(id)}")
            } catch (e: Exception) {
                println("something wrong: $e")
            }
        }
    }}")

    println()
    println("done parallelly in time: ${measureTimeMillis {
        (1..2).map { id ->
            launch(coroutineContext) {
                try {
                    println("got avatar image data: ${loadAvatarImage(id)}")
                } catch (e: Exception) {
                    println("something wrong: $e")
                }
            }
        }.joinAll()
    }}")
}
