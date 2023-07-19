class Student( firstName:String = "Kashish"){ //Primary constructor is always initialised with class name at start
    val firstName:String
    var lastName:String? = null

    init{  // Primary Constructor cannot be called without init block
        println("Init block called")
         this.firstName = firstName
    }
        constructor(firstName:String,lastName:String):this(firstName){ //primary constructor must be called (if any) with secondary constructor
            println("Secondary Constructor Called")
            this.lastName = lastName
        }
}

 fun main(){
    val studentName1:Student = Student("Kashish") //object with only first name
    val studentName2:Student = Student("Kashish","Thapliyal") //object with both first and last name
    println("Student Name is ${studentName2.firstName} ${studentName2.lastName}")
 }

 //Primary Constructor can have properties 