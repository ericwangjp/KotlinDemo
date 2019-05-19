package com.main.demo.util

import com.main.demo.main.printManager
import jdk.nashorn.internal.runtime.Context
import java.awt.Window
import java.lang.Exception
import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * kotlin 学习总结
 * 参考：https://www.runoob.com/kotlin/kotlin-extensions.html
 *
 */
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
 * 字符串可以包含模板表达式 ，即一些小段代码，会求值并把结果合并到字符串中。
 * 模板表达式以美元符（$）开头，由一个简单的名字构成
 * 原生字符串和转义字符串内部都支持模板。
 * 如果你需要在原生字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：
 * ${'$'}9.99
 */
fun dynamicVarbleParams(text: String) {
    println("the final result is $text")
    println("another method is ${plus(5, 1)}")
}

/**
 *  Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，字段后加!!像Java一样抛出空异常，
 *  另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
 *  当一个引用可能为 null 值时, 对应的类型声明必须明确地标记为可为 null
 */
//类型后面加?表示可为空
fun nullHandle(txt: String?): Int? {
//抛出空指针异常
    val ages = txt!!.toInt()
//不做处理返回 null
    val ages1 = txt?.toInt()
//age为空返回-1
    val ages2 = txt?.toInt() ?: -1
    return ages1
}

/**
 * 使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)
 * 做过类型判断以后，obj会被系统自动转换为对应类型
 */
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    } else if (obj is Int) {
        return obj
    }
    return null
}

/**
 * 区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成
 */
fun forLoopTest() {
    for (i in 1..4) {
        println(i)
    }
    // 使用 step 指定步长
    for (i in 1..10 step 2) {
        println(i)
    }
    for (i in 4 downTo 1 step 2) {
        println(i)
    }
// 使用 until 函数排除结束元素,i in [1, 5) 排除了 5
    for (i in 1 until 5) {
        println(i)
    }
}

/**
 * 在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小
 */
fun numberCompare() {
    val a = 1000
    println(a === a)    // true，值相等，对象地址相等
    //经过了装箱，创建了两个不同的对象
    val a1: Int? = a
    val a2: Int? = a
    println(a1 === a2)   //false，值相等，对象地址不一样
    println(a1 == a2)    // true，值相等
}

/**
 * 位操作符
 */
fun bitOperation(num: Int) {
    val shl = num.shl(2)  //左移位 (Java’s <<)
    println(shl)
    num.shr(2)  //右移位 (Java’s >>)
    num.ushr(2) //无符号右移位 (Java’s >>>)
    num.and(9)  //与
    num.or(4)   //或
    num.xor(3)  //亦或
    val inv = num.inv()   //反向
    println(inv)
}

fun getArray() {
    val arrayOf = arrayOf(4, 5, 5, 45, 68)
    val array = Array(4) { i -> (i * 3) }
    println(arrayOf[0])
    println(array[0])
    println(array[1])
    println(array[2])
    println(array[3])
}

/**
 * 三个引号 """ 扩起来的字符串，支持多行字符串
 * String 可以通过 trimMargin() 方法来删除多余的空白
 * 默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")
 */
fun printChar() {
    val text = """
        多行字符1
        多行字符2
        多行字符3
    """.trimIndent()
    println(text)
    val text2 = """
        |文本1
        |文本2
        |文本3
        没有边界
        |agbd  fd 4
    """.trimMargin()
    println(text2)
}

/**
 * 一个 if 语句包含一个布尔表达式和一条或多条语句
 * 可以把 IF 表达式的结果赋值给一个变量
 */
fun ifCondition() {
    var a = 1
    if (a < 8) {
        a++
    } else {
        a--
    }
    println("a = $a")
    val num = if (a > 0) a - 5 else a + 5
    println("num = $num")
    val finalNum = if (num > 0) {
        println("num >0")
        100
    } else {
        println("num<=0")
        200
    }
    println("finalNum = $finalNum")
}

/**
 * 使用 in 运算符来检测某个数字是否在指定区间内，区间格式为 x..y
 */
fun inScope() {
    val x = 5
    if (x in 1..9)
        println("x 在区间内")
}

/**
 * when 既可以被当做表达式使用也可以被当做语句使用。如果它被当做表达式，符合条件的分支的值就是整个表达式的值，
 * 如果当做语句使用， 则忽略个别分支的值
 * 在 when 中，else 同 switch 的 default。如果其他分支都不满足条件将会求值 else 分支
 * 如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔
 * 也可以检测一个值在（in）或者不在（!in）一个区间或者集合中
 */
