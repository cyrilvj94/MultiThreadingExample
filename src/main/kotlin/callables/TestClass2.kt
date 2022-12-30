package callables

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class TestClass2(var num:Int):Callable<List<Int>> {

    val numList = (0..1000).toList()
    fun checkDivisibilityByNum(num:Int):List<Int>{
        return numList.filter{ it%num==0 }.toList()
    }
    override fun call(): List<Int> {
        return checkDivisibilityByNum(this.num)
    }
}
fun main(){
    var futureLst = mutableListOf<Future<List<Int>>>()
    val service: ExecutorService = Executors.newFixedThreadPool(10)
    val divList = listOf<Int>(11,13,17,23,29,37,48,67,97)
    for (number in divList){
        var future:Future<List<Int>> =  service.submit(TestClass2(number))
        futureLst.add(future)
    }
    Thread.sleep(1000)
    var out = futureLst.map{it.get()}
    println(out)
    service.shutdown()
}