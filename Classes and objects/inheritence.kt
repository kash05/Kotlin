open class Parent(val name:String ){
    init{
        println("Kashthetic")
    }
    open var age:Int = 1
    open fun doWork(){
        println("Coffee and Code")
    }
}

class children(name:String, val school:String):Parent(name){
    init{
        println("This is a Student")
    }

    override open fun doWork(){
        println("Coffee and Code")
    }
}

fun main(){
    val nameActivity = children("Kash","St Theresa")
    children.doWork()
    // println(children.age)
}