fun whenExpression() {
    val x = (Math.random() * 10).toInt()
    when (x) {
        1 -> println("x = 1")
        in 2..4 -> println("x = 2..4")
        !in 5..8 -> println("not in 5..8")
//        is String -> println("is String")
        is Int -> println("is int")
        2 -> println("x = 2")
        3 -> println("x = 3")
        4 -> println("x = 4")
        5, 6, 7 -> println("x = 5,6,7")
        else -> println("x>7")
    }
}

fun forIterator() {
    val list = listOf("jintian", "mingtian", "haha")
    for (i in list) {
        println("current elements is $i")
    }

    for (i in list.indices) {
        println("--->${list[i]}")
    }

    for ((index, value) in list.withIndex()) {
        println("index = $index ,value = $value")
    }

    for (i in 4 downTo 1) {
        println(i)
    }
//    步长2
    for (i in 1..8 step 2) {
        println(i)
    }
//    不包括10 [1,10)
    for (i in 1 until 10) {
        println(i)
    }

}

/**
 * return。默认从最直接包围它的函数或者匿名函数返回
 * break。终止最直接包围它的循环
 * continue。继续下一次最直接包围它的循环
 * 在 Kotlin 中任何表达式都可以用标签（label）来标记。
 * 标签的格式为标识符后跟 @ 符号，例如：abc@、fooBar@都是有效的标签。
 * 要为一个表达式加标签，我们只要在其前加标签即可
 * 通常情况下使用隐式标签更方便。 该标签与接受该 lambda 的函数同名
 */
fun doAndWhile() {
    var x = 100
    do {
        x--
        if (x > 60) {
            continue
        }
        if (x < 55)
            break
        println("x = $x")
    } while (x > 50)

    task@ for (i in 1..15) {
        println("---> value $i")
        for (j in 1..20) {
            if (i == 10)
                break@task
            println("current value $j")
        }
    }

    val listOf = listOf(1, 12, 45, 45)
    listOf.forEach {
        if (it == 45) {
            return@forEach
        }
        println("list value is $it")
    }
}

/**
 *  Kotlin 类可以包含：构造函数和初始化代码块、函数、属性、内部类、对象声明
 *  Kotlin 中使用关键字 class 声明类，后面紧跟类名
 *  可以定义一个空类：class Empty
 *  类的属性可以用关键字 var 声明为可变的，否则使用只读关键字 val 声明为不可变
 *  可以像使用普通函数那样使用构造函数创建类实例：
 *  val site = KotlinClass() // Kotlin 中没有 new 关键字
 *  要使用一个属性，只要用名称引用它即可
 *  site.name           // 使用 . 号来引用
 *
 */
class KotlinClass { //类名
    //大括号内部是类体构成
    val name = "jack"
    var age = 10
}

/**
 * Koltin 中的类可以有一个主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后
 * 类也可以有二级构造函数，需要加前缀 constructor
 * 如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。在同一个类中代理另一个构造函数使用 this 关键字
 * 我们可以使用this关键字来调用自己的其他构造器，并且需要注意它的语法形式，次级构造器: this(参数列表)
 * 可以使用super关键字来调用父类构造器
 */
class Person constructor(firstName: String) {
    constructor(name: String, age: Int) : this(name) {
        println(age)
    }

    constructor(name: String, age: Int, address: String) : this(name, age) {
        println(age)
    }
}

/**
 * 如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略
 * getter 和 setter 都是可选
 * 如果属性类型可以从初始化语句或者类的成员函数中推断出来，那就可以省去类型，val不允许设置setter函数，因为它是只读的
 * getter 和 setter属性声明的完整语法：
 * var <propertyName>[: <PropertyType>] [= <property_initializer>]
 *      [<getter>]
 *      [<setter>]
 *  eg:
 *  var lastName: String = "zhang"
 *  get() = field.toUpperCase()   // 将变量赋值后转换为大写
 *  set
 *  Kotlin 中类不能有字段。提供了 Backing Fields(后端变量) 机制,备用字段使用field关键字声明,field 关键词只能用于属性的访问器
 *  非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性
 *  主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
 *  主构造器的参数可以在初始化代码段中使用，也可以在类主体定义的属性初始化代码中使用。
 *  一种简洁语法，可以通过主构造器来定义属性并初始化属性值（可以是var或val）
 *  如果构造器有注解，或者有可见度修饰符，这时constructor关键字是必须的，注解和修饰符要放在它之前。
 *
 */
