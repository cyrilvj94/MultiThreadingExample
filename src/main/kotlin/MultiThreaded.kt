
class MultiThreaded(var number:Int):Runnable {

    var numList = Utils.numList
    var divList = Utils.divList

    private fun printNumbersDivisibleByNum(num:Int) {
        println("Start $num")
        numList.filter{it%num==0}.forEach { println(it) }
    }
    private fun callPrintNnmbersDivisibleByNum(lst:List<Int>){
        for ( num in lst) printNumbersDivisibleByNum(num)
    }

    override fun run() {
        printNumbersDivisibleByNum(this.number)
    }
}

fun main(){

    val divList = Utils.divList
    var start = System.currentTimeMillis()
    for (number in divList){
        var t:Thread = Thread(MultiThreaded(number))
        t.start()
    }
    var end = System.currentTimeMillis()
    println("**************************** ${end-start}")


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