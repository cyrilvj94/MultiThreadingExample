import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ExecutorImpl(var num:Int):Runnable {

    var numList = Utils.numList
    var divList = Utils.divList

    private fun printNumbersDivisibleByNum(num:Int) {
        println("Start $num Thread ${Thread.currentThread().name}")
        numList.filter{it%num==0}.forEach { println(it) }
    }
    override fun run() {
        printNumbersDivisibleByNum(this.num)
    }
}

fun main(){

    val service:ExecutorService = Executors.newFixedThreadPool(2)
    var start = System.currentTimeMillis()
    for ( i in Utils.divList){
        service.execute(ExecutorImpl(i))
    }
    var end = System.currentTimeMillis()
    println("**************************Time taken = ${end - start}")
    service.shutdown()

    /*
    Spin off a single thread like other -> Here functionality is simimlar to single threaded approach
    val t = Thread(MultiThreaded())
    val startTime = System.currentTimeMillis()
    t.start()
    t.join()
    val endTime = System.currentTimeMillis()
    println("Time taken ${startTime-endTime}")
    println("Ended")
     */

}