package practice

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){
   runBlocking {
       awaiting2()
       println("Hi")
   }
}

suspend fun awaiting2(){
    coroutineScope {
        delay(1000)
        println("Hello")
    }
}