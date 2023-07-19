fun main(){
    //store functions inside a variable
    //regular functions
    val f1:( Int, Int )/*parameter*/ -> Int //return type
    val f2:( Int, Int ) -> Boolean

    val f0:() -> Unit // no parameter and does not return anything

    val f3:(( String)  -> Int)? //Nullable

    val f1 = ::addInt //we can store regular functions in a variable using double colon

    //lambda -> codeblock for a function -> stores parameter and returns -> uses curly braces

    f2 = {x:Int, y:Int -> x > y} //last line is return value

    //anonymous function -> regular functions without name

    f3 = fun( s:String ) :Int{ return s.length }

    // invoke a function -> can be invoked using invoke keyword or by just passing parameter to variable assigned to fuction

    f1.invoke(2,3)
    f2(6,5)
    f3("Kash")

}

    fun addInt(x:Int, y:Int ):Int{
        return x+y
    }

