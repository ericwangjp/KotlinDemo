package com.main.demo.main

import com.main.demo.util.*

fun main() {
    val tag = "tag------------>"
    println("hello world!")
    println("$tag start test project <--------------")
    testMethod()
    println("$tag end test project <--------------")
}

fun printManager(msg: String) {
    println("------> start invoke method <--------")
    println("------> the result is $msg <--------")
    println("------> end invoke method <--------")
}

fun printManager(msg: Int) {
    println("------> start invoke method <--------")
    println("===> 执行结果: $msg <===")
    println("------> end invoke method <--------")
}

//函数定义使用关键字 fun，参数格式为：参数 : 类型
fun testMethod() {
//    printManager(sum(5, 6))
//    printManager(plus(5, 8))
//    testUnit(8, 9)
//    indefiniteLengthParams("i", "am", "happy", "today")
//    println(sumLambda(5,6))
//    dynamicVarbleParams("haha-->")
//    println(nullHandle("ha"))
}







