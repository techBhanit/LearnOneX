package com.bhanit.learnonex.splash

object ClassB {
}
open class A {
    fun aMethod() {}
}

abstract class C : MyAbstract() {


}

// we can not create the instance of abstract class as well as interface
abstract class MyAbstract {
    /*Concerete method: a method having defination*/
    fun doWork() {

    }

    /*abstract method*/
    abstract fun doUndefinedWork()
}

interface MyInterface {

    /*abstract method*/
    fun doUndefinedWork()
}


