import java.util.*

class Bank(var initialDeposit:Int,var interest:Float){

    fun depositMoney(deposit:Int){
        initialDeposit += deposit
    }

    fun withdrawMoney(withdraw:Int){
        initialDeposit -= withdraw
    }

    fun addInterest(){
        initialDeposit += (initialDeposit * interest).toInt()
    }

}

fun main(){
    val read = Scanner(System.`in`)
    var initialDeposit = read.nextInt()
    var interest = read.nextFloat()
    val account = Bank(initialDeposit,interest)
    var x = read.nextInt()

    while(x != -1){
    when(x){
        1->{
            var deposit = read.nextInt()
            account.depositMoney(deposit)
        }
        2->{
            var withdraw = read.nextInt()
            account.withdrawMoney(withdraw)
        }
        3-> account.addInterest()
     }
     x = read.nextInt()
  }
   println(account.initialDeposit)
}