package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        awaiting()
        println("hiii")
    }
}
suspend fun awaiting(){
    delay(1000)
    print("hello")
}