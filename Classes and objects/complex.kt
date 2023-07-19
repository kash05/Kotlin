import java.util.*

class complexNumber( var real:Int, var imag:Int){

    fun print(){
        println("$real + i$imag")
    }

    fun plus(x:complexNumber){
        real += x.real
        imag += x.imag
    }

    fun multiply(x:complexNumber){
        var sol = complexNumber(x.real * real - x.imag * imag,x.imag * real + x.real * imag)
        real = sol.real 
        imag = sol.imag
    }

}

fun main(){
    val read = Scanner(System.`in`)
    val real1 = read.nextInt()
    val imag1 = read.nextInt()
    val real2 = read.nextInt()
    val imag2 = read.nextInt()

    val C1 = complexNumber(real1,imag1)
    val C2 = complexNumber(real2,imag2)

    when(read.nextInt()){
        1->{
            C1.plus(C2)
            C1.print()
        }
        2->{
            C1.multiply(C2)
            C1.print()
        }
    }

}