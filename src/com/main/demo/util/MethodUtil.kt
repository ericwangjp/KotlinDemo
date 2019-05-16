package com.main.demo.util

import com.main.demo.main.printManager

//表达式作为函数体，返回类型自动推断
fun plus(a: Int, b: Int) = a + b

fun sum(a: Int, b: Int) = a + b

// 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：无返回值的函数(类似Java中的void)
fun testUnit(a: Int, b: Int) {
    printManager(a + b)
}

//函数的变长参数可以用 vararg 关键字进行标识
fun indefiniteLengthParams(vararg params: String) {
    for (v in params) {
        println(v)
    }
}

/**
 * 可变变量定义：var 关键字
 * var <标识符> : <类型> = <初始化值>
 * 不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
 * val <标识符> : <类型> = <初始化值>
 *     常量与变量都可以没有初始化值,但是在引用前必须初始化
 *     编译器支持自动类型判断,即声明时可以不指定类型,由编译器判断
 *     如果不在声明时初始化则必须提供变量类型
 */
//lambda(匿名函数)
val sumLambda: (Int, Int) -> Int = { x, y -> x + y }

fun dynamicVarbleParams(text:String){
    println("the final result is $text")
    println("another method is ${plus(5,1)}")
}