class PersonTwo(firstName: String) {
    var lastName: String = "zhang"
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set

    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = 145.4f
        private set
    lateinit var subject: String

    init {
        println("this is init method")
    }

}

/**
 * 如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。构造函数是 public 。
 * 如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数
 */
class PersonPrivate private constructor() {}

/**
 * 在 JVM 虚拟机中，如果主构造函数的所有参数都有默认值，编译器会生成一个附加的无参的构造函数，
 * 这个构造函数会直接使用默认值。这使得 Kotlin 可以更简单的使用像 Jackson 或者 JPA 这样使用无参构造函数来创建类实例的库。
 */
class Customer(val customerName: String = "")

/**
 * 无需对抽象类或抽象成员标注open注解
 * final       // 类不可继承，默认属性
 * open        // 类可继承，类默认是final的
 * private    // 仅在同一个文件中可见
 * protected  // 同一个文件中或子类可见
 * public     // 所有调用的地方都可见
 * internal   // 同一个模块中可见
 *
 */
abstract class abstractClassTest {
    abstract fun test()
}

/**
 * 可以把类嵌套在其他类中,调用格式：外部类.嵌套类.嵌套类方法/属性
 * 内部类使用 inner 关键字来表示
 * 内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数
 * 为了消除歧义，要访问来自外部作用域的 this，我们使用this@label，其中 @label 是一个 代指 this 来源的标签
 * 内部类可以直接通过 this@ 外部类名 的形式引用外部类的成员变量，不需要创建外部类对象
 * var demo = Outter.Nested()// 嵌套类，Outter后边没有括号
 * var demo = Outter().Inner();// 内部类，Outter后边有括号
 * object : TestInterFace，这个 object 是 Kotlin 的关键字，要实现匿名内部类，就必须使用 object 关键字，不能随意替换其它单词
 */
class Outer {
    private val bar: Int = 1
    var v = "成员属性"

