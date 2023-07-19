import java.util.*

class Deck{

    private var count = 52
    private var deck = Array(4) { BooleanArray(13) }


    fun remove(num:Int,sign:Char){
        deck[sign-'a'][num] = true
        count--
    }

    fun probability(card:Int):Int{
        var inDeck = 0
        for(i in 0..3){
            if(!deck[i][card])
            inDeck++
        }

        val ans = inDeck * 1000 / count.toDouble()
            return ans.toInt()
    


    }
 }



fun main(){
    
    val read = Scanner(System.`in`)
    val deck = Deck()

    var input = read.nextInt()

    while(input != -1){
    when(input){
        1->{
            val num = read.nextInt()
            val sign:Char = read.next()[0]
            deck.remove(num,sign)
        }
        2->{
            val card = read.nextInt()
            println(deck.probability(card))
        }
    }
    input = read.nextInt()
  }
}