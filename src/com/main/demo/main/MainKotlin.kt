package com.main.demo.main

import com.main.demo.util.*

fun main() {
    val tag = "tag------------>"
    println("hello world!")
    println("$tag start test project <--------------")
    testMethod()
    println("$tag end test project <--------------")
}

fun printManager(msg: String?) {
    println("------> start invoke method <--------")
    println("------> the result is $msg <--------")
    println("------> end invoke method <--------")
}

fun printManager(msg: Int?) {
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
//    println(nullHandle("12"))
//    printManager(getStringLength(100))
//    forLoopTest()
//    println(1_0000_000)
//    numberCompare()
//    bitOperation(12)
//    getArray()
//    printChar()
//    ifCondition()
//    inScope()
//    whenExpression()
//    forIterator()
//    doAndWhile()
//    val child = Child("same", 18)
//    child.childTest()
//    child.test()
//    val c = C()
//    c.a()
//    c.b()
//    c.f()
//    val myTest = MyTest()
//    myTest.test1()
//    myTest.test2()
//    myTest.addMethod()
//    val testA = TestA()
//    testA.setListener(object : AB {
//        override fun setText(test: String) {
//            println("接口回调--》$test")
//        }
//    })
//    testA.hahaTest()

//    val delegateClass = DelegateClass()
//    delegateClass.name = "abd"
//    delegateClass.name = "123"

    val myUI = MyUI()
    println(myUI.image)
    println(myUI.text)
}







