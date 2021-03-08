package com.snail.common

class TestKotlin {

    var testValue: Int = 3;
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun foo(x: Int) {
        fun double(y: Int): Int {
            return y * 2
        }
        println(double(x))
    }

    fun isBig(a: Int): Boolean {
        return a > 1
    }

    fun filter(a: Int, big: (Int) -> Boolean): Boolean {
        val result = big(a)
        println(result)
        return result
    }

    fun filter2(big: () -> Unit) {
        big()

    }

    fun filter3(a: Int, b: Int) = { -> a + b }
    var foo2: (x: Int, y: Int) -> Int = { x: Int, y: Int ->
        if (testValue > 2) {
            x + y
        } else {
            1
        }
    }

    fun foo3(a: Int, b: Int) {

    }

    fun foo4(a: Int) = { b: Int ->
        a + b
    }

    fun foo5(a: Int): (Int) -> Int {
        return { y: Int -> a + y }
    }

    var res: Int? = try {
        var a = 2;
        if (a > 0) {
            a
        }
        null
    } catch (e: Throwable) {
        null
    }
    val mayByInt: Int? = null

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var testKotlin = TestKotlin()
//            var result = testKotlin.sum(1, 2)
//            println(result)
            testKotlin.foo(2)
            testKotlin.filter(2, fun(a: Int): Boolean {
                if (a == 2) {
                    return true
                }
                return false
            })
            testKotlin.filter(2, { a -> a > 2 })
            var result = testKotlin.foo2(1, 2)
            println(result)
            var reuslt2 = testKotlin.foo4(3)(4)
            reuslt2 = testKotlin.foo4(3).invoke(4)
            println(reuslt2)
            val mayBeResult = testKotlin.mayByInt ?: 1
            println(mayBeResult)
        }
    }
}