    /**嵌套内部类**/
    inner class Inner {
        fun foo() = bar  // 访问外部类成员
        fun innerTest() {
            var o = this@Outer //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }
}

/**
 * Kotlin 中所有类都继承该 Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类
 * 如果一个类要被继承，可以使用 open 关键字进行修饰,方法需要重写，也需要使用open关键字修饰
 * 如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数。
 * 初始化基类时，可以调用基类的不同构造方法
 * 在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。
 * 如果允许子类重写该函数，那么就要手动添加 open 修饰它, 子类重写方法使用 override 关键词
 * 子类继承父类时，不能有跟父类同名的变量，除非父类中该变量为 private，或者父类中该变量为 open 并且子类用override 关键字重写
 * 子类不一定要调用父类和接口中共同拥有的同名的方法
 */
class Example

open class Base(name: String) {
    val n = name
    open fun test() {
        println("this is base $n!")
    }
}

class Child(name: String, private val age: Int) : Base(name) {
    fun childTest() {
        println("child age = $age")
    }

    override fun test() {
        super.test()
        println("child override parent method")
    }

}

class ChildTest : Base {
    constructor(name: String, age: Int) : super(name)
    constructor(name: String, context: Context) : this(name, 18)
}

open class A {
    open fun f() {
        println("A")
    }

    fun a() {
        println("a")
    }
}

interface B {
    //接口的成员变量默认是 open 的
    fun f() {
        println("B")
    }

    fun b() {
        println("b")
    }
}

class C : A(), B {
    override fun f() {
        super<A>.f()//调用 A.f()
        super<B>.f()//调用 B.f()
    }
}

/**
 * Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现
 * 一个类或者对象可以实现一个或多个接口
 * 接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性
 *
 */
interface MyInterface {
    var name: String //name 属性, 抽象的
    fun test1()
    fun test2() {
        println("interface default impl") // 可选的方法体
    }
}

class MyTest : MyInterface {
    override var name: String = "myTest"    //重写属性

    override fun test1() {
        println("mytest test1")
    }

}

/**
 * Kotlin 可以对一个类的属性和方法进行扩展，且不需要继承或使用 Decorator 模式
 * 扩展是一种静态行为，对被扩展的类代码本身不会造成任何影响
 * 扩展函数可以在已有类中添加新的方法，不会对原类做修改，扩展函数定义形式：
 * fun receiverType.functionName(params){
 *      body
 * }
 * receiverType：表示函数的接收者，也就是函数扩展的对象
 * functionName：扩展函数的名称
 * params：扩展函数的参数，可以为NULL
 * 若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数
 * 在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数
 * eg:
 *      fun Any?.toString(): String {
 *      if (this == null) return "null"
 *      // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
 *      // 解析为 Any 类的成员函数
 *       return toString()
 *     }
 *
 */
fun MyTest.addMethod() {
    println("我是扩展方法")
}

/**
 * 扩展属性:
 *      扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。初始化属性因为属性没有后端字段（backing field），
 *      所以不允许被初始化，只能由显式提供的 getter/setter 定义
 *      扩展属性只能被声明为 val
 */
val <T> List<T>.lastIndex: Int
    get() = size - 1

/**
 * 如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性
 * 伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用
 *  MyClass.foo()
 */
class MyClass {
    companion object {}  // 将被称为 "Companion"
}

fun MyClass.Companion.foo() {
    println("伴随对象的扩展函数")
}

val MyClass.Companion.no: Int
    get() = 10

/**
 * Kotlin 可以创建一个只包含数据的类，关键字为 data
 * 编译器会自动的从主构造函数中根据所有声明的属性提取以下函数：
 *      equals() / hashCode()
 *      toString() 格式如 "User(name=John, age=42)"
 *      componentN() functions 对应于属性，按声明顺序排列
 *      copy() 函数
 * 如果这些函数在类中已经被明确定义了，或者从超类中继承而来，就不再会生成。
 * 数据类需要满足以下条件：
 *      主构造函数至少包含一个参数。
 *      所有的主构造函数的参数必须标识为val 或者 var
 *      数据类不可以声明为 abstract, open, sealed 或者 inner
 *      数据类不能继承其他类 (但是可以实现接口)
 *  复制使用 copy() 函数，我们可以使用该函数复制对象并修改部分属性, 对于上文的 User 类，其实现会类似下面这样：
 *      fun copy(name: String = this.name, age: Int = this.age) = User(name, age)
 *
 */
data class User(val name: String, val age: Int)

/**
 * 密封类用来表示受限的类继承结构。密封类的一个子类可以有可包含状态的多个实例
 * 声明一个密封类，使用 sealed 修饰类，密封类可以有子类，但是所有的子类都必须要内嵌在密封类中
 * sealed 不能修饰 interface ,abstract class(会报 warning,但是不会出现编译错误)
 * 使用密封类的关键好处在于使用 when 表达式 的时候，如果能够 验证语句覆盖了所有情况，就不需要为该语句再添加一个 else 子句了
 * 用 object 关键字创建单例
 */
sealed class Expr

/**
 * 泛型，即 "参数化类型"，将类型参数化，可以用在类，接口，方法上
 * Kotlin 泛型函数的声明与 Java 相同，类型参数要放在函数名的前面
 */
class Box<T>(t: T) {
    var value = t

    fun <H> test(value: H) {
        println("泛型函数")
    }
}

/**
 * Kotlin 中没有通配符类型，它有两个其他的东西：声明处型变（declaration-site variance）与类型投影（type projections）
 * 声明处的类型变异使用协变注解修饰符：in、out，消费者 in, 生产者 out
 * 使用 out 使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型但是无法作为入参的类型
 * eg:
 *      var strCo: Runoob<String> = Runoob("a")
 *      var anyCo: Runoob<Any> = Runoob<Any>("b")
 *       anyCo = strCo
 *       println(anyCo.foo())   // 输出 a
 */
// 定义一个支持协变的类
class Runoob<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

/**
 * in 使得一个类型参数逆变，逆变类型参数只能用作输入，可以作为入参的类型但是无法作为返回值的类型
 * eg:
 *      var strDCo = Runoob("a")
 *      var anyDCo = Runoob<Any>("b")
 *      strDCo = anyDCo
 */
// 定义一个支持逆变的类
class RunoobU<in A>(a: A) {
    fun foo(a: A) {
    }
}

/**
 * 星号投射:
 *  Function<*, String> , 代表 Function<in Nothing, String> ;
 *  Function<Int, *> , 代表 Function<Int, out Any?> ;
 *  Function<, > , 代表 Function<in Nothing, out Any?> .
 */

/**
 * 枚举常量用逗号分隔,每个枚举常量都是一个对象
 * 每一个枚举都是枚举类的实例，它们可以被初始化
 * 默认名称为枚举字符名，值从0开始。若需要指定值，则可以使用其构造函数
 *
 */
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
}

/**
 * 枚举还支持以声明自己的匿名类及相应的方法、以及覆盖基类的方法
 * 如果枚举类定义任何成员，要使用分号将成员定义中的枚举常量定义分隔开
 */
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

/**
 *  通过对象表达式实现一个匿名内部类的对象用于方法的参数中
 *  对象可以继承于某个基类，或者实现其他接口
 */


interface AB {
    fun setText(test: String)
}

open class TestA {
    var ab: AB? = null
    fun setListener(listener: AB) {
        ab = listener
    }

