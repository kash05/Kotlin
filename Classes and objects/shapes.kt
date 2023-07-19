import java.util.*

class Calculate(val pi:Int,var lsa:Int,var tsa:Int,var vol:Int){

    fun sphere(radius:Int){
        lsa = 4 * pi * radius * radius
        tsa = 3 * pi * radius * radius
        vol = (4/3) * pi * radius * radius * radius
    }

    fun cylinder(radius:Int,height:Int){
        lsa = 2 * pi * radius * height
        tsa = 2 * pi * radius * (radius+height)
        vol = pi * radius * radius * height
    }

    fun cube(side:Int){
        lsa = 4 * side * side
        tsa = 6 * side * side
        vol = side * side * side
    }
}


fun main(){
    val read = Scanner(System.`in`)
    var lsa = 0
    var tsa = 0
    var vol = 0
    val calculate = Calculate(3,lsa,tsa,vol)
    var x = read.nextInt()

    when(x){
        1->{
            var radius = read.nextInt()
            calculate.sphere(radius)
        }
        2->{
            var radius = read.nextInt()
            var height = read.nextInt()
            calculate.cylinder(radius,height)
        }
        3->{
            var side = read.nextInt()
            calculate.cube(side)
        }
    }
      println("${calculate.lsa} ${calculate.tsa} ${calculate.vol}")
}