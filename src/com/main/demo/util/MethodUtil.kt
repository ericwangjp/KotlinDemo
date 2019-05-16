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

/**
 * $ 表示一个变量名或者变量值
 * $varName 表示变量值
 * ${varName.fun()} 表示变量的方法返回值
 */
fun dynamicVarbleParams(text: String) {
    println("the final result is $text")
    println("another method is ${plus(5, 1)}")
}

/**
 *  Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，字段后加!!像Java一样抛出空异常，
 *  另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
 */
//类型后面加?表示可为空
fun nullHandle(txt: String?):Int {
//抛出空指针异常
    val ages = txt!!.toInt()
//不做处理返回 null
    val ages1 = txt?.toInt()
//age为空返回-1
    val ages2 = txt?.toInt() ?: -1
    return ages
}