    fun hahaTest() {
        println("开始调用")
        ab?.setText("回调接口")
    }
}

/**
 * 如果超类型有一个构造函数，则必须传递参数给它。多个超类型和接口可以用逗号分隔
 * 通过对象表达式可以越过类的定义直接得到一个对象
 * 匿名对象可以用作只在本地和私有作用域中声明的类型。如果你使用匿名对象作为公有函数的 返回类型或者
 * 用作公有属性的类型，那么该函数或属性的实际类型 会是匿名对象声明的超类型，如果你没有声明任何超类型，就会
 * 是 Any。在匿名对象 中添加的成员将无法访问
 * 在对象表达中可以方便的访问到作用域中的其他变
 */
class CX {
    val tesa: TestA = object : TestA(), AB {
        override fun setText(test: String) {
            println("override")
        }
    }

    fun ab() {
        val site = object {
            var name: String = "菜鸟教程"
            var url: String = "www.runoob.com"
        }
        println(site.name)
        println(site.url)
    }

    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // 没问题
//        val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}

/**
 *  Kotlin 使用 object 关键字来声明一个对象
 *  Kotlin 中我们可以方便的通过对象声明来获得一个单例
 *  引用该对象，我们直接使用其名称即可:
 *      DataProviderManager.registerDataProvider(……)
 *  当然你也可以定义一个变量来获取获取这个对象，当时当你定义两个不同的变量来获取这个对象时，你会发现你并不
 *  能得到两个不同的变量。也就是说通过这种方式，我们获得一个单例
 *  var data1 = DataProviderManager
 *  var data2 = DataProviderManager
 *  data1 == data2
 *  对象可以有超类型 object DefaultListener : MouseAdapter()
 *  与对象表达式不同，当对象声明在另一个类的内部时，这个对象并不能通过外部类的实例访问到该对象，
 *  而只能通过类名来访问，同样该对象也不能直接访问到外部类的方法和变量
 */
object DataProviderManager {
    fun registerDataProvider(provider: String) {
        // ……
    }

