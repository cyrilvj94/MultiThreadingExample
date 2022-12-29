import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader

class SingleThreaded {

    var numList = Utils.numList

    fun printNumbersDivisibleByNum(num:Int) {
        println("Start $num")
        numList.filter{it%num==0}.forEach { println(it) }
    }
    fun callPrintNnmbersDivisibleByNum(lst:List<Int>){
        for ( num in lst) printNumbersDivisibleByNum(num)
    }
}

fun main() {
    var singleThread = SingleThreaded()
    var startTime = System.currentTimeMillis()
    singleThread.callPrintNnmbersDivisibleByNum(Utils.divList)
    var endTime = System.currentTimeMillis()
    println("Time taken ${startTime - endTime}")
}