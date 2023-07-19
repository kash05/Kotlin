class Student {

   var School:String = "St Theresa"
   var age:Int = 5

   val isTeenager:Boolean
   get() = age>12  //will check set condition and accordingly give value to required field and then checks and given condition and provide output
                   // after getter call value is returned
   var Name:String? = null
   get() = field?:"Unknown" //getter   //cannot use 'name'(i.e variable name) because it will become recursive

   set(value){               // setter
    if(value!=null)field = value 
   }
}

 fun main(){
   
    val student:Student = Student()  //object of class student

    student.age = 20
    println(student.isTeenager)

    student.Name = "Kashish"
    println(student.Name)


 }