    val allDataProviders: Collection<String>?
        get() = null// ……
}

/**
 * 类内部的对象声明可以用 companion 关键字标记，这样它就与外部类关联在一起，
 * 我们就可以直接通过外部类访问到对象的内部元素
 *
 */
class MyClassA {
    companion object Factory {
        fun create(): MyClassA = MyClassA()
    }
}

val instance = MyClassA.create()   // 访问到对象的内部元素

/**
 * 可以省略掉该对象的对象名，然后使用 Companion 替代需要声明的对象名
 * 一个类里面只能声明一个内部关联对象，即关键字 companion 只能使用一次
 * 伴生对象的成员看起来像java的静态成员，但在运行时他们仍然是真实对象的实例成员
 * 对象表达式和对象声明之间的语义差异:
 *      对象表达式是在使用他们的地方立即执行的
 *      对象声明是在第一次被访问到时延迟初始化的
 *      伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配
 */
class MyClassB {
    companion object {
        val txt = "123"
    }
}

val x = MyClassB.Companion

/**
 * kotlin 委托:
 *  委托模式是软件设计模式中的一项基本技巧。在委托模式中，有两个对象参与处理同一个请求，
 *  接受请求的对象将请求委托给另一个对象来处理。
 *  Kotlin 直接支持委托模式，Kotlin 通过关键字 by 实现委托
 *  类的委托即一个类中定义的方法实际是调用另一个类的对象的方法来实现的
 *  eg:
 *   val b = BaseImpl(10)
 *   Derived(b).print() // 输出 10
 *  属性委托指的是一个类的某个属性值不是在类中直接进行定义，而是将其托付给一个代理类，从而实现对该类的属性统一管理
 *  属性委托语法格式：
 *      val/var <属性名>: <类型> by <表达式>
 *  by 关键字之后的表达式就是委托, 属性的 get() 方法(以及set() 方法)将被委托给这个对象的 getValue() 和 setValue()方法
 *  属性委托不必实现任何接口, 但必须提供 getValue() 函数(对于 var属性,还需要 setValue() 函数)
 *
 */
// 创建接口
interface IBase {
    fun print()
}

// 实现此接口的被委托的类
class BaseImpl(val x: Int) : IBase {
    override fun print() {
        print(x)
    }
}

// 通过关键字 by 建立委托类
class Derived(b: IBase) : IBase by b

/**
 * 延迟属性 Lazy:
 * lazy() 是一个函数, 接受一个 Lambda 表达式作为参数, 返回一个 Lazy <T> 实例的函数，返回的实例可以作为实现延迟属性的委托
 * 第一次调用 get() 会执行已传递给 lazy() 的 lamda 表达式并记录结果， 后续调用 get() 只是返回记录的结果
 *  lazy 操作符是线程安全的
 */
val lazyValue: String by lazy {
    println("computed!")     // 第一次调用输出，第二次调用不执行
    "Hello"
}

/**
 * observable 可以用于实现观察者模式
 * Delegates.observable() 函数接受两个参数: 第一个是初始化值, 第二个是属性值变化事件的响应器(handler)
 * 在属性赋值后会执行事件的响应器(handler)，它有三个参数：被赋值的属性、旧值和新值：
 * notNull 适用于那些无法在初始化阶段就确定属性值的场合,如果属性在赋值前就被访问的话则会抛出异常
 * 可以将局部变量声明为委托属性
 * 属性委托要求：
 *  对于只读属性(也就是说val属性), 它的委托必须提供一个名为getValue()的函数。该函数接受以下参数：
 *  thisRef —— 必须与属性所有者类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型
 *  property —— 必须是类型 KProperty<*> 或其超类型
 *  这个函数必须返回与属性相同的类型（或其子类型）
 *  对于一个值可变(mutable)属性(也就是说,var 属性),除 getValue()函数之外,它的委托还必须 另外再提供一个名为setValue()的函数, 这个函数接受以下参数:
 *  property —— 必须是类型 KProperty<*> 或其超类型
 *  new value —— 必须和属性同类型或者是它的超类型
 *
 */
class DelegateClass {
    var name: String by Delegates.observable("init data") { kProperty: KProperty<*>, s: String, s1: String ->
        println("旧值：$s,新值：$s1")
    }
}
//------------------------------------------------------------------ 委托 ---------------------------------------------------------------------
/**
 * 通过定义 provideDelegate 操作符，可以扩展创建属性实现所委托对象的逻辑。
 * 如果 by 右侧所使用的对象将 provideDelegate 定义为成员或扩展函数，那么会调用该函数来创建属性委托实例
 * provideDelegate 的一个可能的使用场景是在创建属性时（而不仅在其 getter 或 setter 中）检查属性一致性。
 * provideDelegate 的参数与 getValue 相同：
 *  thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型
 *  property —— 必须是类型 KProperty<*> 或其超类型。
 *  重载操作符的函数需要用 operator关键字标记
 *  在Kotlin中，可以对任何对象使用比较运算符(==、!=、 >、<)等,可以不用像Java那种调用equals,compareTo函数
 *  使用==会转换成equals方法调用；但== 与 !=更安全，会自动检测是否为 null，如果不为null，才进行判断:
 *      即：a == b ===> a?.equals(b) ?: (b==null)
 */
class ResourceLoader(private val id: ResourceId) {
    operator fun provideDelegate(thisRef: MyUI, prop: KProperty<*>): ReadOnlyProperty<MyUI, String> {
        return if (checkProperty(thisRef, prop.name)) {
            DellImpl(id)
        } else {
            throw Exception("error ${prop.name}")
        }
    }

    private fun checkProperty(thisRef: MyUI, name: String): Boolean {
        return name == "image" || name == "text"
    }
}

class DellImpl(private val id: ResourceId) : ReadOnlyProperty<MyUI, String> {
    override fun getValue(thisRef: MyUI, property: KProperty<*>): String {
        return if (property.name.equals("image"))
            property.name + "_" + id.imageId
        else
            property.name + "_" + id.textId
    }

}

class ResourceId {
    val imageId: String = "100"
    val textId: String = "101"
}

fun bindResource(id: ResourceId) = ResourceLoader(id)

class MyUI {
    val image by bindResource(ResourceId())
    val text by bindResource(ResourceId())
//    val age by bindResource(ResourceId())
}