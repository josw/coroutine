package com.josw.coroutine

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlinx.coroutines.*

@SpringBootApplication
class CoroutineApplication

fun main(args: Array<String>) {
    runApplication<CoroutineApplication>(*args)



    run()
}

fun run() {
    runBlocking {


        val job = launch {
            delay(1000L)
            println (" WWWWW ")
        }

        val job2 = async {
            delay(1000L)
            println (" async ...")
            "async ... 2"
        }

        println (job2.join())

        println("111111")
        job.join()
        println("222222")



        launch {
            world()
        }
        println("Hello")

        run2()
    }
}

suspend fun world() {
    delay(1000L)
    println("World!!")
}


suspend fun run2() = coroutineScope {

    launch {
        delay(2000L)
        println("World 1 !!")
    }

    launch {
        delay(1000L)
        println("World 2 !!")
    }

    println ("Hello 2")
}

